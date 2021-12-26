package com.buraktuysuz.springboottraining.desingpattern.memento;

public class Memento {

    private String text;

    public Memento() {
        this.text = "";
    }

    public Memento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
