package xa.dokterhalo289.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xa.dokterhalo289.models.M_location;
import xa.dokterhalo289.models.M_location_level;
import xa.dokterhalo289.repositories.Level_lokasiRepo;
import xa.dokterhalo289.repositories.LokasiRepo;

@Controller
@RequestMapping(value="/lokasi/")
public class LokasiController {
	@Autowired LokasiRepo lokarep;
	@Autowired Level_lokasiRepo levlokrep;
	
	@GetMapping (value="/index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("/lokasi/index");
		List<M_location>listlok = this.lokarep.findAll();
		List<M_location_level>listloklev = this.levlokrep.findAll();
		view.addObject("listloklev", listloklev);
		view.addObject("listlok", listlok);
		return view;
	}
	@GetMapping (value="/home")
	public ModelAndView home() {
		ModelAndView view = new ModelAndView("/lokasi/home");
		List<M_location>listlok = this.lokarep.findAll();
		view.addObject("listlok", listlok);
		return view;
	}

	@GetMapping(value="/form")
	public ModelAndView form() {
		ModelAndView form = new ModelAndView("/lokasi/form");
		M_location m_location = new M_location();
		form.addObject("m_location", m_location);
		List<M_location_level>m_levloc = this.levlokrep.findAll();
		form.addObject("me_levloc", m_levloc); 
		return form;
	}

}
