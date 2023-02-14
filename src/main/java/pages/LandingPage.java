package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage{

    public LandingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getHeaderOfPage(){
        return driver.findElement(By.xpath("//*/div[1]/h1"));
    }
}
