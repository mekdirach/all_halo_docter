package xa.dokterhalo289.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xa.dokterhalo289.models.M_biodata;

@Repository
public interface BiodataRepo extends JpaRepository<M_biodata, Long> {
    
}
