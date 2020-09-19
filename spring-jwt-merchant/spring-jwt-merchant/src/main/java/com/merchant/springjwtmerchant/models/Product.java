/**
 * @author Neslihan Bozer - 09.2020
 * Merchant application.
 **/
package com.merchant.springjwtmerchant.models;

import com.merchant.springjwtmerchant.constants.PaymentOptions;
import com.merchant.springjwtmerchant.constants.ProductCategory;
import com.sun.istack.internal.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    ProductCategory productCategory;

    @NotNull
    String name;

    @NotNull
    String description;

    @NotNull
    BigDecimal unitPrice;

    @NotNull
    Integer inventory;

    @NotNull
    PaymentOptions paymentOptions;

    @NotNull
    String deliverOptions;

    public Long getId() {
        return id;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public PaymentOptions getPaymentOptions() {
        return paymentOptions;
    }

    public String getDeliverOptions() {
        return deliverOptions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public void setPaymentOptions(PaymentOptions paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public void setDeliverOptions(String deliverOptions) {
        this.deliverOptions = deliverOptions;
    }
}
