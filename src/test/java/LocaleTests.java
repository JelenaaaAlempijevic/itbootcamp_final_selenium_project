import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest{

    @Test(priority = 1)
    @Description("TC1 - Set locale to ES")
      public void setLocaleToES(){
      navPage.getLanguageButton().click();
      navPage.getSpanishLanguageButton().click();
        Assert.assertTrue(landingPage.getHeaderOfPage().getText().contains("Página de aterrizaje"),
                "The header of page does not contains 'Página de aterrizaje'.");
    }


    @Test(priority = 2)
    @Description("TC2 - Set locale to EN")
      public void setLocaleToEN(){
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        Assert.assertTrue(landingPage.getHeaderOfPage().getText().contains("Landing"),
                "The header of page does not contains 'Landing'.");
    }


    @Test(priority = 3)
    @Description("TC3 - Set locale to CN")
    public void setLocaleToCN() {
        navPage.getLanguageButton().click();
        navPage.getChineseLanguageButton().click();
        Assert.assertTrue(landingPage.getHeaderOfPage().getText().contains("首页"),
                "The header of page does not contains '首页'.");
    }


    @Test(priority = 4)
    @Description("TC4 - Set locale to FR")
    public void setLocaleToFR() {
        navPage.getLanguageButton().click();
        navPage.getFrenchLanguageButton().click();
        Assert.assertTrue(landingPage.getHeaderOfPage().getText().contains("Page d'atterrissage"),
                "The header of page does not contains 'Page d'atterrissage'.");
    }


    @Test(priority = 5)
    @Description("TC5 - Set locale to UA")
    public void setLocaleToUA() {
        navPage.getLanguageButton().click();
        navPage.getUkrainianLanguageButton().click();
        Assert.assertTrue(landingPage.getHeaderOfPage().getText().contains("Лендінг"),
                "The header of page does not contains 'Лендінг'.");
    }

}
