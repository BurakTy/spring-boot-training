package com.buraktuysuz.springboottraining.desingpattern.abstractfactory;

public interface CarModelFactory {

    Car produceCar(String model, String fuelType);
}
