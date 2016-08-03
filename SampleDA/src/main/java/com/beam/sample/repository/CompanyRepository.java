package com.beam.sample.repository;

import com.beam.sample.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Efe on 20.07.2016.
 */
public interface CompanyRepository extends JpaRepository<Company, String> {
    Company findByName(String name);
}
