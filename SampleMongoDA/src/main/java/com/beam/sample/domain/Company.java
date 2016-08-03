package com.beam.sample.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Efe on 19.07.2016.
 */
@Document(collection = "Company")
public class Company extends Base{

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private ContactPerson contactPerson;

}
