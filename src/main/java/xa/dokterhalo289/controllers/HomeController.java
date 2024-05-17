package xa.dokterhalo289.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
    @GetMapping(value="/")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("/home/index");
        return view;
    }
    

    
}