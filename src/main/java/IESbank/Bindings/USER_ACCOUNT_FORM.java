package IESbank.Bindings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;

@Setter
@Getter
public class USER_ACCOUNT_FORM {

    private String fullName;
    private String email;
    private long mobileNo;
    private String gender;
    private LocalDate dob;
    private long ssn;
    private String activateSw;
    private Integer roleId;

}
