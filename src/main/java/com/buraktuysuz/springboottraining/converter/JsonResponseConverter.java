package com.buraktuysuz.springboottraining.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class JsonResponseConverter implements ResponseConverter{
    @Override
    public void convert() {
        System.out.println("Json Converter");
    }
}
