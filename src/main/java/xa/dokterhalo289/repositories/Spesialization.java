package xa.dokterhalo289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import xa.dokterhalo289.models.M_specialization;

public interface Spesialization extends JpaRepository<M_specialization, Long>{
    @Query(value = "SELECT * FROM m_specialization sp WHERE sp.is_delete = false", nativeQuery = true)
    List<M_specialization> findspec();
}
