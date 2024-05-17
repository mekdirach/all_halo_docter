package xa.dokterhalo289.controllers;

import java.util.List;

import javax.swing.JSpinner.ListEditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xa.dokterhalo289.models.M_customer_relation;
import xa.dokterhalo289.repositories.PasienRelationRepo;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api")
public class ApiControllerRelation {
@Autowired PasienRelationRepo pasrelrep;

@GetMapping("/getrelation")
public ResponseEntity<List<M_customer_relation>>getall(){
	try {
		List<M_customer_relation> listrel = this.pasrelrep.findAll();
		return new ResponseEntity<List<M_customer_relation>>(listrel,HttpStatus.OK);
	}
	catch(Exception e) {
		return new ResponseEntity<List<M_customer_relation>>(HttpStatus.NO_CONTENT);
	}
}
  
}
