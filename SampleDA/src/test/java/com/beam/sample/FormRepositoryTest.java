package com.beam.sample;

import com.beam.sample.domain.*;
import com.beam.sample.repository.*;
import lombok.experimental.Accessors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

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
    EntityManager em;

    @Autowired
    private ApplicationFormRepository applicationFormRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IntroductionFormRepository introductionFormRepository;

    @Autowired
    private ContactPersonRepository contactPersonRepository;

    @Autowired
    private CertificationRepository certificationRepository;

    @Test
    public void test1_AddCompany() {
        ContactPerson contactPerson = new ContactPerson();
        Company company = new Company();
        Product product1 = new Product();
        Product product2 = new Product();
        List<Product> products = new ArrayList<Product>();
        List<Certification> certifications1 = new ArrayList<Certification>();
        List<Certification> certifications2 = new ArrayList<Certification>();

        Certification certification0 = new Certification();
        certification0.setType("C1");
        certification0.setStatus("Pending");
        certification0.setProduct(product1);

        Certification certification1 = new Certification();
        certification1.setType("C2");
        certification1.setStatus("Pending");
        certification1.setProduct(product1);

        Certification certification2 = new Certification();
        certification2.setType("C2");
        certification2.setStatus("Pending");
        certification2.setProduct(product2);

        Certification certification3 = new Certification();
        certification3.setType("C3");
        certification3.setStatus("Pending");
        certification3.setProduct(product2);

        certifications1.add(certification0);
        certifications1.add(certification1);
        certifications2.add(certification2);
        certifications2.add(certification3);

        product1.setCompany(company);
        product1.setCompanyName("Beam Teknoloji");
        product1.setName("Product216");
        product1.setVersion("1.1.2");
        product1.setCertifications(certifications1);

        product2.setCompany(company);
        product2.setCompanyName("Beam Teknoloji");
        product2.setName("Product318");
        product2.setVersion("2.1.8");
        product2.setCertifications(certifications2);

        products.add(product1);
        products.add(product2);

        contactPerson.setEmail("hilal@gmail.com");
        contactPerson.setFaxNumber("irrelevant");
        contactPerson.setFirstName("Hilal");
        contactPerson.setLastName("Sahin");
        contactPerson.setPhoneNumber("----------");
        contactPerson.setCompany(company);

        company.setName("Beam Teknoloji");
        company.setAddress("ODTU Teknokent Galyum Blok");
        company.setContactPerson(contactPerson);
        company.setProducts(products);

        companyRepository.save(company);

    }

    @Test
    public void test2_listProductInfo() {
        List<Product> productInfo = productRepository.listProductInfo();
        assertEquals(4, productInfo.size());
    }

    @Test
    public void test3_returnProduct() {
        String id = "40295ed3-1ad1-47d5-b906-d0fd581de0f5";
        Product product = productRepository.findById(id);
        Company company = product.getCompany();
        List<Certification> certifications = product.getCertifications();
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
        List<Product> products = productRepository.findProductsByCertificationType(type);
        assertEquals(4, products.size());

    }

    @Test
    public void test6_findCompanyProducts_fromContactPerson() {
        String id = "0e013c97-8b2b-45e4-a8f6-165f6dee02fe";
        ContactPerson contact = contactPersonRepository.findById(id);
        String company_id = contact.getCompany().getId();
        List <Product> companyProducts = productRepository.findByCompanyId(company_id);
        assertEquals(2,companyProducts.size());
    }

    @Test
    public void testAddApplicationForm() {
/*
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setEmail("can@gmail.com");
        contactPerson.setFaxNumber("irrelevant");
        contactPerson.setFirstName("Hilal");
        contactPerson.setLastName("Sahin");
        contactPerson.setPhoneNumber("----------");

        Company company = new Company();
        company.setAddress("Teknokent, Cankaya/Ankara");
        company.setName("Efe Ltd Sti");
        company.setContactPerson(contactPerson);

        Certification certification = new Certification();
        certification.setStatus("Pending");
        certification.setType("EAL4+xxx");

        Certification certification2 = new Certification();
        certification2.setStatus("Pending");
        certification2.setType("APE");

        ArrayList<Certification> certifications = new ArrayList<>();
        certifications.add(certification);
        certifications.add(certification2);

        Product product = new Product();
        //product.setCompanyName("Efe Ltd Sti");
        product.setName("Example product");
        product.setVersion("1.2.8");
        product.setCertifications(certifications);

        ArrayList<ArrayList<String>> evidences = new ArrayList<>();
        ArrayList<String> technicalInfo = new ArrayList<>();
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
        //application.setCompany(company);
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
        applicationFormRepository.save(application);

        // assuming the full names of the companies are unique;
        Company company2 = null;
        company2 = companyRepository.findByName(company.getName());
        if (company2 == null) companyRepository.save(company);
        else {
            companyRepository.delete(company2.getId());
            companyRepository.save(company);
        }
        productRepository.save(product);*/
    }


}

