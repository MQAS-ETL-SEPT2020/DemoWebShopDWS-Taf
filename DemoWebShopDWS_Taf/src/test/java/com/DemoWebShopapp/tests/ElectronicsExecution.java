package com.DemoWebShopapp.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Map;
import org.automation.base.BaseTest;
import org.testng.annotations.Test;
import com.DemoWebShopapp.pages.CheckoutPage;
import com.DemoWebShopapp.pages.ElectronicsPage;
import com.DemoWebShopapp.pages.HomePageDWS;
import com.DemoWebShopapp.pages.LoginPageDWS;

/***
 * 
 * @author TYS-AnilKumar SM
 * @version 1.0.0
 * @since 14/11/2022
 *
 */

public class ElectronicsExecution extends BaseTest {

	@Test(dataProvider = "ExcelDataProvider")
	public void electronics(Map<String, String> data) throws InterruptedException {
		// Home Page.
		HomePageDWS home = new HomePageDWS();

		// Login Page.
		LoginPageDWS login = home.login.click(LoginPageDWS.class);
		login.email.enterText(data.get("Username"));
		assertEquals(login.email.getAttributeValue("value"), data.get("Username_Assertion"),
				"Email is not entered in Email Textfeild");
		login.password.enterText(data.get("Password"));
		assertEquals(login.password.getAttributeValue("value"), data.get("Password_Assertion"),
				"password is not entered into password textfield");
		login.loginButton.click(LoginPageDWS.class);

		// Electronics Page.
		ElectronicsPage electronics = home.electronics.click(ElectronicsPage.class);
		electronics.cellphones.click(ElectronicsPage.class);
		assertTrue(electronics.SortbyPosition.isVisible(), "sortByPosition DropDown is not visible");
		assertTrue(electronics.Display8PerPage.isVisible(), "Display8PerPage DropDown is not visible");
		assertTrue(electronics.viewAsGrid.isVisible(), "viewAsGrid Dropdown is not visible");
		assertTrue(electronics.Smartphone.isVisible(), "Smartphone link is not visible");

		electronics.Smartphone.click(ElectronicsPage.class);
		assertTrue(electronics.Qty.isVisible(), "Qty Textfield is not visible");
		assertTrue(electronics.AddToCart.isVisible(), "AddToCart button is not visible");

		electronics.AddToCart.click(ElectronicsPage.class);
		assertTrue(electronics.confmsg.isVisible(), "conf msg is not visible");

		electronics.ShoppingCart.click(ElectronicsPage.class);
		electronics.TermsAndService.check();
		assertTrue(electronics.TermsAndService.isChecked(), "Terms and service checkbox is not checked");

		electronics.CheckOutbutton.click();
		CheckoutPage checkout = new CheckoutPage();
		assertTrue(checkout.BillingAddressField.isVisible(), "Checkout button is not Clicking");

		// Checkout page.
		CheckoutPage checkout1 = new CheckoutPage();
		assertTrue(checkout1.CheckoutPage.isVisible(), "Checkoutpage is not  displayed");
        
		//Billing Address.
		checkout1.BillingAddressDropDown.selectByVisibleText(data.get("Dropdown Visible Text"));
		assertEquals(checkout.BillingAddressDropDown.getSelectedOption(), data.get("Assertion1"),
				"Incorrect option selected from dropdown");
		
		checkout.FirstName.enterText(data.get("FirstName"));
		assertEquals(checkout.FirstName.getAttributeValue("value"), data.get("Assertion2"), "Incorrect First Name");

		checkout.LastName.enterText(data.get("LastName"));
		assertEquals(checkout.LastName.getAttributeValue("value"), data.get("Assertion3"), "Incorrect First Name");

		checkout.Email.enterText(data.get("Email"));
		assertEquals(checkout.Email.getAttributeValue("value"), data.get("Assertion4"), "Incorrect Email");

		checkout.CountryIdInBilling.selectByVisibleText(data.get("Country Dropdown Text"));
		assertEquals(checkout.CountryIdInBilling.getSelectedOption(), data.get("Assertion5"),
				"Incorrect option selected from dropdown");

		checkout1.City.enterText(data.get("City"));
		assertEquals(checkout1.City.getAttributeValue("value"), data.get("Assertion6"), "Incorrect City");

		checkout1.Address1InBilling.enterText(data.get("Address1"));
		assertEquals(checkout1.Address1InBilling.getAttributeValue("value"), data.get("Assertion7"),
				"Incorrect Address");

		checkout1.ZipPostalCodeInBilling.enterText(data.get("Zip/Postal Code"));
		assertEquals(checkout1.ZipPostalCodeInBilling.getAttributeValue("value"), data.get("Assertion8"),
				"Incorrect Zip/Postal Code");

		checkout1.PhoneNumberInBilling.enterText(data.get("Phone Number"));
		assertEquals(checkout1.PhoneNumberInBilling.getAttributeValue("value"), data.get("Assertion9"),
				"Incorrect phone number");
		checkout1.ContinueInBilling.click();

		//Shipping Address.
		assertTrue(checkout1.ShippingAddressFeild.isVisible(), "Shipping Address Feild is not displayed");
		checkout1.InStorePickup.check();
		assertTrue(checkout1.InStorePickup.isChecked(), "InStorePickup  Checkbox is not checked");
		checkout1.ContinueinShipping.click();

		//Payment Method.
		assertTrue(checkout1.PaymentMethodField.isVisible(), "PaymentMethodField page is not displayed");
		checkout1.CashOnDelivery.click();
		checkout1.ContinueInPaymentMethod.click();
		
		//Payment Information.
		assertTrue(checkout1.PaymentInformationField.isVisible(), "Payment information page is displayed");
		assertTrue(checkout1.CodText.isVisible(), "You will pay by cash on delivery message is not displayed");
		checkout1.ContinueInPaymentInformation.click();
		assertTrue(checkout1.ConfirmOrderField.isVisible(), "Confirm Order Feild is not displayed");
		assertTrue(checkout1.BillingAddressText.isVisible(), "Billing  Address Text  is not displayed");
		
		//Confirmation page.
		checkout1.ConfirmInConfirmationOrder.click();		
		assertTrue(checkout1.ThankYouPage.isVisible(), "Thank you page is not displayed");
		assertTrue(checkout1.OrderNumber.isVisible(), "Order number 1315200 is not displayed");
		
		//Thank you page.
		checkout1.ContinueInThankYouPage.click();
		assertTrue(checkout1.ApplicationHomePage.isVisible(), "Demo web shop home page is not displayed");
	}
}
