package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage {


    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getHomeLink(){
        return driver.findElement(By.xpath("//div[@class='v-toolbar__items']/a[1]"));
    }

   public WebElement getAboutLink(){
        return  driver.findElement(By.xpath("//div[@class='v-toolbar__items']/a[2]"));
   }

   public WebElement getMyProfileLink(){
        return driver.findElement(By.className("btnProfile"));
   }

   public WebElement getAdminButton(){
        return driver.findElement(By.className("btnAdmin"));
   }

    public WebElement getCitiesLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btnAdminCities")));
        return driver.findElement(By.className("btnAdminCities"));
    }

    public WebElement getUsersLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btuAdminUsers")));
        return driver.findElement(By.className("btnAdminUsers"));
    }

    public WebElement getSignUpLink(){
        return driver.findElement(By.xpath("//div[@class='v-toolbar__items']/a[4]"));
    }

    public WebElement getLoginLink(){
        return driver.findElement(By.xpath("//div[@class='v-toolbar__items']/a[3]"));
    }

    public WebElement getLogoutButton(){
        return driver.findElement(By.className("btnLogout"));
    }

    public WebElement getLanguageButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public WebElement getEnglishLanguageButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='menu']")));
        return driver.findElement(By.id("list-item-327"));
    }

    public WebElement getSpanishLanguageButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='menu']")));
        return driver.findElement(By.id("list-item-329"));
    }

    public WebElement getFrenchLanguageButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='menu']")));
        return driver.findElement(By.id("list-item-331"));
    }

    public WebElement getChineseLanguageButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='menu']")));
        return driver.findElement(By.id("list-item-333"));
    }

    public WebElement getUkrainianLanguageButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='menu']")));
        return driver.findElement(By.id("list-item-335"));
    }
}
