package com.buraktuysuz.springboottraining.converter;

import org.springframework.stereotype.Component;

@Component
public class XmlResponseConverter implements ResponseConverter{
    @Override
    public void convert() {
        System.out.println("Xml Converter");
    }
}
