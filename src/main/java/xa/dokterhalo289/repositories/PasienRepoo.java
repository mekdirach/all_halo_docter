package xa.dokterhalo289.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xa.dokterhalo289.models.M_biodata;
import xa.dokterhalo289.models.M_customer;

@Repository
public interface PasienRepoo extends JpaRepository<M_customer, Long> {
@Query(value="select \r\n"
		+ "b.fullname, \r\n"
		+ "cr.name,\r\n"
		+ "(select extract (year from now())-extract(year from c.dob)) as umur\r\n"
		+ "from  \r\n"
		+ "m_customer c\r\n"
		+ "join m_biodata b on b.id = c.biodata_id\r\n"
		+ "join m_customer_member cm on c.id = cm.customer_id\r\n"
		+ "join m_customer_relation cr on cr.id = cm.customer_relation_id",nativeQuery = true)
List<Map<String, Object>> gettampil();

@Query(value="select * from m_customer m where m.biodata_id = ?1 ", nativeQuery = true)
List<M_customer> getbioid (Long biodata_id);
}
