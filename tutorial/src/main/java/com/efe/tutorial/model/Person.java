package com.efe.tutorial.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Efe on 18.07.2016.
 */

@Accessors(chain = true)
@Document(collection = "Person")
@TypeAlias("person")

public class Person extends BaseModel{

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private Address address;

}
