package com.ATL;

import com.ATL.constants.FrameworkConstants;
import com.ATL.constants.FrameworkConstantsSingleton;
import com.ATL.extentReports.ExtentLogger;
import com.ATL.extentReports.ExtentManager;
import com.ATL.extentReports.ExtentReport;
import com.ATL.requestBuilder.RequestBuilder;
import com.ATL.utils.ApiUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class GetTests{

    @Test
    public void Tco01(Method method){
        Response response = RequestBuilder
                .buildRequestForGETCalls()
                .when()
                .get("/users?page=2");

//        response.prettyPrint();

//        ExtentReport.getTest().pass(response.prettyPrint());
//        ExtentManager.getTest().pass(MarkupHelper.createCodeBlock(response.prettyPrint(), CodeLanguage.JSON));
        ExtentLogger.logResponse(response.prettyPrint());

        assertThat(response.getStatusCode())
                .isEqualTo(200);
        assertThat(response.jsonPath().getString("per_page"))
                .isEqualTo("6");
//        assertThat(response.jsonPath().getList("response.data").size())
//                .isEqualTo(3);

        ApiUtils.storeStringAsJsonFile(FrameworkConstantsSingleton.getInstance().getResponseFolderPath()+method.getName()+"response.json", response);
    }

    @Test
    public void Tco02(Method method){
        Response response = RequestBuilder
                .buildRequestForGETCalls()
                .pathParam("user", 2)
                .queryParam("pages", 1)
                .when()
                .get("/users/{user}");

//        response.prettyPrint();
//        ExtentReport.getTest().pass(response.prettyPrint());
//        ExtentManager.getTest().pass(MarkupHelper.createCodeBlock(response.prettyPrint(), CodeLanguage.JSON));
        ExtentLogger.logResponse(response.prettyPrint());

        assertThat(response.getStatusCode())
                .isEqualTo(201);
//        assertThat(response.jsonPath().getString("perpage"))
//                .isEqualTo(6);
//        assertThat(response.jsonPath().getList("response.data").size())
//                .isEqualTo(3);

ApiUtils.storeStringAsJsonFile(FrameworkConstantsSingleton.getInstance().getResponseFolderPath()+method.getName()+"response.json", response);
    }
}
