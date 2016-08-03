package com.beam.sample.repository;

import com.beam.sample.domain.Product;
import com.beam.sample.repository.ProductRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Efe on 28.07.2016.
 */
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @Autowired
    private EntityManager em;

    @Override
    public List<Product> listProductInfo() {

        TypedQuery<Product> query =
                em.createQuery("SELECT c FROM Product c", Product.class);

        return query.getResultList();
    }


    public List<Product> findProductsByCertificationType(String type){
        return em.createQuery("SELECT p FROM Certification c JOIN c.product p WHERE c.type = ?1 ",Product.class)
                .setParameter(1,type)
                .getResultList();
    }

}
