package com.spartdark.first_real_thymeleaf_application.model;

import lombok.Data;

/**
 * @author vladimirsaldivar
 * @project first_real_thymeleaf_application 2018
 * ...:::vsaldivarm@gmail.com:::...
 **/
@Data
public class UserCredential {


    private String userName;
    private String password;

    public UserCredential() {

    }
}
