/**
 * @author Neslihan Bozer - 09.2020
 * Merchant application.
 **/
package com.merchant.springjwtmerchant.unittests;

import com.merchant.springjwtmerchant.constants.PaymentOptions;
import com.merchant.springjwtmerchant.constants.ProductCategory;
import com.merchant.springjwtmerchant.models.Product;
import com.merchant.springjwtmerchant.services.IProductService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.dbutils.DbUtils;
import org.h2.tools.RunScript;
import org.hibernate.TransactionException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class ProductServiceControllerTest extends AbstractTest {

    Product product;

    @Autowired
    private IProductService<Product> productService;

    @Autowired
    private MockMvc mockMvc;

    @Override
    @Before
    public void setUp() {

        super.setUp();

        product = new Product();
        product.setId(101L);
        product.setProductCategory(ProductCategory.ELECTRONICS);
        product.setName("Tv");
        product.setUnitPrice(BigDecimal.valueOf(1000.00));
        product.setInventory(5);
        product.setPaymentOptions(PaymentOptions.DIRECT);
        product.setDeliverOptions("X");
    }

    @Test
    public void testCreateProduct() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .post ("http://localhost:8080/products", product)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();

        MockHttpServletResponse response = result.getResponse();
        int status = response.getStatus();
        Assert.assertEquals("response status is wrong", 400, status);
    }

}
