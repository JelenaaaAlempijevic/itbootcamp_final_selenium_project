import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends  BaseTest{

    @Test (priority = 1)
    @Description("TC1 - Visits the login Page")
    public void visitsTheLoginPage(){
       navPage.getLanguageButton().click();
       navPage.getEnglishLanguageButton().click();
       navPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "This url does not contain '/login'.");
    }

    @Test (priority = 2)
    @Description("TC2 - Check input types")
    public void checkInputTypes(){
      navPage.getLoginButton().click();
      Assert.assertEquals(loginPage.getEmailField().getAttribute("type"),"email",
              "The email field does not contain attribute type 'email'.");
      Assert.assertEquals(loginPage.getPasswordField().getAttribute("type"),"password",
              "The password field does not contain attribute type 'password'");
    }

    @Test(priority = 3)
    @Description("TC3 - Displays errors when user does not exist")
    public void displaysErrorsWhenUsersDoesNotExist(){
        navPage.getLoginButton().click();
        loginPage.getEmailField().sendKeys("non-exciting-user111@gmail.com");
        loginPage.getPasswordField().sendKeys("123456789");
        loginPage.getLoginField().click();
        messagePopUpPage.waitUntilErrorMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getErrorMessageTextElement().getText().contains("User does not exist"),
                "The messages does not contain 'User does not exist'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "The url of page does not contain 'login'.");
    }

    @Test(priority = 4)
    @Description("TC4 - Displays errors when password is wrong")
    public void displaysErrorWhenPasswordIsWrong(){
        navPage.getLoginButton().click();
        loginPage.getEmailField().sendKeys("admin@admin.com");
        loginPage.getPasswordField().sendKeys("password123");
        loginPage.getLoginField().click();
        messagePopUpPage.waitUntilErrorMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getErrorMessageTextElement().getText().contains("Wrong password"),
                "The messages does not contain 'Wrong password'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "The url of page does not contain 'login'.");
    }


    @Test(priority = 5)
    @Description("TC5 - Login")
    public void login() throws InterruptedException {
        navPage.getLoginButton().click();
        loginPage.getEmailField().sendKeys("admin@admin.com");
        loginPage.getPasswordField().sendKeys("12345");
        loginPage.getLoginField().click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "The url of page does not contain 'home'.");
    }

    @Test(priority = 6)
    @Description("TC6 - Logout")
    public void logout(){
        wait.until(ExpectedConditions.visibilityOf(navPage.getLoginButton()));
        Assert.assertTrue(navPage.getLoginButton().isDisplayed(),
                "The logout button is not displayed.");
        navPage.getLogoutButton().click();
    }

}
