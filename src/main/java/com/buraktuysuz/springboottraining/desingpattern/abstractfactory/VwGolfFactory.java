package com.buraktuysuz.springboottraining.desingpattern.abstractfactory;

public class VwGolfFactory implements CarFactory {

    private static VwGolfFactory vwGolfFactory;

    private VwGolfFactory() {
    }

    public static VwGolfFactory INSTANCE(){
        return vwGolfFactory;
    }

    @Override
    public Car produceCar(String fuelType) {
        return new Golf(fuelType);
    }
}
