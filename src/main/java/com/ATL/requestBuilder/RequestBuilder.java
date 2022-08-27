package com.ATL.requestBuilder;

import com.ATL.enums.PropertiesType;
import com.ATL.utils.PropertyUtils;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public final class RequestBuilder {

    private RequestBuilder(){}

    public static RequestSpecification buildRequestForGETCalls(){
        return  given()
                .baseUri(PropertyUtils.getValue(PropertiesType.BASEURL))
                .log()
                .all();
    }

    public static RequestSpecification buildRequestForPOSTCalls(){
        return
//                given()
//                .baseUri("https://reqres.in/api")
//                .log()
//                .all()
                buildRequestForGETCalls()
                .contentType("application/json");
    }
}
