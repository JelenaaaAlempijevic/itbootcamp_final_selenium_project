import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test(priority = 1)
    @Description("TC1 - Visits the signup page")
    public void visitsTheSignUpPage() {
        navPage.getSignUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "The url of page does not contain 'signup'");
    }


    @Test(priority = 2)
    @Description("TC2 - Check input types")
    public void checkInputTypes() {
        navPage.getSignUpButton().click();
        Assert.assertEquals(signupPage.getNameInputField().getAttribute("type"), "email",
                "The email field does not contain attribute type 'email'.");
        Assert.assertEquals(signupPage.getNameInputField().getAttribute("type"), "password",
                "The password field does not contain attribute type 'password'");
        Assert.assertEquals(signupPage.getPasswordConfirmField().getAttribute("type"), "password",
                "The confirm password field does not contain attribute type 'password'.");
    }


    @Test(priority = 3)
    @Description("TC3 - Displays errors when user already exist")
    public void displaysErrorsWhenUserAlreadyExist(){
        navPage.getSignUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "The url of page does not contain 'signup'");
        signupPage.getNameInputField().sendKeys("Another User");
        signupPage.getEmailInputField().sendKeys("admin@admin.com");
        signupPage.getPasswordInputField().sendKeys("12345");
        signupPage.getPasswordConfirmField().sendKeys("12345");
        signupPage.getSignMeUpButton().click();
        messagePopUpPage.waitUntilMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getTextElementsFromMessagePopUp().getText().contains("E-mail already exist."),
                "The message does not contain 'E-mail already exist.'");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "The url of page does not contain 'signup'");
    }

    @Test(priority = 4)
    @Description("TC4 - Signup")
    public void signup(){
        navPage.getSignUpButton().click();
        signupPage.getNameInputField().sendKeys("Another User");
        signupPage.getEmailInputField().sendKeys("admin@admin.com");
        signupPage.getPasswordInputField().sendKeys("12345");
        signupPage.getPasswordConfirmField().sendKeys("12345");
        signupPage.getSignMeUpButton().click();
        wait.until(ExpectedConditions.urlContains("/home"));
        Assert.assertTrue(messagePopUpPage.getVerifyYourAccountHeader().getText().contains("IMPORTANT: Verify your account."),
                "The message does not conatin 'IMPORTANT: Verify your account.'");
        messagePopUpPage.getVerifyYourAccountCloseButton().click();
        navPage.getLogoutButton().click();
    }


}
