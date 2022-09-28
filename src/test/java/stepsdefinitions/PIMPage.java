package stepsdefinitions;

import base.BaseTest;
import data.Director;
import data.User;
import data.UserBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.LoginApp;

public class PIMPage extends BaseTest {
    public pageobjects.PIMPage page;
    public LoginApp login;
    public String id_employee = "0024";


    @Given("Client see the records of employees, He want filter these records by Id")
    public void client_see_the_records_of_employees_he_want_filter_these_records_by_id() {
        Director director = new Director();
        UserBuilder builder = new UserBuilder();
        director.constructUser(builder);
        User user = builder.getResult();
        login = new LoginApp(driver);
        page = login.login(user.getUsername(), user.getPassword());
    }

    @When("He search an Id")
    public void he_search_an_id() {
        page.search(id_employee);
    }

    @Then("data has been filtered with this Id")
    public void data_has_been_filtered_with_this_id() {
        Assert.assertTrue(page.getRecord(id_employee));
    }

    @Given("Client see the records of employees, He want filter these records by Employment Status")
    public void client_see_the_records_of_employees_he_want_filter_these_records_by_employment_status() {
        Director director = new Director();
        UserBuilder builder = new UserBuilder();
        director.constructUser(builder);
        User user = builder.getResult();
        login = new LoginApp(driver);
        page = login.login(user.getUsername(), user.getPassword());
    }

    @When("He search an employee using an Employment Status")
    public void he_search_an_employee_using_an_employment_status() {
        page.searchByEmpStatus();
    }

    @Then("data has been filtered with this Employment Status")
    public void data_has_been_filtered_with_employment_status() {
        Assert.assertTrue(page.getRecordByFilter2());
    }

}