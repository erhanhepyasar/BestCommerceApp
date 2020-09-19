/**
 * @author Neslihan Bozer - 09.2020
 * Merchant application.
 **/
package com.merchant.springjwtmerchant.services;

import java.util.Collection;
import java.util.Optional;

public interface IUserService<T> {

	Collection<T> getAll();

	Optional<T> getUserByUsername(String userName);

	T saveOrUpdate(T t);
}
