package com.ATL.pojos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "set")
public class Users {

    private String name;
    private String job;
}


/**
 * Sample request body
 * {
 *     "name": "morpheus",
 *     "job": "leader"
 * }
 */