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
@Table(name="t_treatment_discount")
public class T_treatment_discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name="doctor_office_treatment_price_id", insertable=false, updatable=false)
	public T_doctor_office_treatment_price t_doctor_office_treatment_price;
	
	@Nullable
	@Column(name="doctor_office_treatment_price_id")
	private Long Doctor_office_treatment_price_id;
	
	@Nullable
	@Column(name="value", length=20)
	private Float Value;
	
	@ManyToOne
	@JoinColumn(name="create_by", insertable=false, updatable=false)
	public M_user User_create;
	
	@NotNull
	@Column(name="create_by")
	private Long Create_by;
	
	@NotNull
	@Column(name="create_on")
	private LocalDateTime Create_on;
	
	@ManyToOne
	@JoinColumn(name="modified_by", insertable=false, updatable=false)
	public M_user User_modified;
	
	@Nullable
	@Column(name="modified_by")
	private Long Modified_by;
	
	@Nullable
	@Column(name="modified_on")
	private LocalDateTime Modified_on;
	
	@ManyToOne
	@JoinColumn(name="deleted_by", insertable=false, updatable=false)
	public M_user User_deleted;
	
	@Nullable
	@Column(name="deleted_by")
	private Long Deleted_by;
	
	@Nullable
	@Column(name="deleted_on")
	private LocalDateTime Deleted_on;
	
	@NotNull
	@Column(name="is_delete", columnDefinition="boolean default false")
	private Boolean Is_delete;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public T_doctor_office_treatment_price getT_doctor_office_treatment_price() {
		return t_doctor_office_treatment_price;
	}

	public void setT_doctor_office_treatment_price(T_doctor_office_treatment_price t_doctor_office_treatment_price) {
		this.t_doctor_office_treatment_price = t_doctor_office_treatment_price;
	}

	public Long getDoctor_office_treatment_price_id() {
		return Doctor_office_treatment_price_id;
	}

	public void setDoctor_office_treatment_price_id(Long doctor_office_treatment_price_id) {
		Doctor_office_treatment_price_id = doctor_office_treatment_price_id;
	}

	public Float getValue() {
		return Value;
	}

	public void setValue(Float value) {
		Value = value;
	}

	public M_user getUser_create() {
		return User_create;
	}

	public void setUser_create(M_user user_create) {
		User_create = user_create;
	}

	public Long getCreate_by() {
		return Create_by;
	}

	public void setCreate_by(Long create_by) {
		Create_by = create_by;
	}

	public LocalDateTime getCreate_on() {
		return Create_on;
	}

	public void setCreate_on(LocalDateTime create_on) {
		Create_on = create_on;
	}

	public M_user getUser_modified() {
		return User_modified;
	}

	public void setUser_modified(M_user user_modified) {
		User_modified = user_modified;
	}

	public Long getModified_by() {
		return Modified_by;
	}

	public void setModified_by(Long modified_by) {
		Modified_by = modified_by;
	}

	public LocalDateTime getModified_on() {
		return Modified_on;
	}

	public void setModified_on(LocalDateTime modified_on) {
		Modified_on = modified_on;
	}

	public M_user getUser_deleted() {
		return User_deleted;
	}

	public void setUser_deleted(M_user user_deleted) {
		User_deleted = user_deleted;
	}

	public Long getDeleted_by() {
		return Deleted_by;
	}

	public void setDeleted_by(Long deleted_by) {
		Deleted_by = deleted_by;
	}

	public LocalDateTime getDeleted_on() {
		return Deleted_on;
	}

	public void setDeleted_on(LocalDateTime deleted_on) {
		Deleted_on = deleted_on;
	}

	public Boolean getIs_delete() {
		return Is_delete;
	}

	public void setIs_delete(Boolean is_delete) {
		Is_delete = is_delete;
	}
	
	
	
	

}
