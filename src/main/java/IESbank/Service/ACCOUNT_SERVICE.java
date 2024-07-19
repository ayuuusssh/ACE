package IESbank.Service;

import IESbank.Bindings.UNLOCK_FORM;
import IESbank.Bindings.USER_ACCOUNT_FORM;

import java.util.List;

public interface ACCOUNT_SERVICE {

    //for creating
    public boolean createUserAccount(USER_ACCOUNT_FORM accountForm);

    //for viewing
    public List<USER_ACCOUNT_FORM> fetchUserAccounts();

    //for editing
    public USER_ACCOUNT_FORM getUserAccById(Integer accId);

    //for account status
    public String changeAccStatus(Integer accID, String status);

    //for unlock the account
    public String unlockUserAccount(UNLOCK_FORM unlockForm);
}
