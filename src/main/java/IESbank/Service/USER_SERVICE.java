package IESbank.Service;

import IESbank.Bindings.DASHBOARDS_CARDS;
import IESbank.Bindings.LOGIN_FORM;

public interface USER_SERVICE {

    public String login(LOGIN_FORM login);

    public boolean recoverPwd(String email);

    public DASHBOARDS_CARDS fetchDashboardInfo();

}
