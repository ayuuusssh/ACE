package IESbank.Rest;

import IESbank.Bindings.PLAN_FORM;
import IESbank.Repository.IES_PLANS_Repository;
import IESbank.Service.PLAN_SERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PLAN_CONTROLLER {

    @Autowired
    private PLAN_SERVICE planService;

    @PostMapping("/form")
    public ResponseEntity<String> createAccount(@RequestBody PLAN_FORM planForm){
        boolean status = planService.createAccount(planForm);
        if(status){
            return new ResponseEntity<>("Account Created", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Account Creation Failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/forms")
    public ResponseEntity<List<PLAN_FORM>> fetchPlanForms(){
        List<PLAN_FORM> form = planService.fetchPlansForms();
        return new ResponseEntity<>(form,HttpStatus.OK);
    }

    @GetMapping("/form/{formId}")
    public ResponseEntity<PLAN_FORM> getFormByID(@PathVariable("formId") Integer planId){
        PLAN_FORM form = planService.getPlanById(planId);
        return new ResponseEntity<>(form,HttpStatus.OK);
    }
    @PutMapping("/form/{planId}/{status}")
    public ResponseEntity<?> changeAccStatus(@PathVariable("planId") Integer planId,@PathVariable("status") String Status){
        planService.changePlanStatus(planId,Status);
        List<PLAN_FORM> form = planService.fetchPlansForms();
        return new ResponseEntity<>(form,HttpStatus.OK);

    }
}
