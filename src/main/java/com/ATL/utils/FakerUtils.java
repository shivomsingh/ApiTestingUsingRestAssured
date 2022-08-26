package com.ATL.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

    private FakerUtils(){}

     static String generateCityName(){
        return new Faker().country().name();
    }

     static int generateID(int Range1, int Range2){
        return new Faker().number().numberBetween(Range1, Range2);
    }

     static String generateName(){
        return new Faker().name().firstName();
    }

     static String generateJobName(){
        return new Faker().job().title();
    }

}
