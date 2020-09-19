/**
 * @author Neslihan Bozer - 09.2020
 * Merchant application.
 **/
package com.merchant.springjwtmerchant.unittests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceControllerTest extends AbstractTest{

    @Autowired
    private MockMvc mockMvc;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .get("http://localhost:8080/hello");

        int status = mockMvc.perform(request).andReturn().getResponse().getStatus();
        Assert.assertEquals( 403, status);
    }

    @Test
    public void authenticate() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .post("http://localhost:8080/authenticate")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();

        int status = result.getResponse().getStatus();

        Assert.assertEquals("response status is wrong", 400, status);

    }
}
