package com.DemoWebShopapp.tests;

import static org.testng.Assert.assertTrue;

import org.automation.base.BasePage;
import org.automation.base.BaseTest;
import org.automation.utilities.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.DemoWebShopapp.pages.ElectronicsPage;
import com.DemoWebShopapp.pages.HomePageDWS;
import com.DemoWebShopapp.pages.LoginPageDWS;

public class ElectronicsExecution extends BaseTest  {
    @Test
	public void electronics() { 
	HomePageDWS home = new HomePageDWS();
	
	LoginPageDWS login=home.login.click(LoginPageDWS.class);
	login.email.enterText(org.automation.utilities.Configuration.get("username"));;
	login.password.enterText(Configuration.get("password"));
	login.loginButton.click(LoginPageDWS.class);
	
	ElectronicsPage electronics=home.electronics.click(ElectronicsPage.class);
	electronics.cellphones.click(ElectronicsPage.class);
	assertTrue(electronics.SortbyPosition.isVisible(), "sortByPosition DropDown is not visible");
	assertTrue(electronics.Display8PerPage.isVisible(), "Display8PerPage DropDown is not visible");
	assertTrue(electronics.viewAsGrid.isVisible(), "viewAsGrid Dropdown is not visible");
	assertTrue(electronics.Smartphone.isVisible(),"Smaertphone link is not visible");
	electronics.Smartphone.click(ElectronicsPage.class);
	assertTrue(electronics.Qty.isVisible(), "Qty Textfield is not visible");
	assertTrue(electronics.AddToCart.isVisible(), "AddToCart button is not visible");
	electronics.AddToCart.click(ElectronicsPage.class);
	assertTrue(electronics.confmsg.isVisible(), "conf msg is not visible");
	electronics.ShoppingCart.click(ElectronicsPage.class);
	assertTrue(electronics.CountryId.isVisible(), "CountryId is not visible");
	assertTrue(electronics.StateOrProvince.isVisible(), "StateOrProvince is not visible");
	assertTrue(electronics.PostalCode.isVisible(), "ZipOrPostal code is not visible");
	assertTrue(electronics.TermsAndService.isVisible(), "Terms and Conditions checkbox is not visible");
	assertTrue(electronics.CheckOut.isVisible(), "Checkout button is not visible");
	electronics.CountryId.getWebElement().findElements(By.xpath("//option[text()='India']"));
	
	


}
}