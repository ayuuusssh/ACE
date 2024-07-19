package IESbank.Bindings;

import lombok.Data;

@Data
public class Error {
    private String message;
    private String details;

    public Error (String message,String details){
        super();
        this.message=message;
        this.details=details;
    }
}
