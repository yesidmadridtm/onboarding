package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.PIMPage;

public class PimFilterIdTest extends BaseTest {

    @Test
    public void filterId(){
        PIMPage page = login.login("Admin", "admin123");
        page.search("0011");
        Assert.assertTrue(page.getRecord("0011"));

    }
}
