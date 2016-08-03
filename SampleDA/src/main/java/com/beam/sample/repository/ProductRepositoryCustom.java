package com.beam.sample.repository;

import com.beam.sample.domain.Product;

import java.util.List;

/**
 * Created by Efe on 28.07.2016.
 */
public interface ProductRepositoryCustom {

    List<Product> listProductInfo();

    List<Product> findProductsByCertificationType(String type);
}
