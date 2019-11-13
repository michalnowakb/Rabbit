package com.sparta.mjn.model;

import java.util.Random;

public class Rabbit {
    private int age;
    private String gender;
    private String name;

    public Rabbit(int age, String gender, String name) {
        this.age = age;
        this.gender = gender;
        this.name = name;
    }

    public Rabbit(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void incrementAge() {
        age++;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        gender = genderGenerator();
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String genderGenerator() {
        String zero = "Male";
        String one = "Female";
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        if (randomNumber == 0) {
            gender = zero;
        } else {
            gender = one;
        }

        return gender;
    }
}
