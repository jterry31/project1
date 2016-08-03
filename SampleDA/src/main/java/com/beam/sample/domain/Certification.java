package com.beam.sample.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Created by Efe on 19.07.2016.
 */

@Entity
public class Certification extends Base{

    @ManyToOne
    @Getter
    @Setter
    private Product product;

    @Getter
    @Setter
    private String type;

    @Getter
    @Setter
    private String status;
}
