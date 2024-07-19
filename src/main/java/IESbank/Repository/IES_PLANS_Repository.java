package IESbank.Repository;

import IESbank.Entity.IES_PLANS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IES_PLANS_Repository extends JpaRepository<IES_PLANS,Integer> {

   public Optional<IES_PLANS> findAllById(Integer planId);

   public int updateAccStatus(Integer planId, String status);

}
