package com.DemoWebShopapp.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Map;
import org.automation.base.BaseTest;
import org.testng.annotations.Test;
import com.DemoWebShopapp.pages.BooksPage;
import com.DemoWebShopapp.pages.CheckoutPage;
import com.DemoWebShopapp.pages.HomePageDWS;
import com.DemoWebShopapp.pages.LoginPageDWS;
/**
 * @author TYS-Tejaswini R
 * 
 * @version 1.0.0
 * @since 14/11/2022
 *
 */

public class BooksExecution extends BaseTest {
	@Test(dataProvider = "ExcelDataProvider")
	public void booksPageTest(Map<String, String> data) throws InterruptedException {

		HomePageDWS home = new HomePageDWS();
		LoginPageDWS login = home.login.click(LoginPageDWS.class);
		login.email.enterText(data.get("Username"));
		assertEquals(login.email.getAttributeValue("value"), data.get("Username_Assertion"),
				"Email is not entered into Email textfield");
		login.password.enterText(data.get("Password"));
		assertEquals(login.password.getAttributeValue("value"), data.get("Password_Assertion"),
				"password is not entered into password textfield");
		login = login.loginButton.click(LoginPageDWS.class);

		// Books
		BooksPage books = home.books.click(BooksPage.class);
		assertTrue(books.sortbyText.isVisible(), "by default sortby dropdown position is not selected");
		assertTrue(books.displaytext.isVisible(), "by default display dropdown 8 is not selected");
		assertTrue(books.viewastext.isVisible(), "by default viewas dropdown grid is not selected");
		books.computingandinternet.click();

		assertTrue(books.computingInternetPage.isVisible(), "not displaying computingInternet page");
		assertTrue(books.price.isVisible(), "price is not displayed");
		assertTrue(books.Quantity.isVisible(), "qunatity is not displayed");

		books.addtocart.click(BooksPage.class);
		assertTrue(books.confirmMessage.isVisible(), "Not displaying Confirmation Message");
		books.shoppingcart.click(BooksPage.class);
		assertTrue(books.shoppingcart.isVisible(), "Not displaying ShoppingCart Page ");

		assertTrue(books.termsOfServiceText.isVisible(), "Not displaying Terms Of Service Text");
		books.termsOfServiceCheckbox.check();
		assertTrue(books.termsOfServiceCheckbox.isChecked(), "Checkbox is not Checked");

		books.checkOut.click();

		// BILLING ADDRESS
		CheckoutPage checkout = new CheckoutPage();
		checkout.BillingAddressDropDown.selectByVisibleText(data.get("Dropdown Visible Text"));
		assertEquals(checkout.BillingAddressDropDown.getSelectedOption(), data.get("Assertion1"),
				"Incorrect option selected from dropdown");

		checkout.FirstName.enterText(data.get("FirstName"));
		assertEquals(checkout.FirstName.getAttributeValue("value"), data.get("Assertion2"),
				"FirstName is not entered into FirstName Text field");

		checkout.LastName.enterText(data.get("LastName"));
		assertEquals(checkout.LastName.getAttributeValue("value"), data.get("Assertion3"),
				"LastName is not entered into LastName Text field");

		checkout.Email.enterText(data.get("Email"));
		assertEquals(checkout.Email.getAttributeValue("value"), data.get("Assertion4"),
				"Email is not entered into Email Text field");

		checkout.CountryIdInBilling.selectByVisibleText(data.get("Country Dropdown Text"));
		assertEquals(checkout.CountryIdInBilling.getSelectedOption(), data.get("Assertion5"),
				"Incorrect option selected from dropdown");

		checkout.City.enterText(data.get("City"));
		assertEquals(checkout.City.getAttributeValue("value"), data.get("Assertion6"), "Incorrect City");

		checkout.Address1InBilling.enterText(data.get("Address1"));
		assertEquals(checkout.Address1InBilling.getAttributeValue("value"), data.get("Assertion7"),
				"Incorrect Address");

		checkout.ZipPostalCodeInBilling.enterText(data.get("Zip/Postal Code"));
		assertEquals(checkout.ZipPostalCodeInBilling.getAttributeValue("value"), data.get("Assertion8"),
				"Incorrect Zip/Postal Code");

		checkout.PhoneNumberInBilling.enterText(data.get("Phone Number"));
		assertEquals(checkout.PhoneNumberInBilling.getAttributeValue("value"), data.get("Assertion9"),
				"Incorrect phone number");
		checkout.ContinueInBilling.click();

		// SHIPPING ADDRESS
		assertTrue(checkout.ShippingAddressFeild.isVisible(), "Shipping Address Feild is not displayed");
		checkout.InStorePickup.check();
		assertTrue(checkout.InStorePickup.isChecked(), "InStorePickup  Checkbox is not checked");
		checkout.ContinueinShipping.click();

		assertTrue(checkout.PaymentMethodField.isVisible(), "PaymentMethodField page is not displayed");
		checkout.CashOnDelivery.click();
		checkout.ContinueInPaymentMethod.click();

		assertTrue(checkout.PaymentInformationField.isVisible(), "Payment information page is displayed");
		assertTrue(checkout.CodText.isVisible(), "You will pay by cash on delivery message is not displayed");
		checkout.ContinueInPaymentInformation.click();

		checkout.ConfirmInConfirmationOrder.click();
		assertTrue(checkout.ConfirmationMessage.isVisible(), "confirmation message is not displayed");

		assertTrue(checkout.ThankYouPage.isVisible(), "Thank you page is not displayed");
		assertTrue(checkout.OrderNumber.isVisible(), "Order number 1315200 is not displayed");
		checkout.ContinueInThankYouPage.click();
		assertTrue(checkout.ApplicationHomePage.isVisible(), "Demo web shop home page is not displayed");
	}
}
