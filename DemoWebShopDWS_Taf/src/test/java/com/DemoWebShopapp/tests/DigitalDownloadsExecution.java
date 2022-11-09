package com.DemoWebShopapp.tests;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.automation.base.BaseTest;
import org.automation.utilities.Configuration;
import org.testng.annotations.Test;

import com.DemoWebShopapp.pages.CheckoutPage;
import com.DemoWebShopapp.pages.DigitalDownloadsPage;
import com.DemoWebShopapp.pages.HomePageDWS;
import com.DemoWebShopapp.pages.LoginPageDWS;


public class DigitalDownloadsExecution extends BaseTest {
	@Test
	public void navigateToCheckOutPage() throws InterruptedException {

		// Home Page
		HomePageDWS home = new HomePageDWS();

		// login Page
		LoginPageDWS login = home.login.click(LoginPageDWS.class);
		login.email.enterText(Configuration.get("username"));
		login.password.enterText(Configuration.get("password"));
		login.loginButton.click(LoginPageDWS.class);

		// digital downloads
		DigitalDownloadsPage digitalDownloads = home.digitalDownloads.click(DigitalDownloadsPage.class);
		assertTrue(digitalDownloads.sortby.isVisible(), "SortBy dropdown is not visible");
		assertTrue(digitalDownloads.position_sortby.isVisible(), "Not displaying Position option");
		assertTrue(digitalDownloads.displayPerPage.isVisible(), "SortBy dropdown is not visible");
		assertTrue(digitalDownloads.position_sortby.isVisible(), "Not displaying Position option");
		assertTrue(digitalDownloads.viewAs.isVisible(), "ViewAs dropdown is not visible");
		assertTrue(digitalDownloads.grid_viewAs.isVisible(), "Not displaying Grid option");
		digitalDownloads.thirdAlbum.click();

		assertTrue(digitalDownloads.thirdAlbumPage.isVisible(), "Not displaying 3rd Album Page");
		assertTrue(digitalDownloads.price.isVisible(), "Not displaying Price");
		assertTrue(digitalDownloads.quantity.isVisible(), "Not displaying Quantity");

		digitalDownloads.addToCart.click(DigitalDownloadsPage.class);
		assertTrue(digitalDownloads.confirmationMessage.isVisible(), "Not displaying Confirmation Message");
		digitalDownloads.shoppingCart.click(DigitalDownloadsPage.class);
		assertTrue(digitalDownloads.shoppingCartPage.isVisible(), "Not displaying ShoppingCart Page ");

		assertTrue(digitalDownloads.termsOfServiceText.isVisible(), "Not displaying Terms Of Service Text");
		digitalDownloads.termsOfServiceCheckbox.check();
		assertTrue(digitalDownloads.termsOfServiceCheckbox.isChecked(), "Checkbox is not Checked");

		digitalDownloads.checkOut.click();
	}
	// checkout

	@Test(dataProvider = "ExcelDataProvider")
	public void checkout(Map<String, String> data) {
		CheckoutPage checkout=new CheckoutPage();
		//checkout.BillingAddress.click();
		
		
	}
}