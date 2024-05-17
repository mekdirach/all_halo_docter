package xa.dokterhalo289.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

@Entity
@Table(name="m_medical_facility")
public class M_medical_facility {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long Id;
	
	@Nullable
	@Column(name="name", length = 100)
	private String Name ;
	
	@ManyToOne
	@JoinColumn(name="medical_facility_category_id", insertable = false, updatable = false)
	public M_medical_facility_category m_medical_facility_category;
	
	@Nullable
	@Column(name="medical_facility_category_id")
	private Long Medical_facility_category_id;
	
	@ManyToOne
	@JoinColumn(name="location_id", insertable = false, updatable = false)
	public M_location m_location;
	
	@Nullable
	@Column(name="location_id")
	private Long Location_id;
	
	@Nullable
	@Column(name="full_address", length = 255)
	private String Full_address;
	
	@Nullable
	@Column(name="email", length = 100)
	private String Email;
	
	@Nullable
	@Column(name="phone_code", length = 10)
	private String Phone_code;
	
	@Nullable
	@Column(name="phone", length = 15)
	private String Phone;
	
	@Nullable
	@Column(name="fax", length = 15)
	private String Fax;
	
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
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public M_medical_facility_category getM_medical_facility_category() {
		return m_medical_facility_category;
	}

	public void setM_medical_facility_category(M_medical_facility_category m_medical_facility_category) {
		this.m_medical_facility_category = m_medical_facility_category;
	}

	public M_location getM_location() {
		return m_location;
	}

	public void setM_location(M_location m_location) {
		this.m_location = m_location;
	}

	public M_user getUser_create() {
		return User_create;
	}

	public void setUser_create(M_user user_create) {
		User_create = user_create;
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

	@NotNull
	@Column(name="is_delete",columnDefinition = "boolean default false")
	private boolean Is_delete;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getMedical_facility_category_id() {
		return Medical_facility_category_id;
	}

	public void setMedical_facility_category_id(Long medical_facility_category_id) {
		Medical_facility_category_id = medical_facility_category_id;
	}

	public Long getLocation_id() {
		return Location_id;
	}

	public void setLocation_id(Long location_id) {
		Location_id = location_id;
	}

	public String getFull_address() {
		return Full_address;
	}

	public void setFull_address(String full_address) {
		Full_address = full_address;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone_code() {
		return Phone_code;
	}

	public void setPhone_code(String phone_code) {
		Phone_code = phone_code;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
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
	
	
}
