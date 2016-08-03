package com.beam.sample.repository;

import com.beam.sample.domain.Application;
import com.beam.sample.domain.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by Efe on 20.07.2016.
 */
public interface CompanyRepository extends MongoRepository<Company, String> {
    Company findByName(String name);

    @Query("{ 'contactPerson._id' : ?0 }")
    Company findByContactPersonID(String id);
}
