/**
 * @author Neslihan Bozer - 09.2020
 * Merchant application.
 **/
package com.merchant.springjwtmerchant.repository;

import com.merchant.springjwtmerchant.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
