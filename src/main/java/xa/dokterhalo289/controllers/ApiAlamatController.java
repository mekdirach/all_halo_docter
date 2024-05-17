package xa.dokterhalo289.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import xa.dokterhalo289.models.M_biodata_address;
import xa.dokterhalo289.repositories.AlamatRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ApiAlamatController {
	@Autowired AlamatRepo alrep;
	
	@GetMapping("/cekbio/{id}")
	public ResponseEntity<List<M_biodata_address>>cekbio(@PathVariable ("id") Long id){
		try {
			List<M_biodata_address>litbio = this.alrep.chekbio(id);
			return new ResponseEntity<List<M_biodata_address>>(litbio,HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<M_biodata_address>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/ceklabel/{label}")
	public ResponseEntity<List<M_biodata_address>>ceklab(@PathVariable ("label") String label){
		try {
			List<M_biodata_address> ceklab = this.alrep.cheklabel(label);
			return new ResponseEntity<List<M_biodata_address>>(ceklab,HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<M_biodata_address>>(HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping("/sortlabel")
	public ResponseEntity<List<M_biodata_address>>getlabel(){
		try {
			
			List<M_biodata_address>alam=this.alrep.getfalse();
			List<M_biodata_address>alam1= new ArrayList<M_biodata_address>();
			alam1=alam.stream().sorted((temp,temp1)->temp.getLabel().compareTo(temp1.getLabel())).collect(Collectors.toList());
			return new ResponseEntity<List<M_biodata_address>>(alam1,HttpStatus.OK);
			//return new ResponseEntity<List<Biodata>>(bio,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<M_biodata_address>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/sortrecipient")
	public ResponseEntity<List<M_biodata_address>>getrecipient(){
		try {
			
			List<M_biodata_address>alam=this.alrep.getfalse();
			List<M_biodata_address>alam1= new ArrayList<M_biodata_address>();
			alam1=alam.stream().sorted((temp,temp1)->temp.getRecipient().compareTo(temp1.getRecipient())).collect(Collectors.toList());
			return new ResponseEntity<List<M_biodata_address>>(alam1,HttpStatus.OK);
			//return new ResponseEntity<List<Biodata>>(bio,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<M_biodata_address>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/sortaddress")
	public ResponseEntity<List<M_biodata_address>>getaddress(){
		try {
			
			List<M_biodata_address>alam=this.alrep.getfalse();
			List<M_biodata_address>alam1= new ArrayList<M_biodata_address>();
			alam1=alam.stream().sorted((temp,temp1)->temp.getAddress().compareTo(temp1.getAddress())).collect(Collectors.toList());
			return new ResponseEntity<List<M_biodata_address>>(alam1,HttpStatus.OK);
			//return new ResponseEntity<List<Biodata>>(bio,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<M_biodata_address>>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	@GetMapping("/alamat")
	public ResponseEntity<List<M_biodata_address>> getallalamat(){
		try {
			List<M_biodata_address>alamat = this.alrep.getfalse();
			return new ResponseEntity<List<M_biodata_address>>(alamat,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<M_biodata_address>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/tambahalamat")
	public ResponseEntity<M_biodata_address>tambahalamat(@RequestBody M_biodata_address alamat){
		try {
			alamat.setCreated_on(LocalDateTime.now());
			this.alrep.save(alamat);
			return new ResponseEntity<M_biodata_address>(alamat,HttpStatus.OK);
		}
		catch(Exception e) {
		return new ResponseEntity<M_biodata_address>(HttpStatus.NO_CONTENT);
	}
	}
	
	@GetMapping("/alamat/{id}")
	public ResponseEntity<M_biodata_address>getalamatId(@PathVariable Long id){
		try {
			M_biodata_address alamat = this.alrep.findById(id).orElse(null);
			return new ResponseEntity<M_biodata_address>(alamat,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<M_biodata_address>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/editalamat/{id}")
	public ResponseEntity<M_biodata_address>tambahalamatbyid(@RequestBody M_biodata_address alamat, @PathVariable Long id){
		try {
			alamat.setCreated_by(1L);
			alamat.setCreated_on(LocalDateTime.of(2022,9,22,0,0));
			alamat.setId(id);
			this.alrep.save(alamat);
			return new ResponseEntity<M_biodata_address>(alamat,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<M_biodata_address>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/alamat/search/{textsearch}")
	public ResponseEntity<List<M_biodata_address>>getalamat(@PathVariable("textsearch")String textsearch){
		try {
			List<M_biodata_address>alamat=this.alrep.Search(textsearch);
			return new ResponseEntity<List<M_biodata_address>>(alamat,HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<M_biodata_address>>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	
	
	@GetMapping("/sorted/{textsearch}")
	public ResponseEntity<List<M_biodata_address>>getlocationid(@PathVariable ("textsearch") String textsearch){
		try {
			List<M_biodata_address>alamat= this.alrep.sortedjj(textsearch);
			return new ResponseEntity<List<M_biodata_address>>(alamat,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<M_biodata_address>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/multidel/{id}")
	public ResponseEntity<Object> multidelete(@PathVariable("id")Long id){
		this.alrep.deltemulti(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<M_biodata_address>>findalamat(@PathVariable("id") Long id){
		Optional<M_biodata_address> alamat = this.alrep.findById(id);
		if(alamat.isPresent()) {
			ResponseEntity rest = new ResponseEntity<>(alamat,HttpStatus.OK);
			return rest;
		} else {
			return new ResponseEntity<List<M_biodata_address>>(HttpStatus.NOT_FOUND);
		}
	}
	
	}

