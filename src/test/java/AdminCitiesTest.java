import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CitiesPage;

public class AdminCitiesTest extends BaseTest{

    @Test(priority = 1)
    @Description("TC1 - Visits the admin cities page and list cities")
    public void visitsTheAdminCitiesPageAndListCities(){
        navPage.getSignUpButton().click();
        loginPage.getEmailField().sendKeys("admin@admin.com");
        loginPage.getPasswordField().sendKeys("12345");
        loginPage.getLoginField().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        Assert.assertEquals(driver.getCurrentUrl(),"/admin/cities",
                "The page url does not contain '/admin/cities'.");
    }

    @Test(priority = 2)
    @Description("TC2 - Checks input types for create/edit new city")
    public void checksInputTypesForCreateOrEditNewCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitUntilEditAndNewItemDialogAppears();
        Assert.assertTrue(citiesPage.getInputFieldForCities().getAttribute("type").contains("text"),
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
        messagePopUpPage.waitUntilMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getTextElementsFromMessagePopUp().getText().contains("Saved successfully"),
                "The message does not contain 'Saved successfully'.gi");

    }


}
