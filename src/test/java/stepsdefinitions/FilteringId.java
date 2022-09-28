package stepsdefinitions;

import base.BaseTest;
import data.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.LoginApp;
import pageobjects.PIMPage;

public class FilteringId extends BaseTest {
    public PIMPage page;
    public LoginApp login;
    public String id_employee = "0011";
    public User user;


    @Given("Client see the records of employees, He want filter these records by Id")
    public void client_see_the_records_of_employees_he_want_filter_these_records_by_id() {
        user = new User();
        login = new LoginApp(driver);
        page = login.login(user.username, user.password);
    }

    @When("He search an Id")
    public void he_search_an_id() {
        page.search(id_employee);
    }

    @Then("data has been filtered with this Id")
    public void data_has_been_filtered_with_this_id() {
        Assert.assertTrue(page.getRecord(id_employee));
    }

}