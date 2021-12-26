package com.buraktuysuz.springboottraining.desingpattern.builder.withlombok;

public class Emlakci2 {

    public static void main(String[] args) {

        Ev2 ev = Ev2.builder()
                .il("İstanbul")
                .ilce("Ümraniye")
                .build();

        System.out.println(ev);
    }
}
