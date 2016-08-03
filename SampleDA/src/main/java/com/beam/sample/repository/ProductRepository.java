package com.beam.sample.repository;

import com.beam.sample.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Efe on 20.07.2016.
 */
public interface ProductRepository extends JpaRepository<Product, String>, ProductRepositoryCustom {
    Product findByNameAndVersionAndCompanyName(String name, String version, String companyName);
    Product findById(String id);
    List <Product> findByCompanyName(String name);
    List<Product> findByCompanyId(String id);

}
