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
@Table(name="t_doctor_treatment")
public class T_doctor_treatment {
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
	@JoinColumn(name="doctor_id", insertable=false, updatable=false)
	public M_doctor m_doctor;

	
	@Nullable
	@Column(name="doctor_id")
	private Long Doctor_id;

	@Nullable
	@Column(name="name",length=50)
	private String Name;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getCreated_by() {
		return Created_by;
	}

	public void setCreated_by(Long created_by) {
		Created_by = created_by;
	}

	public LocalDateTime getCreated_on() {
		return Created_on;
	}

	public void setCreated_on(LocalDateTime created_on) {
		Created_on = created_on;
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

	public boolean isIs_delete() {
		return Is_delete;
	}

	public void setIs_delete(boolean is_delete) {
		Is_delete = is_delete;
	}

	public M_user getUser_modified() {
		return User_modified;
	}

	public void setUser_modified(M_user user_modified) {
		User_modified = user_modified;
	}

	public M_user getUser_deleted() {
		return User_deleted;
	}

	public void setUser_deleted(M_user user_deleted) {
		User_deleted = user_deleted;
	}

	public M_user getUser_create() {
		return User_create;
	}

	public void setUser_create(M_user user_create) {
		User_create = user_create;
	}

	public M_doctor getM_doctor() {
		return m_doctor;
	}

	public void setM_doctor(M_doctor m_doctor) {
		this.m_doctor = m_doctor;
	}

	public Long getDoctor_id() {
		return Doctor_id;
	}

	public void setDoctor_id(Long doctor_id) {
		Doctor_id = doctor_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	
	
}
