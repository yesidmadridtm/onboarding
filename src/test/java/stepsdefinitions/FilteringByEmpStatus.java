package stepsdefinitions;

import base.BaseTest;
import data.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.LoginApp;
import pageobjects.PIMPage;

public class FilteringByEmpStatus extends BaseTest  {
    public PIMPage page;
    public LoginApp login;
    public String employment_status = "Full-Time Contract";
    public User user;


    @Given("Client see the records of employees, He want filter these records by Employment Status")
    public void client_see_the_records_of_employees_he_want_filter_these_records_by_employment_status() {
        user = new User();
        login = new LoginApp(driver);
        page = login.login(user.username, user.password);
    }

    @When("He search an employee using an Employment Status")
    public void he_search_an_employee_using_an_employment_status() throws InterruptedException {
        page.searchByEmpStatus(employment_status);
    }

    @Then("data has been filtered with this Employment Status")
    public void data_has_been_filtered_with_employment_status() {
        Assert.assertTrue(page.getRecordByFilter2());
    }
}
