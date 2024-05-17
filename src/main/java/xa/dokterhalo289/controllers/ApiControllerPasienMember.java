package xa.dokterhalo289.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xa.dokterhalo289.models.M_customer_member;
import xa.dokterhalo289.repositories.PasienMemberRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ApiControllerPasienMember {
@Autowired PasienMemberRepo pasmerep;

@PostMapping("/simpancustomermember")
public ResponseEntity<M_customer_member>insertcusmem (@RequestBody M_customer_member pasmem){
	try {
		pasmem.setCreated_by(1L);
		pasmem.setCreated_on(LocalDateTime.now());
		this.pasmerep.save(pasmem);
		return new ResponseEntity<M_customer_member>(pasmem,HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<M_customer_member>(HttpStatus.NO_CONTENT);
		
	}
}
}
