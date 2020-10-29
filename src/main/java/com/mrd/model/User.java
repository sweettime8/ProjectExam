/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author Admin
 */

@Data
@Document(collection = "user")
public class User {

    @Id
    @Field(value = "id")
    private Long id;
    
    @Indexed(unique = true)
    @Field(value = "username")
    private String username;
    
    @Field(value = "password")
    private String password;
    
    @Field(value = "email")
    private String email;
    
    @Field(value = "role_name")
    private String role_name;
}
