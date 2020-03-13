package com.test.automation.PageObject.PageFactory.uiactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage{
	
	public final static Logger log = Logger.getLogger(HomePage.class.getName());
	
	WebDriver driver;

	@FindBy(xpath="//li[@class='nav__level1--makeup nav__level1']//a[contains(text(),'makeup')]")
	WebElement makeUpLink;
	
	@FindBy(xpath="//li[@class='nav__level2--face nav__level2']//ul[@class='level-3']/li[contains(@class,'makeup-face-foundation')]/a[contains(text(),'foundation')]")
	WebElement foundationLink;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void firstRemoveOverlay() {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.ESCAPE).build().perform();
	}
	
	public void moveToMakeup(){
		Actions builder = new Actions(driver);
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement makeUp = wait1.until(ExpectedConditions.visibilityOf(makeUpLink));
        Action mouseOverMakeUp = builder.moveToElement(makeUpLink).build();
        mouseOverMakeUp.perform();
        log.info("moved to makeup and object is " + makeUp.toString());
	}
	
	public void clickFoundation() {
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement foundationLnk = wait1.until(ExpectedConditions.visibilityOf(foundationLink));
		foundationLnk.click();
        log.info("clicked on foundation and object is " + foundationLnk.toString());
	}
}
