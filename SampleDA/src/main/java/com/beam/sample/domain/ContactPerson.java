package com.beam.sample.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Efe on 19.07.2016.
 */

@Entity
public class ContactPerson extends Base{


    @Getter
    @Setter
    @OneToOne
    private Company company;

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
