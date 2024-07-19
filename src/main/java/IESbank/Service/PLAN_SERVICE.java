package IESbank.Service;

import IESbank.Bindings.PLAN_FORM;

import java.util.List;

public interface PLAN_SERVICE {

    public boolean createAccount(PLAN_FORM planForm);

    public List<PLAN_FORM> fetchPlansForms();

    public PLAN_FORM getPlanById(Integer planId);

    public String changePlanStatus(Integer planId, String status);

}
