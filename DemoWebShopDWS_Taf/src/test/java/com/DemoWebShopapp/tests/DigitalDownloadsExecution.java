package com.DemoWebShopapp.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.automation.base.BaseTest;
import org.automation.utilities.Configuration;
import org.testng.annotations.Test;

import com.DemoWebShopapp.pages.CheckoutPage;
import com.DemoWebShopapp.pages.DigitalDownloadsPage;
import com.DemoWebShopapp.pages.HomePageDWS;
import com.DemoWebShopapp.pages.LoginPageDWS;

/**
 * @author TYS-Megha D
 * 
 * @version 1.0.0
 * @since 14/11/2022
 *
 */

public class DigitalDownloadsExecution extends BaseTest {

	@Test(dataProvider = "ExcelDataProvider")
	public void digitalDownloads(Map<String, String> data) {

		// Home Page
		HomePageDWS home = new HomePageDWS();

		// login Page
		LoginPageDWS login = home.login.click(LoginPageDWS.class);
		login.email.enterText(Configuration.get("username"));
		login.password.enterText(Configuration.get("password"));
		assertTrue(login.loginButton.isEnabled(), "Login Button is disabled");
		login.loginButton.click(LoginPageDWS.class);

		// digital downloads
		DigitalDownloadsPage digitalDownloads = home.digitalDownloads.click(DigitalDownloadsPage.class);
		assertTrue(digitalDownloads.digitalDownloadspage.isVisible(), "Digital Downloads Page is not displayed");
		assertTrue(digitalDownloads.sortby.isVisible(), "SortBy dropdown is not visible");
		assertTrue(digitalDownloads.position_sortby.isVisible(), "Not displaying Position option");
		assertTrue(digitalDownloads.displayPerPage.isVisible(), "display_PerPage dropdown is not visible");
		assertTrue(digitalDownloads.eight_displayPerPage.isVisible(),
				"Not displaying  eight in  displayPerPage option");
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

		// Checkout Page
		CheckoutPage checkout = new CheckoutPage();

		assertTrue(checkout.CheckoutPage.isVisible(), "CheckoutPage is not Displayed");

		// Billing Address
		checkout.BillingAddressDropDown.click(CheckoutPage.class);
		checkout.BillingAddressDropDown.selectByVisibleText(data.get("Dropdown Visible Text"));
		assertEquals(checkout.BillingAddressDropDown.getSelectedOption(), data.get("Assertion1"),
				"Incorrect option selected from dropdown");

		checkout.FirstName.enterText(data.get("FirstName"));
		assertEquals(checkout.FirstName.getAttributeValue("value"), data.get("Assertion2"), "Incorrect First Name");

		checkout.LastName.enterText(data.get("LastName"));
		assertEquals(checkout.LastName.getAttributeValue("value"), data.get("Assertion3"), "Incorrect First Name");

		checkout.Email.enterText(data.get("Email"));
		assertEquals(checkout.Email.getAttributeValue("value"), data.get("Assertion4"), "Incorrect Email");

		checkout.CountryIdInBilling.click(CheckoutPage.class);
		checkout.CountryIdInBilling.selectByVisibleText(data.get("Country Dropdown Text"));
		assertEquals(checkout.CountryIdInBilling.getSelectedOption(), data.get("Assertion5"),
				"Incorrect option selected from dropdown");

		checkout.City.enterText(data.get("City"));
		assertEquals(checkout.City.getAttributeValue("value"), data.get("Assertion6"), "Incorrect City");

		checkout.Address1InBilling.enterText(data.get("Address1"));
		assertEquals(checkout.Address1InBilling.getAttributeValue("value"), data.get("Assertion7"),
				"Incorrect Address1");

		checkout.ZipPostalCodeInBilling.enterText(data.get("Zip/Postal Code"));
		assertEquals(checkout.ZipPostalCodeInBilling.getAttributeValue("value"), data.get("Assertion8"),
				"Incorrect Zip/Postal Code");

		checkout.PhoneNumberInBilling.enterText(data.get("Phone Number"));
		assertEquals(checkout.PhoneNumberInBilling.getAttributeValue("value"), data.get("Assertion9"),
				"Incorrect Phone Number");

		assertTrue(checkout.ContinueInBilling.isEnabled(), "Continue In Billing is  disabled");
		checkout.ContinueInBilling.click();

		
		// Payment Method
		assertTrue(checkout.PaymentMethodField.isVisible(), "Payment Method Feild is not displayed");
		checkout.CheckMoneyOrder.click();
		assertTrue(checkout.ContinueInPaymentMethod.isEnabled(), "Continue In Payment Method is  disabled");
		checkout.ContinueInPaymentMethod.click();

		// Payment Information
		assertTrue(checkout.PaymentInformationField.isVisible(), "Payment Information Feild is not displayed");
		assertTrue(checkout.ContinueInPaymentInformation.isEnabled(), "Continue In Payment Information  is  disabled");
		checkout.ContinueInPaymentInformation.click();

		// Confirmation Order
		assertTrue(checkout.ConfirmOrderField.isVisible(), "Confirm Order Feild is not displayed");
		assertTrue(checkout.BillingAddressText.isVisible(), "Billing  Address Text  is not displayed");
		assertTrue(checkout.ConfirmInConfirmationOrder.isEnabled(), "Confirm In ConfirmationOrder is  diasbled");
		checkout.ConfirmInConfirmationOrder.click();

		// ThankYou Page
		assertTrue(checkout.ThankYouPage.isVisible(), "ThankYouPage is not displayed");
		assertTrue(checkout.OrderNumber.isVisible(), "OrderNumber is not displayed");
		assertTrue(checkout.ConfirmationMessage.isVisible(), "ConfirmationMessage is not displayed");
		assertTrue(checkout.ContinueInThankYouPage.isEnabled(), "Continue In ThankYouPage is  disabled");
		checkout.ContinueInThankYouPage.click();
		assertTrue(checkout.ApplicationHomePage.isVisible(), "Application HomePage is displayed");

	}
}