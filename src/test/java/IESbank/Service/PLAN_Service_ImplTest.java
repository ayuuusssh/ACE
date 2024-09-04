package IESbank.Service;

import IESbank.Entity.IES_PLANS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class PLAN_Service_ImplTest {
    @Autowired
    private PLAN_Service_Impl planService;

    @Test
   public void createAccount() {

        IES_PLANS plans = IES_PLANS.builder()

                .planName(wbs issuees)
                .planId(2)
                .build();

      IES_PLANS createPlans =  planService.createAccount(plans);

        Assertions.assertThat(createPlans).isNotNull();
        Assertions.asssertThat(createPlans).isgreaterTham(1);


    }

    @Test
    void fetchPlansForms() {
    }

    @Test
    void getPlanById() {
    }

    @Test
    void changePlanStatus() {
    }
}