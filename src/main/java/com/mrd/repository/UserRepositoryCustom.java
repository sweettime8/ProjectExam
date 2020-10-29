/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.repository;

import com.mrd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public class UserRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    //tự tăng id
    public long getMaxUserId() {
        Query query = new Query();
       // query.with(new Sort(Sort.Direction.DESC,"id"));
        query.limit(1);
        User user = mongoTemplate.findOne(query, User.class);
        if (user == null) {
            return 0L;
        }
        return user.getId();
    }


}
