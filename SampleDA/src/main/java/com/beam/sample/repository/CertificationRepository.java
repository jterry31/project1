package com.beam.sample.repository;

import com.beam.sample.domain.Certification;
import com.beam.sample.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.FROM;

/**
 * Created by Efe on 29.07.2016.
 */
public interface CertificationRepository extends JpaRepository<Certification,String> {
    List<Certification> findByType(String type);

}
