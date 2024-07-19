package IESbank.Rest;

import IESbank.Bindings.DASHBOARDS_CARDS;
import IESbank.Bindings.LOGIN_FORM;
import IESbank.Service.USER_SERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class USER_CONTROLLER {
    @Autowired
    private USER_SERVICE userService;
    @PostMapping("/login")
    public String login(@RequestBody LOGIN_FORM loginForm){
      String status = userService.login(loginForm);
        if(status.equals("success")){
            return "redirect:/dashboard";
        }else{
            return status;
        }
    }
    @GetMapping("/dashboard")
    public ResponseEntity<DASHBOARDS_CARDS> buildDashBoard(){
        DASHBOARDS_CARDS dashboardsCards = userService.fetchDashboardInfo();
        return new ResponseEntity<>(dashboardsCards, HttpStatus.OK);
    }


}
