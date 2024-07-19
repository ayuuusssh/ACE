package IESbank.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "ies_plans")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IES_PLANS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;

    private String planName;

    @Column(name = "plan_start_date")
    private LocalDate planStartDate;

    @Column(name = "plan_end_date")
    private LocalDate planEndDate;

    @Column(name = "plan_category")
    private String planCategory;

    @Column(name = "active_sw")
    private String activeSw;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private IES_USER iesUser;
}
