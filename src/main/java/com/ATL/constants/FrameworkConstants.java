package com.ATL.constants;

import lombok.Getter;

public final class FrameworkConstants {

    private static @Getter final String requestFolderPath = System.getProperty("user.dir") + "/src/test/resources/jsons/";
    private static @Getter final String responseFolderPath = System.getProperty("user.dir") + "/Output/";
}
