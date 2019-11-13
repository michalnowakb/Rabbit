package com.sparta.mjn.view;

import com.sparta.mjn.controller.Manager;


public class DisplayManager {

    public void displayRabbitsDetails(int population, int numberOfFemales, int numberOfMales, int numberOfMonths){
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Month number: " + numberOfMonths);
        System.out.println("Total population is: " + population);
        System.out.println("With number of males: " + numberOfMales);
        System.out.println("And number of females:" + numberOfFemales);

    }


}
