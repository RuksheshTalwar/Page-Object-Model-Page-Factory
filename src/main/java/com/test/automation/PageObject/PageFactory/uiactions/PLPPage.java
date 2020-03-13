package com.test.automation.PageObject.PageFactory.uiactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PLPPage{
	
	public final static Logger log = Logger.getLogger(PLPPage.class.getName());
	
	WebDriver driver;

	@FindBy(xpath="//a[@title='Go to: Amazonian clay full coverage foundation SPF 15']")
	WebElement firstProductLink;
	
	@FindBy(xpath="//a[@title='Go to: face tape™ foundation']/img[@alt='face tape&trade; foundation'][1]")
	WebElement secondProductLink;
	
	@FindBy(xpath="//a[@title='Go to: babassu foundcealer™ skincare foundation Broad Spectrum SPF 20']/img[@alt='babassu foundcealer&trade; skincare foundation Broad Spectrum SPF 20'][1]")
	WebElement thirdProductLink;
	
	@FindBy(xpath="//img[@alt='Close this Privacy Policy']")
	WebElement privacyPolicyLink;
	
	public PLPPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnFirstProduct(){
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement firstProduct = wait1.until(ExpectedConditions.visibilityOf(firstProductLink));
		new Actions(driver).moveToElement(firstProduct).build().perform();
		firstProduct.click();
		log.info("clicked on first product and object is " + firstProduct.toString());
	}
	
	public void clickOnSecondProduct(){
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement secondProduct = wait1.until(ExpectedConditions.visibilityOf(secondProductLink));
		secondProduct.click();
		log.info("clicked on first product and object is " + secondProduct.toString());
	}
	
	public void clickOnThirdProduct(){
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement thirdProduct = wait1.until(ExpectedConditions.visibilityOf(thirdProductLink));
		thirdProduct.click();
		log.info("clicked on first product and object is " + thirdProduct.toString());
	}
	
	public void clickPrivacyPolicy() {
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement privPolicy = wait1.until(ExpectedConditions.visibilityOf(privacyPolicyLink));
		privPolicy.click();
		log.info("clicked on first product and object is " + privPolicy.toString());
	}
}
