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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import xa.dokterhalo289.models.M_location;
import xa.dokterhalo289.repositories.LokasiRepo;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api")
public class ApiLokasiController {
	@Autowired LokasiRepo lokrep;
	
	@GetMapping(value="/lokasi")
	public ResponseEntity<List<M_location>> getalllokasi(){
	try { 
		List<M_location>listlok = this.lokrep.findAll();
		return new ResponseEntity<List<M_location>>(listlok,HttpStatus.OK);
	}catch(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<List<M_location>>(HttpStatus.NO_CONTENT);
	}
	}

	@GetMapping("/getlokasibylevlokid/{id}")
	public ResponseEntity<?> getlokasibylevlokid(@PathVariable("id") Long id){
	try {
		List<M_location> lokasi = this.lokrep.findByLevel_lokasi_id(id);
		if(lokasi!=null) {
			return new ResponseEntity<>(lokasi,HttpStatus.OK);
		} else {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("categoryId dengan id"+id+"tidak ada");
		}
		}catch(Exception e){
		return new ResponseEntity<M_location>(HttpStatus.NO_CONTENT);
	}
	}
	
	@PostMapping("/insertlokasi")
	public ResponseEntity<M_location> insertlokasi(@RequestBody M_location lokasi){
	try {
		lokasi.setCreated_on(LocalDateTime.now());
		this.lokrep.save(lokasi);
		return new ResponseEntity<M_location>(lokasi, HttpStatus.OK);
	}
	catch(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<M_location>(HttpStatus.NO_CONTENT);
	}
	}
	@GetMapping("/lokasi/{id}")
		public ResponseEntity<M_location> getLokasiById(@PathVariable Long id){
			try {
				M_location lokasi = this.lokrep.findById(id).orElse(null);
				return new ResponseEntity<M_location>(lokasi,HttpStatus.OK);
			}
			catch(Exception e){
				e.printStackTrace();
				return new ResponseEntity<M_location>(HttpStatus.NO_CONTENT);
			}
			}
		
		@DeleteMapping("/deletelokasi/{id}")
		public ResponseEntity<M_location>deletelokasi(@PathVariable Long id){
			try {
				this.lokrep.deleteById(id);
				return new ResponseEntity<M_location>(HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<M_location>(HttpStatus.NO_CONTENT);
			}
		}
			  
		@PutMapping("/editlokasi/{id}")
		public ResponseEntity<M_location> insertlokasi(@RequestBody M_location lokasi,@PathVariable Long id){
			try {
				lokasi.setCreated_by(1L);
				lokasi.setCreated_on(LocalDateTime.now());
				lokasi.setId(id);
				this.lokrep.save(lokasi);
				return new ResponseEntity<M_location>(lokasi, HttpStatus.OK);
			}
			catch(Exception e) {
				e.printStackTrace();
				return new ResponseEntity<M_location>(HttpStatus.NO_CONTENT);
			}
			
			}
		
		@GetMapping("/getwilayah/{id}")
		public ResponseEntity<M_location>getwilayah (@PathVariable Long id){
			try {
				M_location lokasi = this.lokrep.findById(id).orElse(null);
				return new ResponseEntity<M_location>(lokasi,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<M_location>(HttpStatus.NO_CONTENT);
			}
		}
}
