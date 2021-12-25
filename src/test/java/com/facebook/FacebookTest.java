package com.facebook;

import com.facebook.pages.HomePage;
import com.facebook.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookTest {


    public static WebDriver driver;

    @BeforeTest
    public void start()
    {
        driver = DriverFactory.init_driver("chrome");
    }

    @Test
    public void faceBookLogin()
    {
        System.out.println("Navigating to Facebook.com");
        driver.get("https://www.facebook.com/");


        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToFb("bhavik@ost.com", "facebook@1234");

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
