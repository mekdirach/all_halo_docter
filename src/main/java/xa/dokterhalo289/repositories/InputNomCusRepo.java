package xa.dokterhalo289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import xa.dokterhalo289.models.T_customer_custom_nominal;

public interface InputNomCusRepo extends JpaRepository<T_customer_custom_nominal, Long> {
    @Query(value = "SELECT * FROM t_customer_custom_nominal WHERE customer_id =?1", nativeQuery = true)
    List<T_customer_custom_nominal> getcustomnom(Long id);
    
    @Query(value = "SELECT * FROM t_customer_custom_nominal t WHERE t.nominal =?1", nativeQuery = true)
    List<T_customer_custom_nominal> getnominalcustom(Long nominal);
    
   
}
