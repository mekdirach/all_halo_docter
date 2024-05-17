package xa.dokterhalo289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xa.dokterhalo289.models.T_doctor_treatment;

@Repository
public interface Treatments extends JpaRepository<T_doctor_treatment, Long>{
    @Query(value = "SELECT * FROM t_doctor_treatment dt WHERE dt.Doctor_id =?1", nativeQuery = true)
    List<T_doctor_treatment> listtreatment(Long id);
    
}
