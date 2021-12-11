package com.buraktuysuz.springboottraining.service;


import com.buraktuysuz.springboottraining.converter.ResponseConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WebService {

//    @Qualifier("xml")
    private ResponseConverter responseConverter;

    public WebService(ResponseConverter responseConverter){
        this.responseConverter=responseConverter;
    }

    public void convertResponse(){
        this.responseConverter.convert();
    }
}
