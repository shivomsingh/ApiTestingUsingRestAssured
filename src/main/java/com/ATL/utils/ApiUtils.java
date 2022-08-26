package com.ATL.utils;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public final class ApiUtils {

    private ApiUtils(){}

    @SneakyThrows                                                /*sneaky throws annnotation is provided by lomok*/
    public static String readJsonAndGetAsString(String filepath){
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }

    @SneakyThrows
    public static void storeStringAsJsonFile(String FilePath, Response response){
        Files.write(Paths.get(FilePath), response.asByteArray());
    }
}
