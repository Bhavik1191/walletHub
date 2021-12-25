package com.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;


    @FindBy(id = "email")
    private WebElement emailTb;

    @FindBy(id = "pass")
    private WebElement passwordTb;

    @FindBy(name = "login")
    private WebElement loginTb;


    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void loginToFb(String user, String password)
    {
        emailTb.sendKeys(user);
        passwordTb.sendKeys(password);
        loginTb.click();
    }
}
