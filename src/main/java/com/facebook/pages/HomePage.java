package com.facebook.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.ActionEvent;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@aria-label='Create a post']/div[1]/div")
    private WebElement createPostTb;

    @FindBy(xpath = "//form[@method='POST']//div[div[div[div[div[div[contains(@id,'placeholder')]]]]]]")
    private WebElement createPostForm;

    @FindBy(xpath = "//form[@method='POST']//span[text()='Post']")
    private WebElement postBtn;

    @FindBy(xpath = "//input[@aria-label='Search Facebook']")
    private WebElement searchFbTb;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void verifyLogin()
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchFbTb));
    }

    public void createPost(String text)
    {
        createPostTb.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(text);

        postBtn.click();
    }



}
