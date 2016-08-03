package com.beam.sample.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by x0r on 18/07/16.
 */
@Entity
@Accessors(chain = true)
public class Company extends Base {

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ContactPerson contactPerson;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "company")
    private List<Product> products;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String address;

}
