package xa.dokterhalo289.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xa.dokterhalo289.models.T_customer_custom_nominal;
import xa.dokterhalo289.models.T_customer_wallet;
import xa.dokterhalo289.models.T_customer_wallet_withdraw;
import xa.dokterhalo289.models.M_wallet_default_nominal;
import xa.dokterhalo289.repositories.TarikSaldoRepo;
import xa.dokterhalo289.repositories.CustomerWalletRepo;
import xa.dokterhalo289.repositories.InputNomCusRepo;
import xa.dokterhalo289.repositories.NominalWalletRepo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class ApiWalletController {
    @Autowired TarikSaldoRepo cuswalletrepo;
    @Autowired NominalWalletRepo nomwalletrepo;
    @Autowired CustomerWalletRepo customernominalwalletrepo;
    @Autowired InputNomCusRepo inputnomcusrepo;

    @GetMapping(value = "/nominal")
    public ResponseEntity<List<M_wallet_default_nominal>> getNominal(){
        try {
            List<M_wallet_default_nominal> listnominal = nomwalletrepo.findAll();
            return new ResponseEntity<>(listnominal, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping(value="/nominal/{id}")
    public ResponseEntity<M_wallet_default_nominal> getNominalbyId(@PathVariable("id") Long id) {
        try {
			M_wallet_default_nominal nominal = this.nomwalletrepo.findById(id).orElse(null);
			return new ResponseEntity<M_wallet_default_nominal>(nominal, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<M_wallet_default_nominal>(HttpStatus.NO_CONTENT);
		}
    }
    @GetMapping(value = "/cuswallet")
    public ResponseEntity<List<T_customer_wallet>> getWalletCus(){
        try {
            List<T_customer_wallet> wallet = this.customernominalwalletrepo.getCus((long)1);
            return new ResponseEntity<List<T_customer_wallet>>(wallet, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
        	e.printStackTrace();
            return new ResponseEntity<List<T_customer_wallet>>(HttpStatus.NO_CONTENT);

        }
    }
    @GetMapping(value = "/pin/{pincode}")
    public ResponseEntity<T_customer_wallet> getPin(@PathVariable("pincode") String pincode){
        try {
            List<T_customer_wallet> getpincus = this.customernominalwalletrepo.getpincode(pincode, (long)1);
            T_customer_wallet getpin = getpincus.get(0);
            return new ResponseEntity<>(getpin, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping(value = "/inputnom")
    public ResponseEntity<T_customer_custom_nominal> inputNominal(@RequestBody T_customer_custom_nominal walletcustom){
        try {
            walletcustom.setCreated_by((long)1);
            walletcustom.setCreated_on(LocalDateTime.now());
            walletcustom.setCustomer_id((long)1);
            this.inputnomcusrepo.save(walletcustom);
            return new ResponseEntity<>(walletcustom, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping(value = "/customnom/{id}")
    public ResponseEntity<T_customer_custom_nominal> customNominalById(@PathVariable("id") Long id){
        try {
            T_customer_custom_nominal customnombyid = this.inputnomcusrepo.findById(id).orElse(null);
            return new ResponseEntity<T_customer_custom_nominal>(customnombyid, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<T_customer_custom_nominal>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping(value = "/customnom")
    public ResponseEntity<List<T_customer_custom_nominal>> customNominal(){
        try {
            List<T_customer_custom_nominal> getcustom = this.inputnomcusrepo.getcustomnom((long)1);
            return new ResponseEntity<>(getcustom, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/inputsaldo")
    public ResponseEntity<T_customer_wallet_withdraw> inputSaldoTransaksi(@RequestBody T_customer_wallet_withdraw saldotransaksi){
        try {
           
            saldotransaksi.setCreate_by((long)1);
            saldotransaksi.setCreate_on(LocalDateTime.now());
            saldotransaksi.setCustomer_id((long)1);
            //saldotransaksi.setOtp(otpcus);
            this.cuswalletrepo.save(saldotransaksi);
            return new ResponseEntity<>(saldotransaksi, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping(value = "/getTransaksi")
    public ResponseEntity<List<T_customer_wallet_withdraw>> getTransaksi(){
        try {
            List<T_customer_wallet_withdraw> getTransaksi = this.cuswalletrepo.getTransaksibyCus((long)1);
            return new ResponseEntity<>(getTransaksi, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PutMapping(value = "/editWalletCus/{id}")
    public ResponseEntity<T_customer_wallet> EditwalletCustomer(@RequestBody T_customer_wallet walletcus, @PathVariable Long id){
        try {
            walletcus.setId(id);
            walletcus.setModified_by((long)1);
            walletcus.setModified_on(LocalDateTime.now());
            this.customernominalwalletrepo.save(walletcus);
            return new ResponseEntity<>(walletcus,HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping(value = "/walldefault/{nominal}")
    public ResponseEntity<M_wallet_default_nominal> getwalletnominal(@PathVariable("nominal") Long nominal){
        try {
        	List<M_wallet_default_nominal> walletnominal = this.nomwalletrepo.getnominal(nominal);
        	M_wallet_default_nominal wallnom = walletnominal.get(0);
            return new ResponseEntity<M_wallet_default_nominal>(wallnom, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
        	e.printStackTrace();
            return new ResponseEntity<M_wallet_default_nominal>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping(value = "/customNominal/{nominal}")
    public ResponseEntity<T_customer_custom_nominal> getcustomnominal(@PathVariable("nominal") Long nominal){
        try {
        	List<T_customer_custom_nominal> customnominal = this.inputnomcusrepo.getnominalcustom(nominal);
        	T_customer_custom_nominal custom = customnominal.get(0);
            return new ResponseEntity<T_customer_custom_nominal>(custom, HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
        	e.printStackTrace();
            return new ResponseEntity<T_customer_custom_nominal>(HttpStatus.NO_CONTENT);
        }
    }

    //generate otp
    // static String getOTP(int n) {
    //     String getOTP ="0123456789";
                       
    //     StringBuilder sb = new StringBuilder(n);
    //     for(int i =0; i<n; i++) {
    //         int index = (int)(getOTP.length()*Math.random());
    //         sb.append(getOTP.charAt(index));
    //     }
    //     return sb.toString();
    // } 

}
