package IESbank.Bindings;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class PLAN_FORM {
    private String planCategory;
    private String planName;
    private LocalDate planStartDate;
    private LocalDate planEndDate;


}



