/**
 * @author Neslihan Bozer - 09.2020
 * Merchant application.
 **/
package com.merchant.springjwtmerchant.services;

import java.util.Collection;

public interface IProductService<T> {

	Collection<T> listAll();

	Collection<T> listSortedByPrice();

	Collection<T> listSortedByInventory();

	T saveOrUpdate(T t);

}
