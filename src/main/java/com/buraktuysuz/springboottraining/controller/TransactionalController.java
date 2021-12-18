package com.buraktuysuz.springboottraining.controller;

import com.buraktuysuz.springboottraining.dto.CategoryDto;
import com.buraktuysuz.springboottraining.transactionnal.ts1.Ts1Service;
import com.buraktuysuz.springboottraining.transactionnal.ts2.Ts2Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TransactionalController {


    private Ts1Service ts1Service;
    private Ts2Service ts2Service;

    public TransactionalController(Ts1Service ts1Service, Ts2Service ts2Service) {
        this.ts1Service = ts1Service;
        this.ts2Service = ts2Service;
    }
    /**
     * 1: transactional olmayan yerde kayıt işlemi
     * @param CategoryDto
     *
     **/

    @PostMapping("/ts1")
    public void transactionnal(@RequestBody CategoryDto categoryDto){
        ts1Service.save();
    }

    /**
     * 1: transactional olan yerde kayıt işlemi
     * @param CategoryDto
     *
     **/

    @PostMapping("/ts2")
    public void transactionnal2(@RequestBody CategoryDto categoryDto){
        ts2Service.save();
    }


    /**
     *
     * 2: transactional olan yerde kayıt işlemi
     * 3: transactional olan yerden olmayan yere geçme
     * 4: transactional olmayan yerden olan yere geçme
     * 5: ikisi de transactional olan bir yerde kayıt işlemi
     * 6: sadece transactional olan bir yerde kayıt işlemi sırasında hata
     * 7: aynı class içinde requires new kullanımı.
     * 8: requires new i farklı classa taşıma.
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
