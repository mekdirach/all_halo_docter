package xa.dokterhalo289.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

@Entity
@Table(name="m_user")

public class M_user {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long Id;
	
	@OneToOne
	@JoinColumn(name="biodata_id" ,insertable=false, updatable=false)
	public M_biodata m_biodata;
	
	@Nullable
	@Column(name="biodata_id")
	private Long Biodata_id;
	
	@ManyToOne
	@JoinColumn(name="role_id", insertable=false, updatable=false)
	public M_role m_role;
	
	@Nullable
	@Column(name="role_id")
	private Long Role_id;
	
	@Nullable
	@Column(name="email", length = 100)
	private String Email;
	
	@Nullable
	@Column(name="password", length = 100)
	private String Password;
	
	@Nullable
	@Column(name="login_attemp")
	private Long Login_attemp;
	
	@Nullable
	@Column(name="is_locked")
	private Boolean Is_locked;

	@Nullable
	@Column(name="last_login")
	private LocalDateTime Last_login;
	
	//base properties

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

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public M_biodata getM_biodata() {
			return m_biodata;
		}

		public void setM_biodata(M_biodata m_biodata) {
			this.m_biodata = m_biodata;
		}

		public Long getBiodata_id() {
			return Biodata_id;
		}

		public void setBiodata_id(Long biodata_id) {
			Biodata_id = biodata_id;
		}

		public M_role getM_role() {
			return m_role;
		}

		public void setM_role(M_role m_role) {
			this.m_role = m_role;
		}

		public Long getRole_id() {
			return Role_id;
		}

		public void setRole_id(Long role_id) {
			Role_id = role_id;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

		public String getPassword() {
			return Password;
		}

		public void setPassword(String password) {
			Password = password;
		}

		public Long getLogin_attemp() {
			return Login_attemp;
		}

		public void setLogin_attemp(Long login_attemp) {
			Login_attemp = login_attemp;
		}

		public Boolean getIs_locked() {
			return Is_locked;
		}

		public void setIs_locked(Boolean is_locked) {
			Is_locked = is_locked;
		}

		public LocalDateTime getLast_login() {
			return Last_login;
		}

		public void setLast_login(LocalDateTime last_login) {
			Last_login = last_login;
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
