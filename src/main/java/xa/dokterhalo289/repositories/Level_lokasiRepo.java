package xa.dokterhalo289.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xa.dokterhalo289.models.M_location_level;

@Repository
public interface Level_lokasiRepo extends JpaRepository<M_location_level, Long> {

}
