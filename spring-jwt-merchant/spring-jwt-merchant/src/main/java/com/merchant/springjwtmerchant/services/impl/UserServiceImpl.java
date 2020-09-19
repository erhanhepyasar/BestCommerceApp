/**
 * @author Neslihan Bozer - 09.2020
 * Merchant application.
 **/
package com.merchant.springjwtmerchant.services.impl;

import com.merchant.springjwtmerchant.models.User;
import com.merchant.springjwtmerchant.services.IUserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService<User> {

    @Override
    public Collection<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> getUserByUsername(String userName) {
        return Optional.empty();
    }
    
    @Override
    public User saveOrUpdate(User user) {
        return null;
    }

}
