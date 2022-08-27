package com.ATL.annotations;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;


@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, TYPE})
public @interface FrameworkAnnotations {

    String[] Author() default "Unknown Author";
    String[] Category() default "Unknown Category";

}
