package com.wallethub;

import com.DriverFactory;
import com.wallethub.pages.LoginPage;
import com.wallethub.pages.ReviewPage;
import com.wallethub.pages.TestProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WallethubTest {

    WebDriver driver;
    TestProfilePage testProfilePage;
    LoginPage loginPage;
    ReviewPage reviewPage;




    String review = "Wallethub experience is very smooth and very user friendly. I will recommend this health insureance to my friends and family. Wish a very good luck and good wishes to wallet hub product and team behind it.";

    @Parameters({"email","password"})
    @BeforeTest
    public void setup(String email, String password)
    {
        driver = DriverFactory.init_driver("chrome");
        driver.get("https://wallethub.com/login");
        loginPage = new LoginPage(driver);
        loginPage.login(email,password);

    }


    @Test
    public void giveReview()
    {
        //1. Navigating to the URL

        driver.get("https://wallethub.com/profile/13732055i");


        //2. Navigating to the review section and click on 4th star
       testProfilePage=new TestProfilePage(driver);
       testProfilePage.scrollToReviewSection();

       //3 : hover to the 4th start
        testProfilePage.clickOnFourthStartHovering();


        //4. On review page, select the health insurance option
        reviewPage = new ReviewPage(driver);
        reviewPage.selectFromPolicyDropdwon("Health Insurance");


        //5. Write review and post
        reviewPage.writeReview(review);
    }

    @AfterTest
    public void tearDown()
    {
        driver.close();
        driver.quit();
    }


}
