package xa.dokterhalo289.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import xa.dokterhalo289.models.M_biodata;
import xa.dokterhalo289.models.T_doctor_office;
import xa.dokterhalo289.models.M_doctor;
import xa.dokterhalo289.models.M_specialization;
import xa.dokterhalo289.models.T_current_doctor_specialization;
import xa.dokterhalo289.repositories.BiodataRepo;
import xa.dokterhalo289.repositories.DoctorOfficeRepo;
import xa.dokterhalo289.repositories.DoktorRepo;
import xa.dokterhalo289.repositories.SpesalisRepo;
import xa.dokterhalo289.repositories.Spesialization;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/")
public class ApiDoktorController {
    @Autowired DoktorRepo doctorepo;
    @Autowired DoctorOfficeRepo officerepo;
    @Autowired SpesalisRepo spesalisrepo;
    @Autowired Spesialization listsperepo;
    @Autowired BiodataRepo biodatarepo;


    @GetMapping(value = "profil/{id}")
    public ResponseEntity<List<M_doctor>> getDoctorbyId(@PathVariable("id") Long id){
        try {
            List<M_doctor> doctor = doctorepo.dataDoctorById(id);
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping(value = "praktek/")
    public ResponseEntity<List<T_doctor_office>> getRiwayatpraktek(){
        try{
            List<T_doctor_office> riwayat = officerepo.listriwayat((long)1);
            return new ResponseEntity<>(riwayat, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping(value="spesalis/")
    public ResponseEntity<T_current_doctor_specialization> getData() {
        try {
            List<T_current_doctor_specialization> spesalis = spesalisrepo.listspesialization((long)1);
            T_current_doctor_specialization spesialis2 = spesalis.get(0);
            return new ResponseEntity<>(spesialis2, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping(value = "listspesialis/")
    public ResponseEntity<List<M_specialization>> getSpesialis(){
        try {
            List<M_specialization> listspesialis = listsperepo.findspec();
            return new ResponseEntity<>(listspesialis, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }  
    @PutMapping(value="editcurrent/{id}")
    public ResponseEntity<T_current_doctor_specialization> editcurrent(@RequestBody T_current_doctor_specialization specialization, @PathVariable("id") Long id) {
        try {
            specialization.setId(id);
            specialization.setCreated_by((long)1);
            specialization.setCreated_on(LocalDateTime.now());
            specialization.setModified_on(LocalDateTime.now());
            specialization.setModified_by((long)1);
            specialization.setDoctor_id((long)1);
            this.spesalisrepo.save(specialization);
            return new ResponseEntity<T_current_doctor_specialization>(specialization, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<T_current_doctor_specialization>(specialization, HttpStatus.NO_CONTENT);

        }
       
    } 
    @PostMapping(value = "save")
    public ResponseEntity<T_current_doctor_specialization> saveData(@RequestBody T_current_doctor_specialization spesalis){
        try {
            spesalis.setCreated_by((long)1);
            spesalis.setCreated_on(LocalDateTime.now());
            spesalis.setDoctor_id((long)1);
			this.spesalisrepo.save(spesalis);
			return new ResponseEntity<T_current_doctor_specialization>(spesalis, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<T_current_doctor_specialization>(HttpStatus.NO_CONTENT);
		}
    }
    @GetMapping(value = "riwayat/")
    public ResponseEntity<List<T_doctor_office>>  riwayatpraktek(){
        try {
            List<T_doctor_office> riwayat = officerepo.listmedical((long)1);
            return new ResponseEntity<>(riwayat, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
    private static String UPLOADED_FOLDER = "C:\\Users\\user\\Documents\\GitHub\\dokterhalo\\dokterhalo289\\assets\\photos\\";
    @PutMapping(value="editFto/{id}")
    public ResponseEntity<M_biodata> editFto(@PathVariable Long id, @RequestBody M_biodata biodata, @RequestParam("photofile") MultipartFile file) throws Exception{
        try {
            if(file.getOriginalFilename() != "") { 
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER+file.getOriginalFilename());
                Files.write(path, bytes);
            }
            biodata.setId(id);
            biodata.setCreated_by((long)1);
            biodata.setCreated_on(LocalDateTime.now());
            this.biodatarepo.save(biodata);
            return new ResponseEntity<M_biodata>(biodata, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<M_biodata>(biodata, HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping(value = "getbiodata/{id}")
    public ResponseEntity<M_biodata> getbiodatabyId(@PathVariable("id") Long id){
        try {
            M_biodata biodata = biodatarepo.findById(id).orElse(null);
            return new ResponseEntity<M_biodata>(biodata, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<M_biodata>(HttpStatus.NO_CONTENT);
        }
    }
}
