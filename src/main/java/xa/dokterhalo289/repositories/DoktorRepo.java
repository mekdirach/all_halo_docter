package xa.dokterhalo289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xa.dokterhalo289.models.M_doctor;

@Repository
public interface DoktorRepo extends JpaRepository<M_doctor, Long> {
    @Query(value = "SELECT * FROM m_doctor d WHERE d.Biodata_id=?1", nativeQuery = true)
    List<M_doctor> findDoctorById(Long id);

    @Query(value = "FROM M_doctor d WHERE d.Id=?1")
    List<M_doctor> dataDoctorById(Long id);

    
}
