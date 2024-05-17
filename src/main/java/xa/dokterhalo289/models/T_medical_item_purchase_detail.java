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
@Table(name="t_medical_item_purchase_detail")
public class T_medical_item_purchase_detail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long Id;
	
	@NotNull
	@Column(name="created_by")
	private Long Created_by;
	
	@NotNull
	@Column(name="created_on")
	private LocalDateTime Created_on;
	
	
	@Nullable
	@Column(name="modified_by")
	private Long Modified_by;

	@Nullable
	@Column(name="modified_on")
	private LocalDateTime Modified_on;
	
	
	@Nullable
	@Column(name="deleted_by")
	private Long Deleted_by;
	
	@Nullable
	@Column(name="deleted_on")
	private LocalDateTime Deleted_on;
	
	@NotNull
	@Column(name="is_delete",columnDefinition = "boolean default false")
	private boolean Is_delete;

	
	@ManyToOne
	@JoinColumn(name="modified_by",insertable=false, updatable=false)
	public M_user User_modified;
	
	@ManyToOne
	@JoinColumn(name="deleted_by",insertable=false, updatable=false)
	public M_user User_deleted;
	
	@ManyToOne
	@JoinColumn(name="created_by",insertable=false, updatable=false)
	public M_user User_create;
	
	@ManyToOne
	@JoinColumn(name="medical_item_purchase_id",insertable=false, updatable=false)
	public T_medical_item_purchase t_medical_item_purchase;
	
	@ManyToOne
	@JoinColumn(name="medical_item_id", insertable=false, updatable=false)
	public M_medical_item m_medical_item;
	
	@ManyToOne
	@JoinColumn(name="medical_facility_id",insertable=false, updatable=false)
	public M_medical_facility m_medical_facility;
	
	@ManyToOne
	@JoinColumn(name="courir_id",insertable=false, updatable=false)
	public M_courier m_courier;
	
	
	@Nullable
	@Column(name="medical_item_purchase_id")	
	private Long Medical_item_purchase_id;

	@Nullable
	@Column(name="medical_item_id")
	private Long Medical_item_id;
	
	@Nullable
	@Column(name="medical_facility_id")
	private Long Medical_facility_id;
	
	@Nullable
	@Column(name="qty")
	private Integer Qty;
	
	@Nullable
	@Column(name="courir_id")
	private Long Courir_id;
	
	@Nullable
	@Column(name="sub_total")
	private Double Sub_total;
}
