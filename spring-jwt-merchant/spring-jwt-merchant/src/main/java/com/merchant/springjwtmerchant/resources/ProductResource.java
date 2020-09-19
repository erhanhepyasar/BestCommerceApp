/**
 * @author Neslihan Bozer - 09.2020
 * Merchant application.
 **/
package com.merchant.springjwtmerchant.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("kafka/products")
public interface ProductResource<T> {

    @Autowired
    static final String TOPIC = "Kafka_Product_Topic";

	@GetMapping
    ResponseEntity<Collection<T>> listAll();

    @GetMapping("/sortByPrice")
    ResponseEntity<Collection<T>> listSortedByPrice();

    @GetMapping("/sortByInventory")
    ResponseEntity<Collection<T>> listSortedByInventory();

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<T> save(@RequestBody T t);

}
