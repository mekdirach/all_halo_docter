package xa.dokterhalo289.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import groovy.lang.Binding;
import xa.dokterhalo289.models.T_doctor_office;
import xa.dokterhalo289.models.M_medical_facility;
import xa.dokterhalo289.models.M_biodata;
import xa.dokterhalo289.models.M_doctor;
import xa.dokterhalo289.models.M_doctor_education;
import xa.dokterhalo289.models.T_current_doctor_specialization;
import xa.dokterhalo289.models.T_doctor_treatment;
import xa.dokterhalo289.repositories.BiodataRepo;
import xa.dokterhalo289.repositories.ChatRepo;
import xa.dokterhalo289.repositories.DoctorOfficeRepo;
import xa.dokterhalo289.repositories.DoktorRepo;
import xa.dokterhalo289.repositories.EducationRepo;
import xa.dokterhalo289.repositories.JanjiRepo;
import xa.dokterhalo289.repositories.MedicalFacilityRepo;
import xa.dokterhalo289.repositories.SpesalisRepo;
import xa.dokterhalo289.repositories.Treatments;

@Controller
@RequestMapping(value = "/doktor/")
public class DoktorController {
    @Autowired
    DoktorRepo doctorrepo;
    @Autowired
    BiodataRepo biorepo;
    @Autowired
    SpesalisRepo spesalisrepo;
    @Autowired
    EducationRepo educationrepo;
    @Autowired
    Treatments treatmentrepo;
    @Autowired
    MedicalFacilityRepo medicalrepo;
    @Autowired
    DoctorOfficeRepo officeRepo;
    @Autowired
    JanjiRepo janjirepo;
    @Autowired
    ChatRepo chatrepo;

    @GetMapping(value = "/landing_page")
    public ModelAndView landingpage() {
        ModelAndView view = new ModelAndView("/doktor/landing_page");
        return view;
    }

    @GetMapping(value = "/profil")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/doktor/home");

        List<M_doctor> doctor = this.doctorrepo.dataDoctorById((long) 1);
        view.addObject("doctor", doctor);
        List<M_biodata> bio = this.biorepo.findAll();
        view.addObject("bio", bio);
        List<T_current_doctor_specialization> spesalis = this.spesalisrepo.listspesialization((long) 1);
        view.addObject("spesalis", spesalis);
        List<M_doctor_education> education = this.educationrepo.listedudoctor((long) 1);
        view.addObject("education", education);
        List<T_doctor_treatment> treatment = this.treatmentrepo.listtreatment((long) 1);
        view.addObject("treatment", treatment);
        List<T_doctor_office> praktek = this.officeRepo.listmedical((long) 1);
        view.addObject("praktek", praktek);
        Long countjanji = this.janjirepo.hitungJanji((long) 1);
        view.addObject("countjanji", countjanji);
        Long countchat = this.chatrepo.countchat((long) 1);
        view.addObject("countchat", countchat);
        return view;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editform(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView("/doktor/showimage");
        Optional<M_biodata> image = this.biorepo.findById(id);
        view.addObject("image", image);
        return view;
    }

    private static String UPLOADED_FOLDER = "C:\\Users\\user\\Documents\\289-workspace_rachmadi\\dokterhalo\\dokterhalo289\\assets\\photos\\";

    @PostMapping(value = "/simpan")
    public ModelAndView editFto(@ModelAttribute M_biodata biodata, BindingResult result,
            @RequestParam("photofile") MultipartFile file) throws Exception {
        if (!result.hasErrors()) {
            try {
                if (file.getOriginalFilename() != "") {
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                    Files.write(path, bytes);
                }
                biodata.setCreated_by((long) 1);
                biodata.setCreated_on(LocalDateTime.now());
                this.biorepo.save(biodata);

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return new ModelAndView("redirect:/doktor/profil");
    }

}
