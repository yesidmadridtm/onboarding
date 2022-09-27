package stepsDefinitions;

import base.BaseTest;
import base.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.LoginApp;
import pageobjects.PIMPage;

public class FilteringId {
    public PIMPage page;
    public LoginApp login;

    @Given("Client see the records of employees, He want filter these records by Id")
    public void client_see_the_records_of_employees_he_want_filter_these_records_by_id() {
        login = new Hooks().runApp();
        page = login.login("Admin", "admin123");
    }
    @When("He search an Id")
    public void he_search_an_id() {
        page.search("0011");
    }
    @Then("data has been filtered with this Id")
    public void data_has_been_filtered_with_this_id() {
        Assert.assertTrue(page.getRecord("0011"));
        login.close();
    }

}