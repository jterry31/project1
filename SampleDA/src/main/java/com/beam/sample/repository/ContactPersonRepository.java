package com.beam.sample.repository;

import com.beam.sample.domain.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Efe on 26.07.2016.
 */
public interface ContactPersonRepository extends JpaRepository<ContactPerson, String> {
    ContactPerson findById(String id);
}
