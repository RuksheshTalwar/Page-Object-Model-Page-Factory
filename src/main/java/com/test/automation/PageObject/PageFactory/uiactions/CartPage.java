package com.test.automation.PageObject.PageFactory.uiactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CartPage{
	
	public final static Logger log = Logger.getLogger(CartPage.class.getName());
	
	WebDriver driver;

	@FindBy(xpath="//table[@id='cart-table']//tbody/tr[1]/td[@class='remove']/button")
	WebElement removeFirstProduct;
	
	
	public CartPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickRemoveFirstProd(){
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement remove = wait1.until(ExpectedConditions.visibilityOf(removeFirstProduct));
		remove.click();
		log.info("clicked on first product and object is " + remove.toString());
	}
}
