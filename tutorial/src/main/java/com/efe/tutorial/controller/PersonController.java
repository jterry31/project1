package com.efe.tutorial.controller;

import com.efe.tutorial.business.PersonBusiness;
import com.efe.tutorial.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Efe on 18.07.2016.
 */

@Controller
@RequestMapping("person")


public class PersonController {

    @Autowired
    PersonBusiness personBusiness;

    @RequestMapping("")
}
