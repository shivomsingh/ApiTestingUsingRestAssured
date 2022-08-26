package com.ATL.constants;

import lombok.Getter;
@Getter
public final class FrameworkConstantsSingleton {

    private FrameworkConstantsSingleton(){}

    private static FrameworkConstantsSingleton Instance = null;

    public static FrameworkConstantsSingleton getInstance(){
        if(Instance == null)
            Instance = new FrameworkConstantsSingleton();
        return Instance;
    }

    private  final String requestFolderPath = System.getProperty("user.dir") + "/src/test/resources/jsons/";
    private  final String responseFolderPath = System.getProperty("user.dir") + "/Output/";
}
