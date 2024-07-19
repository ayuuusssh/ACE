package IESbank.Bindings;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class UNLOCK_FORM {

    private String email;
    private String tempPwd;
    private String newPwd;
    private String confirmedPwd;
}
