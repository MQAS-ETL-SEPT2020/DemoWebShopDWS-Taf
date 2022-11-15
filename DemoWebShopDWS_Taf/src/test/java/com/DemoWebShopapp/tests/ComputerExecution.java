package com.DemoWebShopapp.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Map;
import org.automation.base.BaseTest;
import org.testng.annotations.Test;
import com.DemoWebShopapp.pages.CheckoutPage;
import com.DemoWebShopapp.pages.ComputerPage;
import com.DemoWebShopapp.pages.HomePageDWS;
import com.DemoWebShopapp.pages.LoginPageDWS;

/**
 * 
 * @author TYS-Preeti s  
 * @version 1.0.0
 * @since 14/11/2022
 *
 */
public class ComputerExecution extends BaseTest {

	@Test(dataProvider = "ExcelDataProvider")

	public void checkout(Map<String, String> data) throws InterruptedException {

		// LOGIN PAGE
		HomePageDWS home = new HomePageDWS();
		LoginPageDWS login = home.login.click(LoginPageDWS.class);
		login.email.enterText(data.get("Username"));
		assertEquals(login.email.getAttributeValue("value"), data.get("Username_Assertion"),
				"Email is not entered into Email textfield");
		login.password.enterText(data.get("Password"));
		assertEquals(login.password.getAttributeValue("value"), data.get("Password_Assertion"),
				"password is not entered into password textfield");
		login = login.loginButton.click(LoginPageDWS.class);

		// DESKTOPS PAGE
		ComputerPage computer = home.computers.click(ComputerPage.class);
		assertTrue(computer.computertext.isVisible(), "computer page is not displayed");
		computer.desktops.click();
		assertTrue(computer.SortbyText.isVisible(), "By default Sortby dropdown is not selected as Position ");
		assertTrue(computer.DisplayText.isVisible(), "By default Display per page dropdown is not selected as 8 ");
		assertTrue(computer.ViewAsText.isVisible(), "By default ViewAs dropdown is not selected as Grid ");
		computer.computer.click();

		// DESKTOPS SUB PAGE
		assertTrue(computer.ExpensivecomputerText.isVisible(), "By default Expensivecomputer page  is not displayed");
		assertTrue(computer.Processor.isVisible(), "By default Processor is not selected as  Medium [+15.00]");
		assertTrue(computer.RAM.isVisible(), "By default Ram is not selected as 2GB");
		computer.Softwares.click();
		assertTrue(computer.Quality.isVisible(), "By default Quality will be 1");
		computer.AddtoCart.click();
		computer.shoppingcart.click();

		// SHOPPING CART PAGE
		assertTrue(computer.shoppingcartText.isVisible(), "shopping cart page is not displayed");
		computer.Terms.check();
		computer.checkout.click();

		// CHECKOUT PAGE
		CheckoutPage checkout1 = new CheckoutPage();
		assertTrue(checkout1.CheckoutPage.isVisible(), "Checkoutpage is not displayed");

		// BILLING ADDRESS
		checkout1.BillingAddressDropDown.selectByVisibleText(data.get("Dropdown Visible Text"));
		assertEquals(checkout1.BillingAddressDropDown.getSelectedOption(), data.get("Assertion1"),
				"Incorrect option selected from dropdown");

		checkout1.FirstName.enterText(data.get("FirstName"));
		assertEquals(checkout1.FirstName.getAttributeValue("value"), data.get("Assertion2"),
				"FirstName is not entered into FirstName textfield");

		checkout1.LastName.enterText(data.get("LastName"));
		assertEquals(checkout1.LastName.getAttributeValue("value"), data.get("Assertion3"),
				"LastName is not entered into LastName textfield");

		checkout1.Email.enterText(data.get("Email"));
		assertEquals(checkout1.Email.getAttributeValue("value"), data.get("Assertion4"),
				"Email is not entered into Email textfield");

		checkout1.CountryIdInBilling.selectByVisibleText(data.get("Country Dropdown Text"));
		assertEquals(checkout1.CountryIdInBilling.getSelectedOption(), data.get("Assertion5"),
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

		// SHIPPING ADDRESS
		assertTrue(checkout1.ShippingAddressFeild.isVisible(), "Shipping Address Feild is not displayed");
		checkout1.InStorePickup.check();
		assertTrue(checkout1.InStorePickup.isChecked(), "InStorePickup  Checkbox is not checked");
		checkout1.ContinueinShipping.click();

		// PAYMENT METHOD
		assertTrue(checkout1.PaymentMethodField.isVisible(), "PaymentMethodField page is not displayed");
		checkout1.CashOnDelivery.click();
		checkout1.ContinueInPaymentMethod.click();

		// PAYMENT INFORMATION
		assertTrue(checkout1.PaymentInformationField.isVisible(), "Payment information page is displayed");
		assertTrue(checkout1.CodText.isVisible(), "You will pay by cash on delivery message is not displayed");
		checkout1.ContinueInPaymentInformation.click();

		// CONFIRMATION ORDER
		assertTrue(checkout1.ConfirmOrderField.isVisible(), "Confirm Order Feild is not displayed");
		assertTrue(checkout1.BillingAddressText.isVisible(), "Billing  Address Text  is not displayed");
		checkout1.ConfirmInConfirmationOrder.click();

		// THANKYOU PAGE
		assertTrue(checkout1.ThankYouPage.isVisible(), "Thank you page is not displayed");
		assertTrue(checkout1.OrderNumber.isVisible(), "Order number 1315200 is not displayed");
		checkout1.ContinueInThankYouPage.click();
		assertTrue(checkout1.ApplicationHomePage.isVisible(), "Demo web shop home page is not displayed");
	}
}