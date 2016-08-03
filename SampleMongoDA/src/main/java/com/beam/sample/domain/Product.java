package com.beam.sample.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

/**
 * Created by Efe on 19.07.2016.
 */
@Document(collection = "Product")
public class Product extends Base{

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
    private ArrayList<Certification> certifications = new ArrayList<>();
}
