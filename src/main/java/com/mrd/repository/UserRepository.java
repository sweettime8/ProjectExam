/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.repository;

import com.mrd.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Admin
 */
public interface UserRepository extends MongoRepository<User, Long>{
   User findByUsername(String username);
}
