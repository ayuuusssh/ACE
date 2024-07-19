package IESbank.Repository;

import IESbank.Entity.IES_USER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IES_USER_Repository extends JpaRepository<IES_USER,Integer> {
    @Query("Update IES_USER set ACCOUNT_STATUS =:status where userId = userid")
    public Integer updateAccStatus(Integer userId,String status);

    public IES_USER findByEmail(String email);
    
    public IES_USER findByEmailAndPwd(String email, String password);
}
