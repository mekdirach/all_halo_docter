package xa.dokterhalo289.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xa.dokterhalo289.repositories.MedicalitemCategoryRepo;
 
@Controller
@RequestMapping(value="/medicalitem/")
public class MedicalitemCategory_Controller {
	@Autowired MedicalitemCategoryRepo repo;
	
    @GetMapping(value = "index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("/medical_item/index");
        return view;
    }

}
