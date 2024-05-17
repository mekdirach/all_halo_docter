package xa.dokterhalo289.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xa.dokterhalo289.models.M_medical_item_category;
import xa.dokterhalo289.repositories.MedicalitemCategoryRepo;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin("*")
@RequestMapping(value="/api")
public class ApiMedicalitemCategory {
	@Autowired MedicalitemCategoryRepo micrepo;
	
	@GetMapping("/medicalitemcar")
	public ResponseEntity<List<M_medical_item_category>>  getAllCar(){
		try {
			List<M_medical_item_category> medicalitem = this.micrepo.getMedicalItem();
			return new ResponseEntity<>(medicalitem, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/medicalitemcategory/{check}")
	public ResponseEntity<List<M_medical_item_category>> checking(@PathVariable("check") String check){
		try {
			List<M_medical_item_category> medicalitem = micrepo.checking(check);
			return new ResponseEntity<>(medicalitem, HttpStatus.OK);
		} catch (Exception e) {
			//TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping("/medicalitem/{id}")
	public ResponseEntity<?> getItemById(@PathVariable Long id){
		try {
			M_medical_item_category medicalitem = this.micrepo.findById(id).orElse(null);
			if(medicalitem != null){
				return new ResponseEntity<M_medical_item_category>(medicalitem, HttpStatus.OK);
			}else{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data tidak ditemukan dengan id "+ id);

			}
		} catch (Exception e) {
			//TODO: handle exception
			return new ResponseEntity<M_medical_item_category>(HttpStatus.NO_CONTENT);
		}
	}
	@PostMapping("/medicalitemcar")
	public ResponseEntity<M_medical_item_category> inputData(@RequestBody M_medical_item_category medicalcategory){
		try {
			medicalcategory.setCreated_by((long)1);
			medicalcategory.setCreated_on(LocalDateTime.now());
			this.micrepo.save(medicalcategory);
			return new ResponseEntity<M_medical_item_category>(medicalcategory, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<M_medical_item_category>(HttpStatus.NO_CONTENT);
		}
	}
	
	 @PutMapping("/medicalitemcar/{id}")
	 public ResponseEntity<M_medical_item_category> updateData(@RequestBody M_medical_item_category itemcar, @PathVariable Long id) {
		try {
			itemcar.setId(id);
			itemcar.setCreated_by((long)1);
			this.micrepo.save(itemcar);
			return new ResponseEntity<M_medical_item_category>(itemcar, HttpStatus.OK);
		} catch (Exception e) {
			//TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<M_medical_item_category>(HttpStatus.NO_CONTENT);
		}
		
	 }
}
