package com.efe.tutorial.repository;

import com.efe.tutorial.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Efe on 18.07.2016.
 */
public interface PersonRepository extends MongoRepository<Person,String> {
    public Person findByFirstName(String firstName);

}
