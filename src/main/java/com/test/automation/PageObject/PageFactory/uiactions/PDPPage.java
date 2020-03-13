package com.test.automation.PageObject.PageFactory.uiactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PDPPage{
	
	public final static Logger log = Logger.getLogger(PDPPage.class.getName());
	
	WebDriver driver;

	@FindBy(xpath="//ul[@class='swatches color']//img[@alt='Color: 8B porcelain beige (very fair skin with pink undertones)']")
	WebElement firstProductColorSwatch;
	
	@FindBy(xpath="//button[@id='add-to-cart']")
	WebElement addToBagLink;
	
	@FindBy(xpath="//span[@class='minicart-quantity']")
	WebElement viewBagAndCheckoutLink;
	
	@FindBy(xpath="//div[@class='mini-cart-header']")
	WebElement bagDisappear;
	
	
	public PDPPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectFirstProdColor(){
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement firstProductColorLink = wait1.until(ExpectedConditions.visibilityOf(firstProductColorSwatch));
		firstProductColorLink.click();
		log.info("selected first product color and object is " + firstProductColorLink.toString());
	}
	
	public void clickAddToBag() throws InterruptedException{
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement addToBag = wait1.until(ExpectedConditions.visibilityOf(addToBagLink));
		Thread.sleep(5000);
		new Actions(driver).moveToElement(addToBag).build().perform();
		addToBag.click();
		log.info("clicked on Add to Bag and object is " + addToBag.toString());
	}
	
	public void clickViewBag() {
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement viewBag = wait1.until(ExpectedConditions.visibilityOf(viewBagAndCheckoutLink));
		viewBag.click();
		log.info("clicked on Add to Bag and object is " + viewBag.toString());
	}
	
	public void waitForBagToDisappear() {
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.invisibilityOf(bagDisappear));
	}
	
	public void navigateToPLP() {
		driver.navigate().back();
	}
}
