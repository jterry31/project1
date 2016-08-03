package com.beam.sample.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by x0r on 18/07/16.
 */
@Document(collection = "Introduction")
@Accessors(chain = true)
public class Introduction extends Base {

    @Getter
    @Setter
    private ContactPerson contactPerson;

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
