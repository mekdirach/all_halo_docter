package xa.dokterhalo289.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xa.dokterhalo289.models.M_customer_member;

@Repository
public interface PasienMemberRepo extends JpaRepository<M_customer_member, Long>{
	
}
