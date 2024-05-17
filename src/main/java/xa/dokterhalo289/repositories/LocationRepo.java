package xa.dokterhalo289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import xa.dokterhalo289.models.M_location;

public interface LocationRepo extends JpaRepository<M_location, Long>{
    @Query(value = "SELECT * FROM m_location m WHERE m.id=?1", nativeQuery = true)
    List<M_location> getByIdLocation(Long id);
}
