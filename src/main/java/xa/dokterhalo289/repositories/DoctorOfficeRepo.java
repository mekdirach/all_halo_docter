package xa.dokterhalo289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import xa.dokterhalo289.models.T_doctor_office;

public interface DoctorOfficeRepo extends JpaRepository<T_doctor_office, Long>{
    @Query(value = "SELECT * FROM t_doctor_office WHERE Doctor_id = ?1", nativeQuery = true)
    List<T_doctor_office> listmedical(Long id);
    @Query(value = "SELECT extract(year from created_on) AS tahun_awal, extract(year from deleted_on) AS tahun_akhir, specialization, is_delete  FROM t_doctor_office WHERE Doctor_id = ?1", nativeQuery = true)
    List<T_doctor_office> listriwayat(Long id);
    
    @Query(value = "SELECT extract(year from created_on) AS tahun_awal  FROM t_doctor_office WHERE Doctor_id = ?1 AND is_delete = false", nativeQuery = true)
    List<T_doctor_office> tahun_awal(Long id);
}
