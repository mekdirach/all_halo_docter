package xa.dokterhalo289.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xa.dokterhalo289.models.M_medical_facility;

@Repository
public interface MedicalFacilityRepo extends JpaRepository<M_medical_facility, Long>{
    
}
