package com.ATL.utils;


import com.github.javafaker.Faker;

public final class RandomUtils {

    private RandomUtils(){}

    public static String getCityName(){
        return FakerUtils.generateCityName().toLowerCase();
    }

    public static String getName(){
        return FakerUtils.generateName().toUpperCase();
    }

    public static int getID(int Range1, int Range2){
        return FakerUtils.generateID(Range1, Range2);
    }

    public static String getJobName(){
        return FakerUtils.generateJobName();
    }
}
