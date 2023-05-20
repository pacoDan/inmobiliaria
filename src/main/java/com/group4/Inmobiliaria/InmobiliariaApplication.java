package com.group4.Inmobiliaria;

import com.group4.Inmobiliaria.controller.BusquedaPropiedadController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InmobiliariaApplication {//implements CommandLineRunner {
    @Autowired
    private BusquedaPropiedadController myController;
    public static void main(String[] args) {
        System.out.println("1Holassss----------------------------------------------------------------------------");
        SpringApplication.run(InmobiliariaApplication.class, args);
        System.out.println("2Holassss----------------------------------------------------------------------------");
    }

//    @Override
//    public void run(String... args) {
//        myController.someMethod();
//    }

}
