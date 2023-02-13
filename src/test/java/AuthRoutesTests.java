import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest{

    @Test(priority = 1)
    @Description("TC1 - Forbids visits to home url if not authenticated")
      public void forbidsVisitsToHomeUrlIfNotAuthenticated(){
        driver.get(baseUrl + "/home");
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl +"/login",
                "The url of page does not contain '/login'.");

    }

    @Test(priority = 2)
    @Description("TC2 - Forbids visits to profile url if not authenticated")
      public void forbidsVisitsToProfileUrlIfNotAuthenticated(){
        driver.get(baseUrl + "/profile");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl +"/login",
                "The url of page does not contain '/login'.");

    }

    @Test(priority = 3)
    @Description("TC3 - Forbids visits to admin cities url if not authenticated")
      public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated(){
        driver.get(baseUrl + "/admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login",
                "The url of page does not contain '/login'.");

    }

    @Test(priority = 4)
    @Description("TC4 - Forbids visits to admin users url if not authenticated")
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated(){
        driver.get(baseUrl + "/admin/users");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login",
                "The url of page does not contain '/login'.");

    }

}
