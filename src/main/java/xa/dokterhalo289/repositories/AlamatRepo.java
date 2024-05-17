package xa.dokterhalo289.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import xa.dokterhalo289.models.M_biodata_address;


public interface AlamatRepo extends JpaRepository<M_biodata_address, Long>{
	
	@Query(value="select * from m_biodata_address m where m.is_delete= false",nativeQuery = true)
	List<M_biodata_address> getfalse();
	
	@Query(value=" SELECT * FROM M_biodata_address m WHERE LOWER(m.recipient) LIKE %:textsearch% OR LOWER(m.address) LIKE %:textsearch%", nativeQuery=true)
	List<M_biodata_address> Search(@Param("textsearch")String textsearch);
	
	@Query(value="from M_biodata_address m where location_id=?1")
	List<M_biodata_address>getlocationid(Long location_id);
	
	@Query(value="select * from m_biodata_address m order by :textsearch asc", nativeQuery = true)
	List<M_biodata_address>sortedjj(@Param ("textsearch")String textsearch);
	
	@Transactional
	@Modifying
	@Query(value="update m_biodata_address a set is_delete = true, deleted_on=now(), deleted_by= 1 where a.id=?1", nativeQuery = true)
	void deltemulti(Long id);
	
	@Query(value="select * from m_biodata_address m where lower (m.label)=lower(?1)",nativeQuery = true)
	List<M_biodata_address> cheklabel (String label);	
	
	@Query(value="select * from m_biodata_address m where (m.biodata_id)=(?1)",nativeQuery = true)
	List<M_biodata_address> chekbio (Long id);	
}
	