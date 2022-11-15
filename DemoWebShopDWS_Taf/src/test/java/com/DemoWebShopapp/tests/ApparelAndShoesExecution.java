package com.DemoWebShopapp.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.automation.base.BaseTest;
import org.automation.config.DriverType;
import org.automation.config.WebDriverThread;
import org.automation.logger.Log;
import org.automation.utilities.Configuration;
import org.testng.annotations.Test;

import com.DemoWebShopapp.pages.ApparelAndShoesPage;
import com.DemoWebShopapp.pages.CheckoutPage;
import com.DemoWebShopapp.pages.HomePageDWS;
import com.DemoWebShopapp.pages.LoginPageDWS;

/**
 * 
 * @author TYS-Priyanka G M
 * @version 1.0.0
 * @since 14/11/2022
 *
 */
public class ApparelAndShoesExecution extends BaseTest {
	@Test(dataProvider = "ExcelDataProvider")
	public void checkout(Map<String, String> data) throws InterruptedException {
		// Home page
		HomePageDWS home = new HomePageDWS();

		// Login page
		LoginPageDWS login = home.login.click(LoginPageDWS.class);

		assertTrue(login.email.isVisible(), "Not clicking on Login Link");
		assertTrue(login.password.isVisible(), "Not clicking on Login Link");
		assertTrue(login.loginButton.isVisible(), "Not clicking on Login Link");

		// Entering email to the email text field
		login.email.enterText(data.get("Username"));
		Log.info("Entering the Email into the Email Textfield");
		assertEquals(login.email.getAttributeValue("value"), data.get("Username_Assertion"),
				"Email is not entered into the Email Textfeild");

		// Entering password ti the password text field
		login.password.enterText(data.get("Password"));
		Log.info("Entering the Password into the Password Textfield");
		assertEquals(login.password.getAttributeValue("value"), data.get("Password_Assertion"),
				"Password is not entered into the Password Textfield");

		login = login.loginButton.click(LoginPageDWS.class);
		// Home Page
		HomePageDWS homepage = new HomePageDWS();
		assertTrue(homepage.books.isVisible(), "Not Clicking on Login Button");
		assertTrue(homepage.computers.isVisible(), "Not Clicking on Login Button");
		assertTrue(homepage.electronics.isVisible(), "Not Clicking on Login Button");
		assertTrue(homepage.apparelAndShoes.isVisible(), "Not Clicking on Login Button");
		assertTrue(homepage.digitalDownloads.isVisible(), "Not Clicking on Login Button");
		assertTrue(homepage.jewellery.isVisible(), "Not Clicking on Login Button");
		assertTrue(homepage.giftCards.isVisible(), "Not Clicking on Login Button");

		// ApparelAndShoes page
		ApparelAndShoesPage apparelandshoes = home.apparelAndShoes.click(ApparelAndShoesPage.class);
		Log.info("Clicking on ApparelAndShoes menu");
		assertTrue(apparelandshoes.apparelandshoestext.isVisible(), "Apparelandshoes page is not dispalyed");

		assertTrue(apparelandshoes.sortbytext.isVisible(), "By default sort by dropdown should not display position");

		assertTrue(apparelandshoes.displaytext.isVisible(), "By default display dropdown should not display 8");

		assertTrue(apparelandshoes.viewastext.isVisible(), "By default viewas dropdown should not display Grid");

		apparelandshoes.product.click();

		assertTrue(apparelandshoes.producttext.isVisible(), "Product page should not be diplayed");
		assertTrue(apparelandshoes.sizetext.isVisible(), "By default size dropdown should not be display small");
		assertTrue(apparelandshoes.qtytext.isVisible(), "By default size textbox should not be display 1");

		apparelandshoes.addtocart.click();
		Log.info("product is added to cart");
		assertTrue(apparelandshoes.productaddedtext.isVisible(),
				"Product has been added to cart msg should not be displayed");

		apparelandshoes.shoppingcart.click();
		Log.info("Shopping cart page should be displayed");
		assertTrue(apparelandshoes.shoppingcarttext.isVisible(), "Shopping cart page is not displayed");

		apparelandshoes.termsandconditions.check();
		Log.info("Terms and conditions check bix is checked");
		assertTrue(apparelandshoes.termsandconditions.isChecked(), "terms and condition checkbox is not checked");

		// Checkout page
		CheckoutPage checkout1 = new CheckoutPage();

		apparelandshoes.checkout.click();
		Log.info("clicked on checkout button");

		Log.info("checkout page is displayed");

		// BillingAddressPage
		checkout1.BillingAddressDropDown.selectByVisibleText(data.get("Dropdown Visible Text"));
		checkout1.FirstName.enterText(data.get("FirstName"));
		Log.info("FirstName text field should be entered");
		assertEquals(checkout1.FirstName.getAttributeValue("value"), data.get("Assertion2"),
				"First name is not entered into the firstname textfield");

		checkout1.LastName.enterText(data.get("LastName"));
		Log.info("LastName text field should be entered");
		assertEquals(checkout1.LastName.getAttributeValue("value"), data.get("Assertion3"),
				"Last name is not entered into the Lastname textfield");

		checkout1.Email.enterText(data.get("Email"));
		Log.info("Email text fiekd should be entered");
		assertEquals(checkout1.Email.getAttributeValue("value"), data.get("Assertion4"),
				"Email is not entered into the Email textfield");

		checkout1.CountryIdInBilling.click();
		checkout1.CountryIdInBilling.selectByVisibleText(data.get("Country Dropdown Text"));
		Log.info("Country should be selected ");
		assertEquals(checkout1.CountryIdInBilling.getSelectedOption(), data.get("Assertion5"),
				" option is not selected");

		checkout1.City.enterText(data.get("City"));
		Log.info("City entered as Bangaluru");
		assertEquals(checkout1.City.getAttributeValue("value"), data.get("Assertion6"), "City is not entered");

		checkout1.Address1InBilling.enterText(data.get("Address1"));
		Log.info("Address should be enetered");
		assertEquals(checkout1.Address1InBilling.getAttributeValue("value"), data.get("Assertion7"),
				"Address is not entered");

		checkout1.ZipPostalCodeInBilling.enterText(data.get("Zip/Postal Code"));
		Log.info("Zip/Postal code should be enetered");
		assertEquals(checkout1.ZipPostalCodeInBilling.getAttributeValue("value"), data.get("Assertion8"),
				"Zip/postalcode is not entered");

		checkout1.PhoneNumberInBilling.enterText(data.get("Phone Number"));
		Log.info("Phone number should be entered");
		assertEquals(checkout1.PhoneNumberInBilling.getAttributeValue("value"), data.get("Assertion9"),
				"Phone number is not entered");

		checkout1.ContinueInBilling.click();
		Log.info("Clicked on continue button");

		// Shipping address
		checkout1.InStorePickup.check();
		Log.info("InstorePickUp checkbox is checked");
		assertTrue(checkout1.InStorePickup.isChecked(), "InstorePickUp checkbox is not checked");
		Thread.sleep(4000);

		checkout1.ContinueinShipping.click();
		Log.info("Clicked on continue button");
		assertTrue(checkout1.ContinueinShipping.isVisible(), "continue button is not clicked");

		// Payment method
		checkout1.ContinueInPaymentMethod.click();
		Log.info("Clicked on continue button");
		assertTrue(checkout1.ContinueInPaymentMethod.isVisible(), "continue button is not clicked");

		// Payment information
		checkout1.ContinueInPaymentInformation.click();
		Log.info("Clicked on continue button");
		assertTrue(checkout1.ContinueInPaymentInformation.isVisible(), "continue button is not clicked");

		// Confirmation order
		checkout1.ConfirmInConfirmationOrder.click();
		Log.info("Clicked on confirm button");
		assertTrue(checkout1.ConfirmInConfirmationOrder.isVisible(), "confirm button is not clicked");

		// Thankyou page
		checkout1.ContinueInThankYouPage.click();
		Log.info("Clicked on continue button");

	}
}
