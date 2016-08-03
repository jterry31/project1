package com.beam.sample.repository;

import com.beam.sample.domain.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by x0r on 18/07/16.
 */
public interface ApplicationFormRepository extends MongoRepository<Application, String> {
}
