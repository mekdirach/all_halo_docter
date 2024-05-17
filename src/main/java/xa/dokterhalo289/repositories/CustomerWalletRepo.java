package xa.dokterhalo289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xa.dokterhalo289.models.M_wallet_default_nominal;
import xa.dokterhalo289.models.T_customer_wallet;

@Repository
public interface CustomerWalletRepo extends JpaRepository<T_customer_wallet, Long>{
   @Query(value = "SELECT * FROM t_customer_wallet wallet WHERE wallet.pin=?1 AND wallet.customer_id=?2", nativeQuery = true)
   List<T_customer_wallet> getpincode(String pin, Long id);

   @Query(value = "SELECT * FROM t_customer_wallet WHERE Customer_id=?1", nativeQuery = true)
   List<T_customer_wallet> getCus(Long id);

}
