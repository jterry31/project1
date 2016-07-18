package com.efe.tutorial.business;

import com.efe.tutorial.model.Person;
import com.efe.tutorial.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Efe on 18.07.2016.
 */

@Service
public class PersonBusiness {
    @Autowired
    PersonRepository personRepository;

    public Person findByFirstName(String firstName) {return personRepository.findByFirstName(firstName); }
}
