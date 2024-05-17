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

import xa.dokterhalo289.models.M_bank;
import xa.dokterhalo289.models.M_biodata_address;
import xa.dokterhalo289.repositories.BankRepo;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api")
public class ApiBankController {
	@Autowired BankRepo bankrep;
	
	@GetMapping("/bank/search/{textsearch}")
	public ResponseEntity<List<M_bank>>getalamat(@PathVariable("textsearch")String textsearch){
		try {
			List<M_bank>kol=this.bankrep.Search(textsearch);
			return new ResponseEntity<List<M_bank>>(kol,HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<M_bank>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/bank")
	public ResponseEntity<List<M_bank>> getallbank(){
	try {
		List<M_bank>bank = this.bankrep.getbank();
		return new ResponseEntity<List<M_bank>>(bank,HttpStatus.OK);
	}
	catch(Exception e) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	}
	@GetMapping("/bank/{id}")
	public ResponseEntity<M_bank> getBankById(@PathVariable Long id){
	try {
		M_bank  bank = this.bankrep.findById(id).orElse(null);
		return new ResponseEntity<M_bank>(bank,HttpStatus.OK);
	}
	catch(Exception e){
		return new ResponseEntity<M_bank>(HttpStatus.NO_CONTENT);
	}
	}


	@PostMapping("/insertbank")
	public ResponseEntity<M_bank> insertBank(@RequestBody M_bank bank){
	try {
		bank.setCreated_by(1L);
		bank.setCreated_on(LocalDateTime.now());
		this.bankrep.save(bank);
		return new ResponseEntity<M_bank>(bank, HttpStatus.OK);
	}
	catch(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<M_bank>(HttpStatus.NO_CONTENT);
	}
	}
	
	@PutMapping("/editBank/{id}")
	public ResponseEntity<M_bank> editbank (@RequestBody M_bank bank,@PathVariable Long id){
		try {
			
			bank.setId(id);
			this.bankrep.save(bank);
			return new ResponseEntity<M_bank>(bank,HttpStatus.OK);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<M_bank>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/deleteBank/{id}")
	public ResponseEntity<?> deleteBank(@PathVariable Long id){
		try {
			M_bank bank = this.bankrep.findById(id).orElse(null);
			if(bank!=null) {
			this.bankrep.deleteById(id);
			return new ResponseEntity<M_bank>(HttpStatus.OK);
			}
			else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("Gagal menghapus id" + id + "karna tidak ditemukan");
			}
			}catch(Exception e){
			return new ResponseEntity<M_bank>(HttpStatus.NO_CONTENT);	
	}
	}
	
	@GetMapping("/bankcheck/{check}")
	public ResponseEntity<List<M_bank>> check (@PathVariable ("check") String check ){
		try {
			List<M_bank> bank = bankrep.cheking(check);
			return new ResponseEntity<List<M_bank>>(bank,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<M_bank>>(HttpStatus.NO_CONTENT);
		}
	}

	
	@GetMapping("/bankcheckva/{checkva}")
	public ResponseEntity<List<M_bank>> checkva (@PathVariable ("checkva") String checkva ){
		try {
			List<M_bank> bank = bankrep.checkva(checkva);
			return new ResponseEntity<List<M_bank>>(bank,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<M_bank>>(HttpStatus.NO_CONTENT);
		}
	}
}
