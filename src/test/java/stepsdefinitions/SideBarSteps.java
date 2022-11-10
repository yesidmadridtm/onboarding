package stepsdefinitions;

import data.User;
import data.UserBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginApp;

public class SideBarSteps extends BaseTest {
    public pageobjects.SideBarPage page;
    public LoginApp login;
    public String menu = "PIM";

    private void login(){
        User user = UserBuilder.getAdminUser();
        login = new LoginApp(driver);
        page = login.loginSideBar(user.getUsername(), user.getPassword());
    }

    @Given("Client want to filter side bar menu using a name")
    public void clientWantToFilterSideBarMenuUsingAName() {
        login();
    }

    @When("He provides name")
    public void heProvidesName() {
        page.search(menu);

    }

    @Then("side bar is filtered")
    public void sideBarIsFiltered() {
        page.checkResult(menu);
    }
}
