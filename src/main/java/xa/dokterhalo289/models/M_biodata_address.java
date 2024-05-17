package xa.dokterhalo289.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "m_biodata_address")
public class M_biodata_address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;

	@ManyToOne
	@JoinColumn(name = "biodata_id", insertable = false, updatable = false)
	public M_biodata m_biodata;

	@Nullable
	@Column(name = "biodata_id")
	private Long Biodata_id;

	@Nullable
	@Column(name = "label", length = 100)
	private String Label;

	@Nullable
	@Column(name = "recipient", length = 100)
	private String Recipient;

	@Nullable
	@Column(name = "recipient_phone_number", length = 15)
	private String Recipient_phone_number;

	@ManyToOne
	@JoinColumn(name = "location_id", insertable = false, updatable = false)
	public M_location m_location;

	@Nullable
	@Column(name = "location_id")
	private Long Location_id;

	@Nullable
	@Column(name = "postal_code", length = 10)
	private Long Postal_code;

	@Nullable
	@Column(name = "address" , length = 255)
	private String Address;

	@ManyToOne
	@JoinColumn(name = "created_by", insertable = false, updatable = false)
	public M_user User_create; 

	@NotNull
	@Column(name = "created_by")
	private Long Created_by;

	@NotNull
	@Column(name = "created_on")
	private LocalDateTime Created_on;

	@ManyToOne
	@JoinColumn(name = "modified_by", insertable = false, updatable = false)
	public M_user User_modified;

	@Nullable
	@Column(name = "modified_by")
	private Long Modified_by;

	@Nullable
	@Column(name = "modified_on")
	private LocalDateTime Modified_on;

	@ManyToOne
	@JoinColumn(name = "deleted_by", insertable = false, updatable = false)
	public M_user User_deleted;

	@Nullable
	@Column(name = "deleted_by")
	private Long Deleted_by;

	@Nullable
	@Column(name = "deleted_on")
	private LocalDateTime Deleted_on;

	@NotNull
	@Column(name = "is_delete", columnDefinition = "boolean default false")
	private boolean Is_delete;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public String getRecipient() {
		return Recipient;
	}

	public void setRecipient(String recipient) {
		Recipient = recipient;
	}

	public String getRecipient_phone_number() {
		return Recipient_phone_number;
	}

	public void setRecipient_phone_number(String recipient_phone_number) {
		Recipient_phone_number = recipient_phone_number;
	}

	public M_biodata getM_biodata() {
		return m_biodata;
	}

	public void setM_biodata(M_biodata m_biodata) {
		this.m_biodata = m_biodata;
	}

	public M_location getM_location() {
		return m_location;
	}

	public void setM_location(M_location m_location) {
		this.m_location = m_location;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Long getLocation_id() {
		return Location_id;
	}

	public void setLocation_id(Long location_id) {
		Location_id = location_id;
	}

	public Long getPostal_code() {
		return Postal_code;
	}

	public void setPostal_code(Long postal_code) {
		Postal_code = postal_code;
	}

	public M_user getUser_create() {
		return User_create;
	}

	public void setUser_create(M_user user_create) {
		User_create = user_create;
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

	public boolean isIs_delete() {
		return Is_delete;
	}

	public void setIs_delete(boolean is_delete) {
		Is_delete = is_delete;
	}

}
