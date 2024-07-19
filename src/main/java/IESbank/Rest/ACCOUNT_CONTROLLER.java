package IESbank.Rest;

import IESbank.Bindings.UNLOCK_FORM;
import IESbank.Bindings.USER_ACCOUNT_FORM;
import IESbank.Service.ACCOUNT_SERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ies")
public class ACCOUNT_CONTROLLER {
    @Autowired
    private ACCOUNT_SERVICE accountService;

    @PostMapping("/user")
    public ResponseEntity<String>createAccount(@RequestBody USER_ACCOUNT_FORM userAccountForm){
        boolean status = accountService.createUserAccount(userAccountForm);
        if(status){
            return new ResponseEntity<>("Account Created", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Account Creation Failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/users")
    public ResponseEntity<List<USER_ACCOUNT_FORM>> getUsers(){
        List<USER_ACCOUNT_FORM> accounts= accountService.fetchUserAccounts();
     return new ResponseEntity<>(accounts,HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<USER_ACCOUNT_FORM> getUser(@PathVariable("userId") Integer userId){
        USER_ACCOUNT_FORM user = accountService.getUserAccById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PutMapping("/users/{userId}/{status}")
    public ResponseEntity<List<USER_ACCOUNT_FORM>> updateAccStatus(@PathVariable("userId") Integer userId,
                                                                   @PathVariable("status") String status){
       accountService.changeAccStatus(userId,status);
       List<USER_ACCOUNT_FORM> account = accountService.fetchUserAccounts();
       return new ResponseEntity<>(account,HttpStatus.OK);
    }
    @PostMapping("/unlock")
    public ResponseEntity<String> unlockUserAcc(@RequestBody UNLOCK_FORM unlockForm) {
        String result = accountService.unlockUserAccount(unlockForm);
        if ("User account unlocked successfully".equals(result)) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
