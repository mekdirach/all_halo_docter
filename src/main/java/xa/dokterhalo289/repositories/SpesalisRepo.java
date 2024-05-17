package xa.dokterhalo289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xa.dokterhalo289.models.T_current_doctor_specialization;

@Repository
public interface SpesalisRepo extends JpaRepository<T_current_doctor_specialization, Long>{
    @Query(value = "SELECT * FROM t_current_doctor_specialization ds WHERE ds.Doctor_id=?1", nativeQuery = true)
    List<T_current_doctor_specialization> listspesialization(Long id);
}
