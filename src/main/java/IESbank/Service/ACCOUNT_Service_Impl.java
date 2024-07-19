package IESbank.Service;

import IESbank.Bindings.UNLOCK_FORM;
import IESbank.Bindings.USER_ACCOUNT_FORM;
import IESbank.Entity.IES_USER;
import IESbank.Repository.IES_USER_Repository;
import IESbank.Utils.EMAIL_UTILS;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ACCOUNT_Service_Impl implements ACCOUNT_SERVICE {
    @Autowired
    private IES_USER_Repository iesUserRepository;
    @Autowired
    private EMAIL_UTILS emailUtils;

    @Override
    public boolean createUserAccount(USER_ACCOUNT_FORM accountForm) {

        IES_USER users = new IES_USER();
        BeanUtils.copyProperties(accountForm, users);

        //random pwd
        users.setPassword(generatePwd());

        //accountStatus
        users.setACCOUNT_STATUS("Locked");
        users.setACTIVE_SW("Y");

        iesUserRepository.save(users);

        // email utils
        String subject= " ";
        String body= " ";

       boolean status =  emailUtils.sendEmail(subject,body,accountForm.getEmail());
        return status;
    }

    @Override
    public List<USER_ACCOUNT_FORM> fetchUserAccounts() {
        List<IES_USER> entities = iesUserRepository.findAll();
        List<USER_ACCOUNT_FORM> users = new ArrayList<>();
        for(IES_USER  iesUser : entities ) {
            USER_ACCOUNT_FORM userAccountForm = new USER_ACCOUNT_FORM();
            BeanUtils.copyProperties(iesUser,userAccountForm );
            users.add(userAccountForm);
        }
        return users;
    }

    @Override
    public USER_ACCOUNT_FORM getUserAccById(Integer accId) {

       Optional<IES_USER> optional= iesUserRepository.findById(accId);
       if(optional.isPresent()){
           IES_USER iesUser= optional.get();
           USER_ACCOUNT_FORM user = new USER_ACCOUNT_FORM();
           BeanUtils.copyProperties(iesUser,user);
           return user;
       }
        return null;
    }

    @Override
    public String changeAccStatus(Integer userId, String status) {

int cnt =iesUserRepository.updateAccStatus( userId, status);
        if(cnt>0){
            return "Status Changed";
        }
        return "failed to change";
    }

    @Override
    public String unlockUserAccount(UNLOCK_FORM unlockForm) {
        IES_USER iesuser = iesUserRepository.findByEmail(unlockForm.getEmail());
        iesuser.setPassword(unlockForm.getNewPwd());
        iesuser.setACCOUNT_STATUS("UNLOCKED");
        iesUserRepository.save(iesuser);


        return "Account Unlocked";
    }

    private String generatePwd() {


        // create a string of uppercase and lowercase characters and numbers
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        // combine all strings
        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 6;

        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphaNumeric.length());

            // get character specified by index
            // from the string
            char randomChar = alphaNumeric.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
