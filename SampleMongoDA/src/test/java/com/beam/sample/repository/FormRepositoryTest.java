package com.beam.sample.repository;

import com.beam.sample.domain.*;
import lombok.experimental.Accessors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by x0r on 18/07/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Accessors(chain = true)
public class FormRepositoryTest {

    @Autowired
    private ApplicationFormRepository applicationFormRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IntroductionFormRepository introductionFormRepository;


    @Test
    public void testAddApplicationForm() {

        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setEmail("hilal@gmail.com");
        contactPerson.setFaxNumber("irrelevant");
        contactPerson.setFirstName("Hilal");
        contactPerson.setLastName("Sahin");
        contactPerson.setPhoneNumber("----------");

        Company company = new Company();
        company.setAddress("Teknokent, Cankaya/Ankara");
        company.setName("Beam Teknoloji");
        company.setContactPerson(contactPerson);

        Certification certification = new Certification();
        certification.setStatus("Pending");
        certification.setType("C1");

        Certification certification2 = new Certification();
        certification2.setStatus("Pending");
        certification2.setType("C2");

        Certification certification3 = new Certification();
        certification3.setStatus("Pending");
        certification3.setType("C2");

        Certification certification4 = new Certification();
        certification4.setStatus("Pending");
        certification4.setType("C3");

        ArrayList<Certification> certifications1 = new ArrayList<>();
        certifications1.add(certification);
        certifications1.add(certification2);

        ArrayList<Certification> certifications2 = new ArrayList<>();
        certifications2.add(certification3);
        certifications2.add(certification4);

        Product product = new Product();
        product.setCompanyName("Beam Teknoloji");
        product.setName("BEAM_318");
        product.setVersion("2.0");
        product.setCertifications(certifications1);

        Product product2 = new Product();
        product2.setCompanyName("Beam Teknoloji");
        product2.setName("BEAM_216");
        product2.setVersion("3.1");
        product2.setCertifications(certifications2);

        ArrayList <ArrayList<String>> evidences = new ArrayList<>();
        ArrayList <String> technicalInfo = new ArrayList<>();
        ArrayList<String> evidence1 = new ArrayList<>(2);
        ArrayList<String> evidence2 = new ArrayList<>(2);

        evidence1.add("kanit1");
        evidence1.add("explanation1");
        evidence2.add("kanit2");
        evidence2.add("explanation2");
        evidences.add(evidence1);
        evidences.add(evidence2);

        technicalInfo.add("info1");
        technicalInfo.add("info2");

        Application application = new Application();
        application.setCompany(company);
        application.setApplyDate("19.07.2016");
        application.setBillingAddress("--------");
        application.setTaxNumber("++++++++");
        application.setTaxOffice("xxxxxxxxx");
        application.setProduct(product);
        application.setCreatedDate("20.07.2016");
        application.setApprovedBy("Efe Erdil");
        application.setEvaluationEvidences(evidences);
        application.setTechnicalInfo(technicalInfo);
        application.setProjectCode("3245235");
        //applicationFormRepository.save(application);

        // assuming the full names of the companies are unique;
        Company company2 = null;
        company2 = companyRepository.findByName(company.getName());
        if(company2 == null) companyRepository.save(company);
        else {
            companyRepository.delete(company2.getId());
            companyRepository.save(company);
        }
        productRepository.save(product);
        productRepository.save(product2);
    }

    @Test
    public void testAddIntroductionForm() {

        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setEmail("hilal@gmail.com");
        contactPerson.setFaxNumber("irrelevant");
        contactPerson.setFirstName("Hilal");
        contactPerson.setLastName("Sahin");
        contactPerson.setPhoneNumber("----------");
        ArrayList<String> answers = new ArrayList<>();
        answers.add("answer 1");
        answers.add("answer 2");
        answers.add("answer 3");
        answers.add("answer 4");
        answers.add("answer 5");
        Introduction introduction = new Introduction();
        introduction.setContactPerson(contactPerson);
        introduction.setCompanyName("BEAM");
        introduction.setProductName("Example product");
        introduction.setProductVersion("1.2.8");
        introduction.setEvaluationAnswers(answers);
        introductionFormRepository.save(introduction);
        Product product2 = productRepository.findByNameAndVersionAndCompanyName(introduction.getProductName()
                ,introduction.getProductVersion()
                ,introduction.getCompanyName());
        product2.setHasTOEdoc(true);
        productRepository.delete(product2.getId());
        productRepository.save(product2);
    }

    @Test
    public void test2_listProductInfo() {
        List<Product> productInfo = productRepository.findAll();
        assertEquals(2, productInfo.size());
    }

    @Test
    public void test3_returnProduct() {
        String id = "0c86f512-650f-4c9b-bd56-bfdd5fa10b82";
        Product product = productRepository.findById(id);
        assertNotNull(product);
    }

    @Test
    public void test4_listCompanyProducts() {
        String companyName = "Beam Teknoloji";
        List<Product> companyProducts = productRepository.findByCompanyName(companyName);
        assertEquals(2, companyProducts.size());
    }

    @Test
    public void test5_listProducts_withCertificationType() {
        String type = "C2";
        List<Product> products = productRepository.findByCertificationType(type);
        assertEquals(2, products.size());

    }

    @Test
    public void test6_findCompanyProducts_fromContactPerson() {
        String id = "081c43e6-84af-45a5-9699-2936086eced8";
        Company company = companyRepository.findByContactPersonID(id);
        List <Product> companyProducts = productRepository.findByCompanyName(company.getName());
        assertEquals(2,companyProducts.size());
    }
}
