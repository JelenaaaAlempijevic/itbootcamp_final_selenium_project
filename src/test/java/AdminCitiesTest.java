import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CitiesPage;

public class AdminCitiesTest extends BaseTest{

    @Test(priority = 1)
    @Description("TC1 - Visits the admin cities page and list cities")
    public void visitsTheAdminCitiesPageAndListCities(){
        navPage.getLoginButton().click();
        loginPage.getEmailField().sendKeys("admin@admin.com");
        loginPage.getPasswordField().sendKeys("12345");
        loginPage.getLoginField().click();
        wait.until(ExpectedConditions.urlContains("/home"));
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/admin/cities",
                "The page url does not contain '/admin/cities'.");
    }

    @Test(priority = 2)
    @Description("TC2 - Checks input types for create/edit new city")
    public void checksInputTypesForCreateOrEditNewCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitUntilEditAndNewItemDialogAppears();
        Assert.assertEquals(citiesPage.getInputFieldForCities().getAttribute("type"), "text",
                "The input field for city does not have attribute type 'text'.");
    }


    @Test(priority = 3)
    @Description("TC3 - Create new city")
    public void createNewCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitUntilEditAndNewItemDialogAppears();
        citiesPage.getInputFieldForCities().sendKeys("Jelena Alempijevic's city");
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitUntilSuccessMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getSuccessMessageTextElement().getText().contains("Saved successfully"),
                "The message does not contain 'Saved successfully'.");

    }

    @Test(priority = 4)
    @Description("TC4 - Edit city")
      public void editCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Jelena Alempijevic's city");
        citiesPage.waitUntilRowsAppears(1);
        citiesPage.getEditButtonFromRow(1).click();
        citiesPage.getInputFieldForCities().sendKeys(Keys.CONTROL + "a");
        citiesPage.getInputFieldForCities().sendKeys(Keys.BACK_SPACE);
        citiesPage.getInputFieldForCities().sendKeys("Jelena Alempijevic's city Edited");
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitUntilSuccessMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getSuccessMessageTextElement().getText().contains("Saved successfully"),
                "The message does not contain 'Saved successfully'.");
    }


    @Test(priority = 5)
    @Description("TC5 - Search city")
      public void searchCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Jelena Alempijevic's city");
        citiesPage.waitUntilRowsAppears(1);
        Assert.assertTrue(citiesPage.getCellByColumnAndRow(1,2).getText().contains("Jelena Alempijevic's city"),
                "The 'name' column does not contain 'Jelena Alempijevic's city'.");
    }

    @Test(priority = 6)
    @Description("TC6 - Delete city")
       public void deleteCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Jelena Alempijevic's city");
        citiesPage.waitUntilRowsAppears(1);
        Assert.assertTrue(citiesPage.getCellByColumnAndRow(1,2).getText().contains("Jelena Alempijevic's city"),
                "The 'name' column does not contain 'Jelena Alempijevic's city'.");
        citiesPage.getDeleteButtonFromRow(1).click();
        citiesPage.waitUntilDeleteItemDialogAppears();
        citiesPage.getDeleteButton().click();
        messagePopUpPage.waitUntilSuccessMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getSuccessMessageTextElement().getText().contains("Deleted successfully"),
                "The message does not contain 'Deleted successfully'.");
    }


}
