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
@Table(name="m_doctor_education")
public class M_doctor_education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name="doctor_id", insertable=false, updatable=false)
	public M_doctor m_doctor;
	
	@Nullable
	@Column(name="doctor_id")
	private Long Doctor_id;
	
	@ManyToOne
	@JoinColumn(name="education_level_id", insertable=false, updatable=false)
	public M_education_level m_education_level;
	
	@Nullable
	@Column(name="education_level_id")
	private Long Education_level_id;
	
	@Nullable
	@Column(name="institution_name", length=100)
	private String Institution_name;
	
	@Nullable
	@Column(name="major", length=100)
	private String Major;
	
	@Nullable
	@Column(name="start_year", length=4)
	private String Start_year;
	
	@Nullable
	@Column(name="end_year", length=4)
	private String End_year;
	
	@Nullable
	@Column(name="is_last_education", columnDefinition = "boolean default false")
	private boolean Is_last_education;
	
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

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getDoctor_id() {
		return Doctor_id;
	}

	public void setDoctor_id(Long doctor_id) {
		Doctor_id = doctor_id;
	}

	public Long getEducation_level_id() {
		return Education_level_id;
	}

	public void setEducation_level_id(Long education_level_id) {
		Education_level_id = education_level_id;
	}

	public String getInstitution_name() {
		return Institution_name;
	}

	public void setInstitution_name(String institution_name) {
		Institution_name = institution_name;
	}

	public String getMajor() {
		return Major;
	}

	public void setMajor(String major) {
		Major = major;
	}

	public String getStart_year() {
		return Start_year;
	}

	public void setStart_year(String start_year) {
		Start_year = start_year;
	}

	public String getEnd_year() {
		return End_year;
	}

	public void setEnd_year(String end_year) {
		End_year = end_year;
	}

	public boolean isIs_last_education() {
		return Is_last_education;
	}

	public void setIs_last_education(boolean is_last_education) {
		Is_last_education = is_last_education;
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
