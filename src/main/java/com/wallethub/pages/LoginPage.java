package com.wallethub.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.temporal.WeekFields;

public class LoginPage {

    WebDriver driver;


    @FindBy(id = "email")
    private WebElement emailTb;


    @FindBy(id = "password")
    private WebElement passwordTb;

    @FindBy(xpath = "//button[span[contains(text(),'Login')]]")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void login(String email, String password)
    {
        emailTb.sendKeys(email);
        passwordTb.sendKeys(password);
        loginBtn.click();

    }
}
