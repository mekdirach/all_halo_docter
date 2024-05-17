package xa.dokterhalo289.models;

import java.sql.Blob;
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
@Table(name="m_medical_item")
public class M_medical_item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long Id;
	
	@Nullable
	@Column(name="name", length = 50)
	private String Name;
	
	@ManyToOne
	@JoinColumn(name="medical_item_category_id", insertable = false, updatable = false)
	public M_medical_item_category m_medical_item_category;
	
	@Nullable
	@Column(name="medical_item_category_id")
	private Long Medical_item_category_id;
	
	@Nullable
	@Column(name="composition", length = 255)
	private String Composition;
	
	@ManyToOne
	@JoinColumn(name="medical_item_segmentation_id", insertable = false, updatable = false)
	public M_medical_item_segmentation m_medical_item_segmentation;
	
	@Nullable
	@Column(name="medical_item_segmentation_id")
	private Long Medical_item_segmentation_id;
	
	@Nullable
	@Column(name="manufacturer", length = 100)
	private String Manufacturer;
	
	@Nullable
	@Column(name="indication", length = 255)
	private String Indication;
	
	@Nullable
	@Column(name="dosage", length = 255)
	private String Dosage;
	
	@Nullable
	@Column(name="directions", length = 255)
	private String Directions;
	
	@Nullable
	@Column(name="contraindication", length = 255)
	private String Contraindication;
	
	@Nullable
	@Column(name="caution", length = 255)
	private String Caution;
	
	@Nullable
	@Column(name="packaging", length = 50)
	private String Packaging;
	
	@Nullable
	@Column(name="price_max")
	private Long Price_max;
	
	@Nullable
	@Column(name="price_min")
	private Long Price_min;
	
	
	@Nullable
	@Column(name="image")
	private Blob Image;
	
	@Nullable
	@Column(name="image_path", length = 100)
	private String Image_path;
	
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

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Long getMedical_item_category_id() {
		return Medical_item_category_id;
	}

	public void setMedical_item_category_id(Long medical_item_category_id) {
		Medical_item_category_id = medical_item_category_id;
	}

	public String getComposition() {
		return Composition;
	}

	public void setComposition(String composition) {
		Composition = composition;
	}

	public Long getMedical_item_segmentation_id() {
		return Medical_item_segmentation_id;
	}

	public void setMedical_item_segmentation_id(Long medical_item_segmentation_id) {
		Medical_item_segmentation_id = medical_item_segmentation_id;
	}

	public String getManufacturer() {
		return Manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}

	public String getIndication() {
		return Indication;
	}

	public void setIndication(String indication) {
		Indication = indication;
	}

	public String getDosage() {
		return Dosage;
	}

	public void setDosage(String dosage) {
		Dosage = dosage;
	}

	public String getDirections() {
		return Directions;
	}

	public void setDirections(String directions) {
		Directions = directions;
	}

	public String getContraindication() {
		return Contraindication;
	}

	public void setContraindication(String contraindication) {
		Contraindication = contraindication;
	}

	public String getCaution() {
		return Caution;
	}

	public void setCaution(String caution) {
		Caution = caution;
	}

	public String getPackaging() {
		return Packaging;
	}

	public void setPackaging(String packaging) {
		Packaging = packaging;
	}

	public Long getPrice_max() {
		return Price_max;
	}

	public void setPrice_max(Long price_max) {
		Price_max = price_max;
	}

	public Long getPrice_min() {
		return Price_min;
	}

	public void setPrice_min(Long price_min) {
		Price_min = price_min;
	}

	

	public Blob getImage() {
		return Image;
	}

	public void setImage(Blob image) {
		Image = image;
	}

	public String getImage_path() {
		return Image_path;
	}

	public void setImage_path(String image_path) {
		Image_path = image_path;
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
