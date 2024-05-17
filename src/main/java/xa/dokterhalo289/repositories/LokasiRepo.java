package xa.dokterhalo289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xa.dokterhalo289.models.M_location;
@Repository
public interface LokasiRepo extends JpaRepository<M_location, Long>{
	@Query(value="From M_location WHERE Location_level_id=?1 ")
	List<M_location> findByLevel_lokasi_id(Long Level_location_id);
	
	
}	
