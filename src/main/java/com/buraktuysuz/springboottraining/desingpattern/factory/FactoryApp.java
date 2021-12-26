package com.buraktuysuz.springboottraining.desingpattern.factory;

public class FactoryApp {

    public static void main(String[] args) {

//        Polo polo1 = new Polo("gasoline");

        Car polo = CarFactory.produceCar("polo", "Gasoline");
        polo.print();

        Car civic = CarFactory.produceCar("civic", "");
        civic.print();
    }
}
