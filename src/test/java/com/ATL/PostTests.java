package com.ATL;

import com.ATL.annotations.FrameworkAnnotations;
import com.ATL.constants.FrameworkConstants;
import com.ATL.constants.FrameworkConstantsSingleton;
import com.ATL.extentReports.ExtentLogger;
import com.ATL.extentReports.ExtentReport;
import com.ATL.pojos.Users;
import com.ATL.requestBuilder.RequestBuilder;
import com.ATL.utils.ApiUtils;
import com.ATL.utils.RandomUtils;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.ATL.requestBuilder.RequestBuilder.buildRequestForPOSTCalls;
import static io.restassured.RestAssured.given;

public class PostTests {
    @Test
    @FrameworkAnnotations
    public void TC01(){
        Users user =
                Users
                        .builder()
//                        .setJob("Engineer")                             --> also it's not good to use hardcoded value
//                        .setName("shiv")
//                        .setName(new Faker().name().firstName())          --> we'll not use any 3re party lib directly
                        .setJob(RandomUtils.getJobName())
                        .setName(RandomUtils.getName())
                        .build();

        Response response =
                buildRequestForPOSTCalls()
                .body(user)
        .when()
                .post("/users");

//        response.prettyPrint();
//        ExtentReport.getTest().pass(response.prettyPrint());
        ExtentLogger.logResponse(response.prettyPrint());

        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(201);
    }

    @Test
    @FrameworkAnnotations
    public void postRequestUsingExternalFile(Method method){
        String requestAsString =
                ApiUtils.readJsonAndGetAsString(FrameworkConstants.getRequestFolderPath()+ "Request.json")
                        .replace("firstName", RandomUtils.getName())
                        .replace("Jobs", RandomUtils.getJobName());
        Response response = RequestBuilder
                        .buildRequestForPOSTCalls()
                .body(requestAsString)
                .post("/users");

//        response.prettyPrint();
//        ExtentReport.getTest().pass(response.prettyPrint());
        ExtentLogger.logResponse(response.prettyPrint());

        ApiUtils.storeStringAsJsonFile(FrameworkConstants.getResponseFolderPath()+ method.getName() +"Response.json", response);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);

    }

    @Test
    @FrameworkAnnotations
    public void postRequestUsingExternalFileUsingSingletonClass(Method method){
        String requestAsString =
                ApiUtils.readJsonAndGetAsString(FrameworkConstantsSingleton.getInstance().getRequestFolderPath() + "Request.json")
                        .replace("firstName", RandomUtils.getName())
                        .replace("Jobs", RandomUtils.getJobName());
        Response response = RequestBuilder
                .buildRequestForPOSTCalls()
                .body(requestAsString)
                .post("/users");

//        response.prettyPrint();
//        ExtentReport.getTest().pass(response.prettyPrint());
        ExtentLogger.logResponse(response.prettyPrint());

        ApiUtils.storeStringAsJsonFile(FrameworkConstantsSingleton.getInstance().getResponseFolderPath() + method.getName() +"Response.json", response);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);

    }
}
