package xa.dokterhalo289.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

@Entity
@Table(name="m_customer_member")
public class M_customer_member {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Long Id;
	
	
	@ManyToOne
	@JoinColumn(name="parent_biodata_id", insertable=false, updatable=false)
	public M_biodata m_biodata;
	
	@Nullable
	@Column(name="parent_biodata_id")
	private Long Parent_biodata_id;
	
	
	@ManyToOne
	@JoinColumn(name="customer_id", insertable=false, updatable=false)
	public M_customer m_customer;
	
	@Nullable
	@Column(name="customer_id")
	private Long Customer_id;
	

	@ManyToOne
	@JoinColumn(name="customer_relation_id", insertable=false, updatable=false)
	public M_customer_relation m_customer_relation;
	
	@Nullable
	@Column(name="customer_relation_id")
	private Long Customer_relation_id;
	
	
	@ManyToOne
	@JoinColumn(name="created_by",insertable=false, updatable=false)
	public M_user User_create;
	
	@NotNull
	@Column(name="created_by")
	private Long Created_by;
	
	@NotNull
	@Column(name="created_on")
	private LocalDateTime Created_on;
	
	@ManyToOne
	@JoinColumn(name="modified_by",insertable=false, updatable=false)
	public M_user User_modified;
	
	@Nullable
	@Column(name="modified_by")
	private Long Modified_by;

	@Nullable
	@Column(name="modified_on")
	private LocalDateTime Modified_on;
	
	@ManyToOne
	@JoinColumn(name="deleted_by",insertable=false, updatable=false)
	public M_user User_deleted;
	
	@Nullable
	@Column(name="deleted_by")
	private Long Deleted_by;
	
	@Nullable
	@Column(name="deleted_on")
	private LocalDateTime Deleted_on;
	
	@NotNull
	@Column(name="is_delete",columnDefinition = "boolean default false")
	private boolean Is_delete;
	
	
}
