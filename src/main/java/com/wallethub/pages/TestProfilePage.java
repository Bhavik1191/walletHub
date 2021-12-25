package com.wallethub.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestProfilePage {


    WebDriver driver;


    @FindBy(xpath = "//div[contains(@class,'review-action')]//div[@class='rating-box-wrapper']")
    private WebElement reviewSection;

    @FindBy(xpath = "//div[contains(@class,'review-action')]//div[@class='rating-box-wrapper']//*[name()='svg'][4]")
    private WebElement fourthStart;



    public TestProfilePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void scrollToReviewSection()
    {
        //Navigating to review section
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", reviewSection);
    }


    public void clickOnFourthStartHovering() {

        Actions actions = new Actions(driver);
        actions.moveToElement(fourthStart);
        actions.click().build().perform();
    }


}
