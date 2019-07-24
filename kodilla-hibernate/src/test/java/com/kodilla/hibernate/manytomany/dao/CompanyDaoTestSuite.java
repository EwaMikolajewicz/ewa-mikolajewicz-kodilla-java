package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testNamedNativeQueryInCompanies() {
        //Given
        Employee adamNowak = new Employee("Adam", "Nowak");
        Employee zuzannaNowak = new Employee("Zuzanna", "Nowak");
        Employee wojciechBaranek = new Employee("Wojciech", "Baranek");

        Company aaaCompany = new Company("ABCD Company");
        Company bbbCompany = new Company("ABCROBOT Company");
        Company cccCompany = new Company("BBBBBB Company");

        aaaCompany.getEmployees().add(adamNowak);
        bbbCompany.getEmployees().add(zuzannaNowak);
        bbbCompany.getEmployees().add(wojciechBaranek);
        cccCompany.getEmployees().add(wojciechBaranek);
        cccCompany.getEmployees().add(adamNowak);

        adamNowak.getCompanies().add(aaaCompany);
        adamNowak.getCompanies().add(cccCompany);
        zuzannaNowak.getCompanies().add(bbbCompany);
        wojciechBaranek.getCompanies().add(bbbCompany);
        wojciechBaranek.getCompanies().add(cccCompany);

        companyDao.save(aaaCompany);
        int aaaCompanyId = aaaCompany.getId();
        companyDao.save(bbbCompany);
        int bbbCompanyId = bbbCompany.getId();
        companyDao.save(cccCompany);
        int cccCompanyId = cccCompany.getId();

        //When
        List<Company> companiesNames = companyDao.retrieveThreeFirstSignsOfCompanyName("ABC");

        //Then

        Assert.assertEquals(2, companiesNames.size());
        Assert.assertEquals(aaaCompany.getName(), companiesNames.get(0).getName());
        Assert.assertEquals("ABCD Company", companiesNames.get(0).getName());

        //CleanUp
        try {
            companyDao.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testNamedQueriesInEmployees() {
        //Given
        Employee adamNowak = new Employee("Adam", "Nowak");
        Employee zuzannaNowakowska = new Employee("Zuzanna", "Nowakowska");
        Employee wojciechBaranek = new Employee("Wojciech", "Baranek");

        Company aaaCompany = new Company("AAA Company");
        Company bbbCompany = new Company("BBB Company");
        Company cccCompany = new Company("CCC Company");

        aaaCompany.getEmployees().add(adamNowak);
        bbbCompany.getEmployees().add(zuzannaNowakowska);
        bbbCompany.getEmployees().add(wojciechBaranek);
        cccCompany.getEmployees().add(wojciechBaranek);
        cccCompany.getEmployees().add(adamNowak);

        adamNowak.getCompanies().add(aaaCompany);
        adamNowak.getCompanies().add(cccCompany);
        zuzannaNowakowska.getCompanies().add(bbbCompany);
        wojciechBaranek.getCompanies().add(bbbCompany);
        wojciechBaranek.getCompanies().add(cccCompany);

        companyDao.save(aaaCompany);
        int aaaCompanyId = aaaCompany.getId();
        companyDao.save(bbbCompany);
        int bbbCompanyId = bbbCompany.getId();
        companyDao.save(cccCompany);
        int cccCompanyId = cccCompany.getId();

        //When
        List<Employee> employeesNames = employeeDao.retrieveEmployeeLastNameEquals("Nowak");

        //Then
        Assert.assertEquals(1, employeesNames.size());
        Assert.assertEquals(adamNowak.getLastname(), employeesNames.get(0).getLastname());
        Assert.assertEquals("Adam", employeesNames.get(0).getFirstname());

        //CleanUp
        try {
            companyDao.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }
}
