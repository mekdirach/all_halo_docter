package xa.dokterhalo289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xa.dokterhalo289.models.M_bank;
import xa.dokterhalo289.models.M_biodata_address;

@Repository
public interface BankRepo extends JpaRepository<M_bank, Long> {
	@Query(value="select * from m_bank b where lower (b.name)=lower(?1) and b.is_delete= false",nativeQuery = true)
	List<M_bank> cheking(String name);
	
	@Query(value="select * from m_bank b where (b.va_code)= lower(?1) and b.is_delete = false",nativeQuery = true)
	List<M_bank> checkva(String va_code);
	
	@Query(value="from M_bank b where b.Is_delete=false")
	List<M_bank> getbank();
	
	@Query(value=" SELECT * FROM M_bank m WHERE LOWER(m.name) LIKE %:textsearch%", nativeQuery=true)
	List<M_bank> Search(@Param("textsearch")String textsearch);

}
