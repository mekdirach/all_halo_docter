package xa.dokterhalo289.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xa.dokterhalo289.models.T_appointment;

@Repository
public interface JanjiRepo extends JpaRepository<T_appointment, Long>{
    @Query(value="SELECT count(*) AS hitung FROM t_appointment p  JOIN t_doctor_office o ON p.doctor_office_id = o.id WHERE o.Doctor_id = ?1", nativeQuery=true)
   Long hitungJanji(Long id); 
}
