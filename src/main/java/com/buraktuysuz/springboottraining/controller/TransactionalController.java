package com.buraktuysuz.springboottraining.controller;

import com.buraktuysuz.springboottraining.transactionnal.ts10.Ts10Service1;
import com.buraktuysuz.springboottraining.transactionnal.ts1.Ts1Service;
import com.buraktuysuz.springboottraining.transactionnal.ts11.Ts11Service1;
import com.buraktuysuz.springboottraining.transactionnal.ts2.Ts2Service;
import com.buraktuysuz.springboottraining.transactionnal.ts3.Ts3Service1;
import com.buraktuysuz.springboottraining.transactionnal.ts4.Ts4Service1;
import com.buraktuysuz.springboottraining.transactionnal.ts5.Ts5Service1;
import com.buraktuysuz.springboottraining.transactionnal.ts6.Ts6Service1;
import com.buraktuysuz.springboottraining.transactionnal.ts7.Ts7Service;
import com.buraktuysuz.springboottraining.transactionnal.ts8.Ts8Service1;
import com.buraktuysuz.springboottraining.transactionnal.ts9.Ts9Service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactional")
public class TransactionalController {

    @Autowired
    private Ts1Service ts1Service;
    @Autowired
    private Ts2Service ts2Service;
    @Autowired
    private Ts3Service1 ts3Service;
    @Autowired
    private Ts4Service1 ts4Service;
    @Autowired
    private Ts5Service1 ts5Service;
    @Autowired
    private Ts6Service1 ts6Service;
    @Autowired
    private Ts7Service ts7Service;
    @Autowired
    private Ts8Service1 ts8Service;
    @Autowired
    private Ts9Service1 ts9Service;
    @Autowired
    private Ts10Service1 ts10Service;
    @Autowired
    private Ts11Service1 ts11Service;


    /**
     * 1: transactional olmayan yerde kayıt işlemi
     **/

    @PostMapping("/ts1")
    public void transactionnal() {
        ts1Service.save();
    }

    /**
     * 2: transactional olan yerde kayıt işlemi
     **/

    @PostMapping("/ts2")
    public void transactionnal2() {
        ts2Service.save();
    }

    /**
     * 3: transactional olan yerden olmayan yere geçme
     */
    @PostMapping("/ts3")
    public void ts3() {
        ts3Service.save();
    }

    /**
     * 4: transactional olmayan yerden olan yere geçme
     */
    @PostMapping("/ts4")
    public void ts4() {
        ts4Service.save();
    }

    /**
     * 5: ikisi de transactional olan bir yerde kayıt işlemi
     */
    @PostMapping("/ts5")
    public void ts5() {
        ts5Service.save();
    }

    /**
     * 6: sadece transactional olan bir yerde kayıt işlemi sırasında hata
     */
    @PostMapping("/ts6")
    public void ts6() {
        ts6Service.save();
    }

    /**
     * 7: aynı class içinde requires new kullanımı.
     */
    @PostMapping("/ts7")
    public void ts7() {
        ts7Service.save();
    }

    /**
     * 8: requires new i farklı classa taşıma.
     */
    @PostMapping("/ts8")
    public void ts8() {
        ts8Service.save();
    }

    /**
     * 9: requires new ile hata almayanları commitleme.
     */
    @PostMapping("/ts9")
    public void ts9() {
        ts9Service.save();
    }

    /**
     *  10: mandatory transaction yok
     */
    @PostMapping("/ts10")
    public void ts10() {
        ts10Service.save();
    }
    /**
     *  11: mandatory transaction var
     */
    @PostMapping("/ts11")
    public void ts11() {
        ts11Service.save();
    }

    /**
     *  12: supports transaction var
     */
    @PostMapping("/ts11")
    public void ts12() {
        ts11Service.save();
    }
    /**
     *  13: supports transaction yok
     */
    @PostMapping("/ts11")
    public void ts13() {
        ts11Service.save();
    }
    /**
     *  4: not_suppoted (hızlı)
     */
    @PostMapping("/ts11")
    public void ts14() {
        ts11Service.save();
    }


    /**
     * NOT   transaction kontrol-aç-kapa-commit gibi işlemleri yaptıkları için gerekmedikçe kullanmamak gerekli yoksa çok maliyetli oluyor
     *
     * 16-17-18  maliyeler için birer örnek githum sbahadirm/n11-bootcamp-spring-boot-training  adresinden örneklere bakılabilir
     *
     * 15: nested (desteklenmez) //  örneğini yapmadım
     * 16: toplu işlemlerinizi transactional olmayan yerde yapın.en hızlı senaryo
     * 17: transaction açmasa bile transactional olan bir metotta işlem yapma kapatma maliyeti
     * 18: transaction açıp kapatma maliyeti
     **/
}
