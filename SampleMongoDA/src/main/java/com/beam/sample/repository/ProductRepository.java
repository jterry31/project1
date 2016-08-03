package com.beam.sample.repository;

import com.beam.sample.domain.Application;
import com.beam.sample.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by Efe on 20.07.2016.
 */
public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByNameAndVersionAndCompanyName(String name, String version, String companyName);
    Product findById(String id);
    List<Product> findByCompanyName(String name);

    @Query("{ 'certifications.type' : ?0 }")
    List<Product> findByCertificationType(String type);

}
