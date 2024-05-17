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
@Table(name="T_customer_wallet_withdraw")

public class T_customer_wallet_withdraw {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name="customer_id", insertable=false, updatable=false)
	public M_customer m_customer;
	
	@NotNull
	@Column(name="customer_id")
	private Long Customer_id;
	
	@Nullable
	@Column(name="wallet_default_nominal_id")
	private Long Wallet_default_nominal_id;
	
	@NotNull
	@Column(name="amount")
	private Integer Amount;
	
	@NotNull
	@Column(name="bank_name", length = 50)
	private String Bank_name;

	@NotNull
	@Column(name="account_number", length = 50)
	private String Account_number;
	
	@NotNull
	@Column(name="account_name", length = 255)
	private String Account_name;

	@NotNull
	@Column(name="otp")
	private Integer Otp;
	
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

	public M_customer getM_customer() {
		return m_customer;
	}

	public void setM_customer(M_customer m_customer) {
		this.m_customer = m_customer;
	}

	public Long getCustomer_id() {
		return Customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		Customer_id = customer_id;
	}

	public Long getWallet_default_nominal_id() {
		return Wallet_default_nominal_id;
	}

	public void setWallet_default_nominal_id(Long wallet_default_nominal_id) {
		Wallet_default_nominal_id = wallet_default_nominal_id;
	}

	public Integer getAmount() {
		return Amount;
	}

	public void setAmount(Integer amount) {
		Amount = amount;
	}

	public String getBank_name() {
		return Bank_name;
	}

	public void setBank_name(String bank_name) {
		Bank_name = bank_name;
	}

	public String getAccount_number() {
		return Account_number;
	}

	public void setAccount_number(String account_number) {
		Account_number = account_number;
	}

	public String getAccount_name() {
		return Account_name;
	}

	public void setAccount_name(String account_name) {
		Account_name = account_name;
	}

	public Integer getOtp() {
		return Otp;
	}

	public void setOtp(Integer otp) {
		Otp = otp;
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
