package com.wallethub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReviewPage {

    WebDriver driver;

    @FindBy(xpath = "//div[contains(@class,'dropdown second')]")
    private WebElement dropDownList;

    @FindBy(xpath = "//div[contains(@class,'dropdown second')]/ul/li[2]")
    private WebElement healthInsuranceOption;

    @FindBy(xpath = "//div[@class='android']/textarea")
    private WebElement reviewTb;

    @FindBy(xpath = "//div[text()='Submit']")
    private WebElement submitTb;


    public ReviewPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void selectFromPolicyDropdwon(String value) {
        dropDownList.click();
        healthInsuranceOption.click();


        ////div[contains(@class,'dropdown second')]/ul

    }

    public void writeReview(String review)
    {
        reviewTb.sendKeys(review);
        submitTb.click();
    }
}
