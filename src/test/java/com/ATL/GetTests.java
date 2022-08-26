package com.ATL;

import com.ATL.requestBuilder.RequestBuilder;
import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.Test;

public class GetTests {

    @Test
    public void Tco01(){
        Response response = RequestBuilder
                .buildRequestForGETCalls()
                .when()
                .get("/users?page=2");

        response.prettyPrint();

        assertThat(response.getStatusCode())
                .isEqualTo(200);
        assertThat(response.jsonPath().getString("perpage"))
                .isEqualTo(6);
//        assertThat(response.jsonPath().getList("response.data").size())
//                .isEqualTo(3);


    }

    @Test
    public void Tco02(){
        Response response = RequestBuilder
                .buildRequestForGETCalls()
                .pathParam("user", 2)
                .queryParam("pages", 1)
                .when()
                .get("/users/{user}");

        response.prettyPrint();

        assertThat(response.getStatusCode())
                .isEqualTo(200);
//        assertThat(response.jsonPath().getString("perpage"))
//                .isEqualTo(6);
//        assertThat(response.jsonPath().getList("response.data").size())
//                .isEqualTo(3);


    }
}
