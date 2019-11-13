package com.sparta.mjn.model;

import com.sparta.mjn.view.DisplayManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalsFactory {
    DisplayManager displayManager = new DisplayManager();

    List<Rabbit> adultRabbits;
    List<Rabbit> babyRabbits;

    List<Fox> adultFoxes;
    List<Fox> babyFoxes;

    private final String randomRabbitName = "Rabbit";
    private final String randomFoxName = "Fox";

    private int adultFemaleRabbitCounter = 1;
    private int femaleRabbitCounter = 1;
    private int maleRabbitCounter = 1;

    private int adultFemaleFoxCounter = 1;
    private int femaleFoxCounter = 1;
    private int maleFoxCounter = 1;

    private int rabbitNameNumber = 0;
    private int foxNameNumber = 0;
    private String gender = "Female";
    private int monthCounter = 1;


    public void createPopulation() {
        adultRabbits = new ArrayList<>();
        babyRabbits = new ArrayList<>();
        Rabbit rabbitM = new Rabbit(0, "Male", randomNameGenerator(randomRabbitName));
        Rabbit rabbitF = new Rabbit(0, "female", randomNameGenerator(randomRabbitName));
        adultRabbits.add(rabbitM);
        adultRabbits.add(rabbitF);

        Random numberOfNewBabies = new Random();
        while (sizeOfPopulation() < 350000000) {
            int newBabies = numberOfNewBabies.nextInt(14) + 1;
            int babies = adultFemaleRabbitCounter * newBabies;
            for (int i = 0; i < babies; i++) {
                babyRabbits.add(new Rabbit(0, genderGenerator(gender), randomNameGenerator(randomRabbitName)));
                incubator();
            }

            increaseAge();
            checkGender();
            monthCounter++;

            displayManager.displayRabbitsDetails(sizeOfPopulation(), femaleRabbitCounter, maleRabbitCounter,monthDisplay());
        }


    }

    public void checkGender() {
        for (Rabbit listOfRabbits : adultRabbits) {
            listOfRabbits.getGender();
            if (listOfRabbits.getGender() == "Female") {
                adultFemaleRabbitCounter++;
                femaleRabbitCounter++;
            } else {
                maleRabbitCounter++;
            }
        }
        for(Rabbit listOfBabies : babyRabbits){
            listOfBabies.getGender();
            if(listOfBabies.getGender() == "Female"){
                femaleRabbitCounter++;
            } else {
                maleRabbitCounter++;
            }
        }

    }

    public void increaseAge() {
        for(Rabbit rabbits : adultRabbits) {
            rabbits.incrementAge();
        }
        for(Rabbit babyRabbit : babyRabbits){
            babyRabbit.incrementAge();
        }

    }

    public void incubator() {
        for (Rabbit rabbits : babyRabbits) {
            if (rabbits.getAge() >= 3) {
                adultRabbits.add(rabbits);
            }
        }
    }

    private String randomNameGenerator(String animalType) {

        String newName = animalType + rabbitNameNumber;
        rabbitNameNumber++;
        return newName;
    }

    private String genderGenerator(String gender) {
        Random random = new Random();
        int genderNumber = random.nextInt(2);
        if (genderNumber == 0) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        return gender;
    }

    public int sizeOfPopulation() {
        int populationSize = babyRabbits.size() + adultRabbits.size();
        return populationSize;
    }

    public int monthDisplay() {
        return monthCounter;
    }


}
