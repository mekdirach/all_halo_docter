package xa.dokterhalo289.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xa.dokterhalo289.models.M_location_level;
import xa.dokterhalo289.repositories.Level_lokasiRepo;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api")
public class ApiLevellocationController {
	@Autowired Level_lokasiRepo levlekrep;
	
	@GetMapping(value="/levellocation")
	public ResponseEntity<List<M_location_level>> getalllevellocation(){
	try {
		List<M_location_level>levlok = this.levlekrep.findAll();
		return new ResponseEntity<List<M_location_level>>(levlok,HttpStatus.OK);
	}catch(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<List<M_location_level>>(HttpStatus.NO_CONTENT);
	}
	}

}
