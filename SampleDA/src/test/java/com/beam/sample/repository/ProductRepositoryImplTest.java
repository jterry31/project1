package com.beam.sample.repository;

import com.beam.sample.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Efe on 28.07.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryImplTest {

    @Autowired
    ProductRepository productRepository;
/*
    @Test
    public void testListProduct() {

        List<Product> productList = productRepository.listProductInfo();

        assertEquals(0, productList.size());
    }
    */

}
