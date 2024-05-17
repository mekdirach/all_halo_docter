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
@RequestMapping(value="/location/")
public class LocationController {
	@Autowired LokasiRepo locrepo;
	@Autowired Level_lokasiRepo levrepo;
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("/location/index");
		List<M_location>listloc = this.locrepo.findAll();
		view.addObject("listloc", listloc);
		//List<M_location_level>listlevel = this.levrepo.findAll();
		//view.addObject("listlevel", listlevel);
		return view;
		
	}

}
