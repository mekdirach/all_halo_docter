package xa.dokterhalo289.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xa.dokterhalo289.models.M_bank;
import xa.dokterhalo289.repositories.BankRepo;


@Controller
@RequestMapping(value="/bank/")
public class BankContorller {
	@Autowired
	private BankRepo bankrep;
	
	@GetMapping(value="/index")
	public ModelAndView index() {
	ModelAndView view = new ModelAndView("/bank/index");
	List< M_bank>listbank = this.bankrep.findAll();
	view.addObject("listbank", listbank);
	return view;
	}
			

}
