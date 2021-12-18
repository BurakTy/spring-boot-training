package com.buraktuysuz.springboottraining.controller;

import com.buraktuysuz.springboottraining.dto.CategoryDto;
import com.buraktuysuz.springboottraining.transactionnal.ts1.Ts1Service;
import com.buraktuysuz.springboottraining.transactionnal.ts2.Ts2Service;
import com.buraktuysuz.springboottraining.transactionnal.ts3.Ts3Service1;
import com.buraktuysuz.springboottraining.transactionnal.ts4.Ts4Service1;
import com.buraktuysuz.springboottraining.transactionnal.ts5.Ts5Service1;
import com.buraktuysuz.springboottraining.transactionnal.ts6.Ts6Service1;
import com.buraktuysuz.springboottraining.transactionnal.ts7.Ts7Service;
import com.buraktuysuz.springboottraining.transactionnal.ts8.Ts8Service1;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactional")
public class TransactionalController {


    private Ts1Service ts1Service;
    private Ts2Service ts2Service;
    private Ts3Service1 ts3Service;
    private Ts4Service1 ts4Service;
    private Ts5Service1 ts5Service;
    private Ts6Service1 ts6Service;
    private Ts7Service ts7Service;
    private Ts8Service1 ts8Service;
//    private Ts9Service1 ts9Service;
//    private Ts10Service1 ts10Service;
//    private Ts11Service1 ts11Service;


    public TransactionalController(Ts1Service ts1Service, Ts2Service ts2Service, Ts3Service1 ts3Service, Ts4Service1 ts4Service,
                                   Ts5Service1 ts5Service, Ts6Service1 ts6Service, Ts7Service ts7Service, Ts8Service1 ts8Service
    ) {
        this.ts1Service = ts1Service;
        this.ts2Service = ts2Service;
        this.ts3Service = ts3Service;
        this.ts4Service = ts4Service;
        this.ts5Service = ts5Service;
        this.ts6Service = ts6Service;
        this.ts7Service = ts7Service;
        this.ts8Service = ts8Service;
    }

    /**
     * 1: transactional olmayan yerde kayıt işlemi
     **/

    @PostMapping("/ts1")
    public void transactionnal(@RequestBody CategoryDto categoryDto) {
        ts1Service.save();
    }

    /**
     * 2: transactional olan yerde kayıt işlemi
     **/

    @PostMapping("/ts2")
    public void transactionnal2(@RequestBody CategoryDto categoryDto) {
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
    @PostMapping("/ts5")
    public void ts6() {
        ts6Service.save();
    }

    /**
     * 7: aynı class içinde requires new kullanımı.
     */
    @PostMapping("/ts5")
    public void ts7() {
        ts7Service.save();
    }

    /**
     * 8: requires new i farklı classa taşıma.
     */
    @PostMapping("/ts5")
    public void ts8() {
        ts8Service.save();
    }


    /**
     *
     * 9: requires new ile hata almayanları commitleme.
     * 10: mandatory transaction yok
     * 11: mandatory transaction var
     * 12: supports transaction var
     * 13: supports transaction yok
     * 14: not_suppoted (hızlı)
     * 15: nested (desteklenmez)
     * 16: toplu işlemlerinizi transactional olmayan yerde yapın.en hızlı senaryo
     * 17: transaction açmasa bile transactional olan bir metotta işlem yapma kapatma maliyeti
     * 18: transaction açıp kapatma maliyeti
     **/
}
