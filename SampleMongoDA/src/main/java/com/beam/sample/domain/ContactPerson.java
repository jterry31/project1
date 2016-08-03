package com.beam.sample.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Efe on 19.07.2016.
 */
public class ContactPerson extends Base {

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String phoneNumber;

    @Getter
    @Setter
    private String faxNumber;

    @Getter
    @Setter
    private String email;

}
