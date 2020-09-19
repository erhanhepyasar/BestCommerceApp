/**
 * @author Neslihan Bozer - 09.2020
 * Merchant application.
 **/
package com.merchant.springjwtmerchant.services.impl;

import com.merchant.springjwtmerchant.repository.ProductRepository;
import com.merchant.springjwtmerchant.services.IProductService;
import com.merchant.springjwtmerchant.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService<Product> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Collection<Product> listAll() {
        return productRepository.findAll().stream().filter(p -> p.getInventory() > 5).collect(Collectors.toList());
    }

    @Override
    public Collection<Product> listSortedByPrice() {
        return productRepository.findAll().stream().filter(p -> p.getInventory() > 5).sorted(Comparator.comparing(Product::getUnitPrice)).collect(Collectors.toList());
    }

    @Override
    public Collection<Product> listSortedByInventory() {
        return productRepository.findAll().stream().filter(p -> p.getInventory() > 5).sorted(Comparator.comparing(Product::getInventory)).collect(Collectors.toList());
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return productRepository.saveAndFlush(product);
    }

}
