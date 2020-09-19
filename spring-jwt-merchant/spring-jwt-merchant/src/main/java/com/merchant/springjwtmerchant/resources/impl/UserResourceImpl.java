/**
 * @author Neslihan Bozer - 09.2020
 * Merchant application.
 **/
package com.merchant.springjwtmerchant.resources.impl;

import com.merchant.springjwtmerchant.kafka.configuration.KafkaConfiguration;
import com.merchant.springjwtmerchant.models.Product;
import com.merchant.springjwtmerchant.models.User;
import com.merchant.springjwtmerchant.resources.UserResource;
import com.merchant.springjwtmerchant.services.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
public class UserResourceImpl implements UserResource<User> {

    private static Logger log = LoggerFactory.getLogger(ProductResourceImpl.class);

    @Autowired
    private IUserService<User> userService;

    @Override
    public ResponseEntity<Collection<User>> listAll() {
        log.info("UserResourceImpl - listAll");
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> findById(String name) {
        log.info("UserResourceImpl - findById");
        Optional<User> user = userService.getUserByUsername(name);
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> save(User user) {
        log.info("UserResourceImpl - save");
        return new ResponseEntity<>(userService.saveOrUpdate(user), HttpStatus.CREATED);
    }

}
