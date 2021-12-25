package com.facebook;

import com.DriverFactory;
import com.facebook.pages.HomePage;
import com.facebook.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FacebookTest {


    public static WebDriver driver;

    @BeforeTest
    public void start()
    {
        driver = DriverFactory.init_driver("chrome");
    }

    @Parameters({"email","password"})
    @Test
    public void faceBookLogin(String email, String password)
    {
        System.out.println("Navigating to Facebook.com");
        driver.get("https://www.facebook.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToFb(email, password);

        HomePage homePage = new HomePage(driver);
        try{
            homePage.verifyLogin();
        }
        catch (Exception e )
        {
            System.out.println("Login not successful");
            Assert.fail();
            e.printStackTrace();
        }

        homePage.createPost("Hello world");
    }

    @AfterTest
    public void tearDown()
    {
        driver.close();
        driver.quit();
    }
}
