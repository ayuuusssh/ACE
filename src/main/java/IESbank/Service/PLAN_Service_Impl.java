package IESbank.Service;

import IESbank.Bindings.PLAN_FORM;

import IESbank.Bindings.USER_ACCOUNT_FORM;
import IESbank.Entity.IES_PLANS;
import IESbank.Entity.IES_USER;
import IESbank.Repository.IES_PLANS_Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PLAN_Service_Impl implements PLAN_SERVICE {
@Autowired
private IES_PLANS_Repository iesPlansRepository;
    @Override
    public boolean createAccount(PLAN_FORM planForm) {

        IES_PLANS form = new IES_PLANS();
        BeanUtils.copyProperties(planForm,form);

        form.setPlanStartDate(LocalDate.now());
        form.setPlanEndDate(LocalDate.now().plusMonths(1));
        iesPlansRepository.save(form);
        return true;
    }

    @Override
    public List<PLAN_FORM> fetchPlansForms() {
        List<IES_PLANS> entity = iesPlansRepository.findAll();
        List<PLAN_FORM> forms = new ArrayList<>();
        for(IES_PLANS iesPlans : entity){
            PLAN_FORM planForm = new PLAN_FORM();
            BeanUtils.copyProperties(iesPlans,planForm);
            forms.add(planForm);
        }

        return forms;
    }

    @Override
    public PLAN_FORM getPlanById(Integer planId) {
        Optional<IES_PLANS> optional = iesPlansRepository.findAllById(planId);
        if(optional.isPresent()) {
            IES_PLANS iesPlans = optional.get();
            PLAN_FORM user = new PLAN_FORM();
            BeanUtils.copyProperties(iesPlans, user);
            return user;
        }
        return null;
    }

    @Override
    public String changePlanStatus(Integer planId, String status) {
        int cnt =iesPlansRepository.updateAccStatus( planId, status);
        if(cnt>0){
            return "Status Changed";
        }
        return "failed to change";
    }
}
