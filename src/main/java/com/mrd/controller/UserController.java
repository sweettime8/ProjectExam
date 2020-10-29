/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.controller;

import com.mrd.model.User;
import com.mrd.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/user/{username}", method = RequestMethod.GET)
    public ResponseEntity<User> getByUsername(@PathVariable("username") String username) {
        LOGGER.info("username[{}]", username);
        for(int i =0;i<1000;i++)
            LOGGER.error("test loi");
        User user = userRepository.findByUsername(username);
        try {
            int a = 5/0;
        }catch(Exception ex) {
            LOGGER.error(ex.toString());
        }
        if (user == null) {
            LOGGER.info("user is not exist");
            return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
//    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
//        LOGGER.info("id[{}]", id);
//        User user = null;
//
//        if (user == null) {
//            LOGGER.info("user is not exist");
//            return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
//        }
//            
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }

}
