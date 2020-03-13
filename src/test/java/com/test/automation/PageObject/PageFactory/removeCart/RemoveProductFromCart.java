package com.test.automation.PageObject.PageFactory.removeCart;


import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.test.automation.PageObject.PageFactory.testbase.TestBase;
import com.test.automation.PageObject.PageFactory.uiactions.CartPage;
import com.test.automation.PageObject.PageFactory.uiactions.HomePage;
import com.test.automation.PageObject.PageFactory.uiactions.PDPPage;
import com.test.automation.PageObject.PageFactory.uiactions.PLPPage;

public class RemoveProductFromCart extends TestBase{

	public static final Logger log = Logger.getLogger(RemoveProductFromCart.class.getName());
	HomePage homePage;
	PLPPage plp;
	PDPPage pdp;
	CartPage cart;
	
	
	@Test
	public void removeProduct() throws InterruptedException{
		log.info("================ Starting removeProduct Test ==================");
		homePage = new HomePage(driver);
		plp = new PLPPage(driver);
		pdp = new PDPPage(driver);
		cart = new CartPage(driver);
		
		homePage.firstRemoveOverlay();
		homePage.moveToMakeup();
		homePage.clickFoundation();
		plp.clickPrivacyPolicy();
		plp.clickOnFirstProduct();
//		pdp.selectFirstProdColor();
		pdp.clickAddToBag();
		pdp.waitForBagToDisappear();
		Thread.sleep(5000);
		homePage.moveToMakeup();
		homePage.clickFoundation();
		plp.clickOnSecondProduct();
		pdp.clickAddToBag();
		pdp.navigateToPLP();
		
//		pdp.waitForBagToDisappear();
//		homePage.moveToMakeup();
//		homePage.clickFoundation();
		
		plp.clickOnThirdProduct();
		pdp.clickAddToBag();
		
		pdp.clickViewBag();
		cart.clickRemoveFirstProd();
		
		
		
		log.info("================ Ending removeProduct Test ==================");
	}
}
