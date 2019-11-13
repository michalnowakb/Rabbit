package com.sparta.mjn.controller;

import com.sparta.mjn.model.AnimalsFactory;

public class Manager {

    AnimalsFactory animalsFactory = new AnimalsFactory();

    public void initializeFactory() {
        animalsFactory.createPopulation();

    }
}
