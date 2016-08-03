package com.beam.sample.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Efe on 19.07.2016.
 */

@Entity
@Accessors(chain = true)
public class Product extends Base {

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Application application;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Introduction introduction;

    @Getter
    @Setter
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Certification> certifications;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String version;

    @Getter
    @Setter
    private String companyName;

    @Getter
    @Setter
    private boolean hasPP = false;

    @Getter
    @Setter
    private boolean hasST = false;

    @Getter
    @Setter
    private boolean hasTOEdoc = false;

    @Getter
    @Setter
    private boolean hasConfAgrmnt = false;
}
