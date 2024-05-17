package xa.dokterhalo289.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import xa.dokterhalo289.models.T_customer_chat;

public interface ChatRepo extends JpaRepository<T_customer_chat, Long>{
    @Query(value = "SELECT count(*) AS hitung FROM t_customer_chat WHERE Doctor_id =?1 ", nativeQuery = true)
    Long countchat(Long id);
    
}
