package xa.dokterhalo289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xa.dokterhalo289.models.M_doctor_education;

@Repository
public interface EducationRepo extends JpaRepository<M_doctor_education, Long>{
    @Query(value = "SELECT * FROM  m_doctor_education edu WHERE edu.Doctor_id =?1 ORDER BY edu.start_year DESC", nativeQuery = true)
    List<M_doctor_education> listedudoctor(Long id);
}
