package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitUntilErrorMessagePopUpIsVisible(){
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='status']")));
    }

    public void waitUntilSuccessMessagePopUpIsVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
    }

    public WebElement getErrorMessageTextElement(){
        return driver.findElement(By.xpath("//div[contains(@class, 'error')]/div[@class='v-snack__content']"));
    }

    public WebElement getSuccessMessageTextElement(){
        return driver.findElement(By.xpath("//div[contains(@class, 'success')]/div[@class='v-snack__content']"));
    }

    public WebElement getCloseButton(){
        return driver.findElement(By.xpath("//*[@class='v-snack__content']//button"));
    }

    public void waitUntilVerifyYourAccountDialogAppears(){
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'v-dialog--active')]")));
    }

    public WebElement getVerifyYourAccountHeader(){
        return driver.findElement(By.className("v-card__title"));
    }

    public WebElement getVerifyYourAccountCloseButton(){
        return driver.findElement(By.xpath("//*[contains(@class, 'v-card__actions')]/button"));
    }
}
