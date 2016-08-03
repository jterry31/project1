package com.beam.sample.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Vector;


/**
 * Created by x0r on 18/07/16.
 */
@Document(collection = "Application")
@Accessors(chain = true)
public class Application extends Base{

    @Getter
    @Setter
    private Company company;

    @Getter
    @Setter
    private String applyDate;

    @Getter
    @Setter
    private String taxOffice;

    @Getter
    @Setter
    private String taxNumber;

    @Getter
    @Setter
    private String billingAddress;

    @Getter
    @Setter
    private Product product;

    @Getter
    @Setter
    private ArrayList<ArrayList<String>> evaluationEvidences = new ArrayList<>();

    @Getter
    @Setter
    private ArrayList<String> technicalInfo = new ArrayList<>();

    @Getter
    @Setter
    private String approvedBy;

    @Getter
    @Setter
    private String projectCode;

    @Getter
    @Setter
    private String createdDate;
}
