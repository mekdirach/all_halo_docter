package xa.dokterhalo289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xa.dokterhalo289.models.T_customer_wallet_withdraw;
@Repository
public interface TarikSaldoRepo extends JpaRepository<T_customer_wallet_withdraw, Long>{
    @Query(value = "SELECT * FROM t_customer_wallet_withdraw WHERE customer_id=?1 ORDER BY DESC", nativeQuery = true)
    List<T_customer_wallet_withdraw> getTransaksibyCus(Long id);
    
}
