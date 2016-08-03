package com.beam.sample.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.ArrayList;

/**
 * Created by x0r on 18/07/16.
 */

@Entity
@Accessors(chain = true)
public class Introduction extends Base {

    @Getter
    @Setter
    @OneToOne
    private Product product;

    @Getter
    @Setter
    private String companyName;

    @Getter
    @Setter
    private String productName;

    @Getter
    @Setter
    private String productVersion;

    //assuming the general evaluation questions are known and stored as some document and answers to these
    //questions will be fetched from front-end as strings:
    @Getter
    @Setter
    private ArrayList<String> evaluationAnswers;
}
