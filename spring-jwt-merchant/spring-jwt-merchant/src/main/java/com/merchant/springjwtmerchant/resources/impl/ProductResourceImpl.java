/**
 * @author Neslihan Bozer - 09.2020
 * Merchant application.
 **/
package com.merchant.springjwtmerchant.resources.impl;

import com.merchant.springjwtmerchant.kafka.configuration.KafkaConfiguration;
import com.merchant.springjwtmerchant.models.Product;
import com.merchant.springjwtmerchant.resources.ProductResource;
import com.merchant.springjwtmerchant.services.IProductService;
import org.apache.commons.dbutils.DbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ProductResourceImpl implements ProductResource<Product> {

	private static Logger log = LoggerFactory.getLogger(ProductResourceImpl.class);

	@Autowired
	KafkaTemplate kafkaTemplate = KafkaConfiguration.getKafkaTemplateString();

	@Autowired
	private IProductService<Product> productService;

	@Override
	@KafkaListener(topics = TOPIC, groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
	public ResponseEntity<Collection<Product>> listAll() {
		log.info("ProductResourceImpl - listAll");
		return new ResponseEntity<>(productService.listAll(), HttpStatus.OK);
	}

	@Override
	@KafkaListener(topics = TOPIC, groupId = "group_id")
	public ResponseEntity<Collection<Product>> listSortedByPrice() {
		log.info("ProductResourceImpl - listSortedByPrice");
		return new ResponseEntity<>(productService.listSortedByPrice(), HttpStatus.OK);
	}

	@Override
	@KafkaListener(topics = TOPIC, groupId = "group_id")
	public ResponseEntity<Collection<Product>> listSortedByInventory() {
		log.info("ProductResourceImpl - listSortedByInventory");
		return new ResponseEntity<>(productService.listSortedByInventory(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Product> save(Product product) {
		log.info("ProductResourceImpl - save");
		kafkaTemplate.send(TOPIC, product);
		return new ResponseEntity<>(productService.saveOrUpdate(product), HttpStatus.CREATED);
	}

}
