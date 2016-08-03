package com.beam.sample.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;


/**
 * Created by x0r on 18/07/16.
 */
@Entity(name = "Application")
@Accessors(chain = true)
public class Application extends Base {

    @Getter
    @Setter
    @OneToOne
    private Product product;

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
