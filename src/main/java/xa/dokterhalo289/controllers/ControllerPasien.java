package xa.dokterhalo289.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import groovyjarjarpicocli.CommandLine.Model;
import xa.dokterhalo289.models.M_customer;
import xa.dokterhalo289.repositories.PasienRepoo;

@Controller
@RequestMapping(value="/pasien")
public class ControllerPasien {
@Autowired PasienRepoo parep;

@RequestMapping("/index")
public ModelAndView index() {
	ModelAndView view = new ModelAndView("/pasien/index");
	List<M_customer>listco = this.parep.findAll();
	view.addObject("listco", listco);
	return view;
}

@RequestMapping("/pasien")
public ModelAndView pasien() {
	ModelAndView view = new ModelAndView("/pasien/pasien");
	return view;
}

}
