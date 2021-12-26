package com.buraktuysuz.springboottraining.desingpattern.adapter;

public class Iron implements RunnableWith200 {

    @Override
    public void run() {
        System.out.println("Iron works!");
    }
}
