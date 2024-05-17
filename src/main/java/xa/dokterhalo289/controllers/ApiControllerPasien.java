package xa.dokterhalo289.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xa.dokterhalo289.models.M_customer;
import xa.dokterhalo289.models.M_location;
import xa.dokterhalo289.repositories.PasienRepoo;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ApiControllerPasien {
	
@Autowired PasienRepoo parep;

@GetMapping(value="/pasien")
public ResponseEntity<List<M_customer>> getalllokasi(){
try { 
	List<M_customer>listlok = this.parep.findAll();
	return new ResponseEntity<List<M_customer>>(listlok,HttpStatus.OK);
}catch(Exception e) {
	e.printStackTrace();
	return new ResponseEntity<List<M_customer>>(HttpStatus.NO_CONTENT);
}
}

@GetMapping(value="/tampil")
public ResponseEntity<List<Map<String, Object>>> gettampil(){
try { 
	List<Map<String, Object>>listlok = this.parep.gettampil();
	return new ResponseEntity<List<Map<String, Object>>>(listlok,HttpStatus.OK);
}catch(Exception e) {
	e.printStackTrace();
	return new ResponseEntity<List<Map<String, Object>>>(HttpStatus.NO_CONTENT);
}
}

@PostMapping("/simpanpasien")
public ResponseEntity<?> insertpasien(@RequestBody M_customer pasien){
	try {
		pasien.setCreated_by(1L);
		pasien.setCreated_on(LocalDateTime.of(2022,9,22,0,0));
		this.parep.save(pasien);
		return new ResponseEntity<M_customer>(pasien,HttpStatus.OK);
	}
	catch(Exception e) {
		return new ResponseEntity<M_customer>(HttpStatus.NO_CONTENT);
	}
}

@GetMapping("/pasien/{id}")
public ResponseEntity<M_customer>getpasienbyid(@PathVariable Long id){
	try {
		M_customer pasien = this.parep.findById(id).orElse(null);
		return new ResponseEntity<M_customer>(pasien,HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<M_customer>(HttpStatus.NO_CONTENT);
		// TODO: handle exception
	}
}

@GetMapping("/pasienbio/{bio_id}")
public ResponseEntity<List<M_customer>>getbio_id(@PathVariable Long bio_id){
	try {
		List<M_customer> pasien = this.parep.getbioid(bio_id);
		return new ResponseEntity<List<M_customer>>(pasien,HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<List<M_customer>>(HttpStatus.NO_CONTENT);
		// TODO: handle exception
	}
}
}
