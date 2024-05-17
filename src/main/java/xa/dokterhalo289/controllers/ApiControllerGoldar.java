package xa.dokterhalo289.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xa.dokterhalo289.models.M_blood_group;
import xa.dokterhalo289.repositories.GoldarRepo;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api")
public class ApiControllerGoldar {
@Autowired GoldarRepo golrep;

@GetMapping("/getgoldar")
public ResponseEntity<List<M_blood_group>>getgoldar(){
try {
	List<M_blood_group>litdar = this.golrep.findAll();
	return new ResponseEntity<List<M_blood_group>>(litdar,HttpStatus.OK);
}
catch(Exception e) {
	return new ResponseEntity<List<M_blood_group>>(HttpStatus.NO_CONTENT);
}
}
}
