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
@Table(name="t_reset_password")

public class T_reset_password {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long Id;
	
	@Nullable
	@Column(name="old_password", length=255)
	private String Old_password;
	
	@Nullable
	@Column(name="new_password", length=255)
	private String New_password;
	
	@Nullable
	@Column(name="reset_for", length=20)
	private String Reset_for;
	
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
	
	

}
