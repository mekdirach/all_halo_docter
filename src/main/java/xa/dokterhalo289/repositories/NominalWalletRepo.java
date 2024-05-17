package xa.dokterhalo289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xa.dokterhalo289.models.M_wallet_default_nominal;

@Repository
public interface NominalWalletRepo extends JpaRepository<M_wallet_default_nominal, Long>{
    @Query(value ="SELECT * FROM m_wallet_default_nominal m WHERE m.nominal=?1", nativeQuery = true)
    List<M_wallet_default_nominal> getnominal (Long nominal);
}
