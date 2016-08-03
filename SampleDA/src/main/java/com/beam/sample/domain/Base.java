package com.beam.sample.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * Created by x0r on 18/07/16.
 */

@MappedSuperclass
public class Base {

    @Id
    @Getter
    @Setter
    private String id = UUID.randomUUID().toString();
}
