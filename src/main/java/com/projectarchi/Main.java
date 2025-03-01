package com.projectarchi;

import org.amu.model.Person;
import org.amu.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private PersonRepository personsRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Création et persistance d'une nouvelle instance de Personne
        Person personne = new Person(2L);
        personne.setNom("ObiWan");
        personne.setAge(32);




        personsRepository.save(personne);

        List<Person> toutesLesPersonnes =  personsRepository.findAll();

        System.out.println("All items in repository: "+ personsRepository.findAll());


    }
