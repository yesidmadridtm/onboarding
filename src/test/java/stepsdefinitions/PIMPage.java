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

    private void login(){
        Director director = new Director();
        UserBuilder builder = new UserBuilder();
        director.constructUser(builder);
        User user = builder.getResult();
        login = new LoginApp(driver);
        page = login.login(user.getUsername(), user.getPassword());
    }


    @Given("Client see the records of employees, He want filter these records by Id")
    public void clientSeeTheRecordsOfEmployeesHeWantFilterTheseRecordsById() {
        login();
    }

    @When("He search an Id")
    public void heSearchAnId() {
        page.search(id_employee);
    }

    @Then("data has been filtered with this Id")
    public void dataHasBeenFilteredWithThisId() {
        Assert.assertTrue(page.getRecord(id_employee));
    }

    @Given("Client see the records of employees, He want filter these records by Employment Status")
    public void clientSeeTheRecordsOfEmployeesHeWantFilterTheseRecordsByEmploymentStatus() {
        login();
    }

    @When("He search an employee using an Employment Status")
    public void heSearchAnEmployeeUsingAnEmploymentStatus() {
        page.searchByEmpStatus();
    }

    @Then("data has been filtered with this Employment Status")
    public void dataHasBeenFilteredWithEmploymentStatus() {
        Assert.assertTrue(page.getRecordByFilter2());
    }

    @Given("Client see the records of employees, He want filter these records by Include")
    public void clientSeeTheRecordsOfEmployeesHeWantFilterTheseRecordsByInclude() {
        login();
    }

    @When("He search an employee using an Include")
    public void heSearchAnEmployeeUsingAnInclude() {
        page.searchByInclude();
    }

    @Then("data has been filtered with this Include")
    public void dataHasBeenFilteredWithThisInclude()  {
        Assert.assertTrue(page.getRecordByFilter2());
    }

    @Given("Client see the records of employees, He want filter these records by Job Title")
    public void clientSeeTheRecordsOfEmployeesHeWantFilterTheseRecordsByJobTitle() {
        login();
    }

    @When("He search an employee using an Job Title")
    public void heSearchAnEmployeeUsingAnJobTitle() {
        page.searchByJobTitle();
    }

    @Then("data has been filtered with this Job Title")
    public void dataHasBeenFilteredWithThisJobTitle() {
        Assert.assertTrue(page.getRecordByFilter2());
    }

    @Given("Client see the records of employees, He want filter these records by Sub Unit")
    public void clientSeeTheRecordsOfEmployeesHeWantFilterTheseRecordsBySubUnit() {
        login();
    }

    @When("He search an employee using an Sub Unit")
    public void heSearchAnEmployeeUsingAnSubUnit() {
        page.searchBySubUnit();
    }

    @Then("data has been filtered with this Sub Unit")
    public void dataHasBeenFilteredWithThisSubUnit() {
        Assert.assertTrue(page.getRecordByFilter2());
    }
}

