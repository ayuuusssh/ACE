package IESbank.Service;

import IESbank.Bindings.DASHBOARDS_CARDS;
import IESbank.Bindings.LOGIN_FORM;
import IESbank.Entity.ELIGIBILITY_DETAILS;
import IESbank.Entity.IES_USER;
import IESbank.Repository.ELIGIBILITY_Repository;
import IESbank.Repository.IES_PLANS_Repository;
import IESbank.Repository.IES_USER_Repository;
import IESbank.Utils.EMAIL_UTILS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.DoubleStream;

@Service
public class USER_Service_Impl implements USER_SERVICE {
    @Autowired
    private IES_USER_Repository iesUserRepository;
    @Autowired
    private EMAIL_UTILS emailUtils;
    @Autowired
    private IES_PLANS_Repository iesPlansRepository;
    @Autowired
    private ELIGIBILITY_Repository eligibilityRepository;

    @Override
    public String login(LOGIN_FORM login) {
      IES_USER users =  iesUserRepository.findByEmailAndPwd(login.getEmail(),login.getPassword());
        if(users==null){
            return "Invalid Credentials";
        }
        if("Y".equals(users.getACTIVE_SW())&&"UNLOCKED".equals(users.getACCOUNT_STATUS())){
            return "Login Success@role="+users.getRoleId();
        }else{
            return "ACCOUNT LOCKED/In-active";
        }
    }

    @Override
    public boolean recoverPwd(String email) {

        IES_USER entity = iesUserRepository.findByEmail(email);
        if(null == entity){
            return false;
        }else{
            String subject="";
            String body="";
            return emailUtils.sendEmail(subject,body,email);
        }
    }

    @Override
    public DASHBOARDS_CARDS fetchDashboardInfo() {

        List<ELIGIBILITY_DETAILS> details = eligibilityRepository.findAll();
        long approvedCnt =
                details.stream().filter(ed->ed.getPlanStatus().equals("AP")).count();
        long deniedCnt =
                details.stream().filter(ed->ed.getPlanStatus().equals("DN")).count();
        Double total = details.stream().mapToDouble(ed->ed.getBenefitAmtGiven()).sum();

        long plansCount = iesPlansRepository.count();
        DASHBOARDS_CARDS card = new DASHBOARDS_CARDS();
        card.setPlanCnt(plansCount);
        card.setApprovedCnt(approvedCnt);
        card.setDeniedCnt(deniedCnt);
        card.setBenefitAmtGiven(total);
        return card;
    }
}
