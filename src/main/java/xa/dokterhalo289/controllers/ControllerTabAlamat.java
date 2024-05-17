package xa.dokterhalo289.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xa.dokterhalo289.models.M_biodata_address;
import xa.dokterhalo289.repositories.AlamatRepo;


@Controller
@RequestMapping(value="/alamat/")
public class ControllerTabAlamat {
@Autowired AlamatRepo alrep;

@GetMapping("/index")
public ModelAndView index() {
	ModelAndView view = new ModelAndView("/tabalamat/index");
	List<M_biodata_address> listdress = this.alrep.findAll();
	view.addObject("listdress", listdress);
	return view;
}
@GetMapping("/alamat")
public ModelAndView alamat() {
	ModelAndView view = new ModelAndView("/tabalamat/alamat");
	return view;
}


}
