package com.buraktuysuz.springboottraining.desingpattern.adapter;

public class Fridge implements RunnableWith200 {

    @Override
    public void run() {
        System.out.println("Fridge works!");
    }
}
