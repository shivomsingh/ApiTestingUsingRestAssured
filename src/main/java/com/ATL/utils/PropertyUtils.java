package com.ATL.utils;

import com.ATL.constants.FrameworkConstants;
import com.ATL.enums.PropertiesType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils(){}

    private static Properties prop = new Properties();
    private static Map<String, String> map = new HashMap<>();

//    public static void readPropertyFileAndStoreInMap(){
//
//        try {
//            FileInputStream inputStream = new FileInputStream("");
//            prop.load(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        prop.entrySet().forEach(e -> map.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
//    }

    static {
        try(FileInputStream inputStream = new FileInputStream(FrameworkConstants.getPropertyFilePath())){
            prop.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.exit(0);
        prop.entrySet().forEach(e -> map.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
    }

    public static String getValue(PropertiesType key){
        return map.get(key.name().toLowerCase());
    }
}
