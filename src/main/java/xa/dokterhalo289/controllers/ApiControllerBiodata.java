package xa.dokterhalo289.controllers;

import java.time.LocalDateTime;
import java.util.List;

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

import xa.dokterhalo289.models.M_biodata;
import xa.dokterhalo289.repositories.BiodataRepo;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api")
public class ApiControllerBiodata {
@Autowired BiodataRepo biorep;
  
@PostMapping("/savebio")
public ResponseEntity<M_biodata> insertbio(@RequestBody M_biodata biodata){
	try {
		biodata.setCreated_by(1L);
		biodata.setCreated_on(LocalDateTime.of(2022,9,22,0,0));
		this.biorep.save(biodata);
		return new ResponseEntity<M_biodata>(biodata,HttpStatus.OK);
	}
	catch(Exception e) {
		return new ResponseEntity<M_biodata>(HttpStatus.NO_CONTENT);
		}
}

@GetMapping("/getnama/{nama}")
public ResponseEntity<List<M_biodata>> getnama (@PathVariable ("nama") String nama){
	try {
		List<M_biodata> bio = this.biorep.getnama(nama);
		return new ResponseEntity<List<M_biodata>>(bio,HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<List<M_biodata>>(HttpStatus.NO_CONTENT);
		// TODO: handle exception
	}
}
}
