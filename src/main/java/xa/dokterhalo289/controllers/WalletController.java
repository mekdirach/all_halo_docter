package xa.dokterhalo289.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xa.dokterhalo289.models.T_customer_wallet;
import xa.dokterhalo289.repositories.CustomerWalletRepo;

@Controller
@RequestMapping(value="wallet")
public class WalletController {
    @Autowired CustomerWalletRepo walletRepo;

    @GetMapping(value="/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("tarik_saldo/index");
        return view;
    }
    
}
