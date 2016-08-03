package com.beam.sample.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;


/**
 * Created by x0r on 18/07/16.
 */


public class Base {

    @Id
    @Getter
    @Setter
    private String id = UUID.randomUUID().toString();

}
