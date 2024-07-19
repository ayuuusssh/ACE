package IESbank.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ies_user")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IES_USER {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long userId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    private String email;
    private String password;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    private String gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "active_sw", nullable = false)
    private String ACTIVE_SW = "Y";

    @Column(name = "account_status", nullable = false)
    private String ACCOUNT_STATUS = "LOCKED";

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    private String roleId;

    @OneToMany(mappedBy = "iesUser", cascade = CascadeType.ALL)
    private List<IES_PLANS> iesPlans;
}
