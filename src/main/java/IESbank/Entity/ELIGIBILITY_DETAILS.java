package IESbank.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ELIG_DETAILS")
@Data
public class ELIGIBILITY_DETAILS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer edgTraceId;
    private String planStatus;
    private double benefitAmtGiven;

}
