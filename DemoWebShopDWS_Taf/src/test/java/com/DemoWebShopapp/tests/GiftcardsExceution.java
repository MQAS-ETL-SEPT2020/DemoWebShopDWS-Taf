package com.DemoWebShopapp.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Map;
import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.testng.annotations.Test;
import com.DemoWebShopapp.pages.CheckoutPage;
import com.DemoWebShopapp.pages.GiftcardsPage;
import com.DemoWebShopapp.pages.HomePageDWS;
import com.DemoWebShopapp.pages.LoginPageDWS;

/**
 * 
 * @author Achyut
 * @version 1.00 Date 14/11/2022
 */
public class GiftcardsExceution extends BaseTest {

	@Test(dataProvider = "ExcelDataProvider")
	public void Giftcards(Map<String, String> data) throws InterruptedException, AWTException {

		// To Read the Data from Excel
		// entering the url and logging into the application
		HomePageDWS home = new HomePageDWS();
		LoginPageDWS login = home.login.click(LoginPageDWS.class);
		assertTrue(login.email.isVisible(), "Not Clicking on Login Link");
		assertTrue(login.password.isVisible(), "Not Clicking on Login Link");
		assertTrue(login.loginButton.isVisible(), "Not Clicking on Login Link");

		// Entering the Email and Password in Login Page
		login.email.enterText(data.get("Username"));
		Log.info("Entering the Email into the Email Textfeild");
		assertEquals(login.email.getAttributeValue("value"), data.get("Username_Assertion"),
				"Email is not entered in Email Textfeild");

		login.password.enterText(data.get("Password"));
		Log.info("Entering the password into the password Textfeild");
		assertEquals(login.password.getAttributeValue("value"), data.get("Password_Assertion"),
				"Password is not entered into the Password Textfeild");

		// Clicking the Login Button in Login Page
		login.loginButton.click(LoginPageDWS.class);
		HomePageDWS homepage = new HomePageDWS();
		assertTrue(homepage.books.isVisible(), "Not Clicking on Login Button");
		assertTrue(homepage.computers.isVisible(), "Not Clicking on Login Button");
		assertTrue(homepage.electronics.isVisible(), "Not Clicking on Login Button");
		assertTrue(homepage.apparelAndShoes.isVisible(), "Not Clicking on Login Button");
		assertTrue(homepage.digitalDownloads.isVisible(), "Not Clicking on Login Button");
		assertTrue(homepage.jewellery.isVisible(), "Not Clicking on Login Button");
		assertTrue(homepage.giftCards.isVisible(), "Not Clicking on Login Button");

		// Clicking on The Gift cards Menu in Giftcards Page
		home.giftCards.click();
		Log.info("Clicking on Giftcards Menu");
		GiftcardsPage giftspage = new GiftcardsPage();
		assertTrue(giftspage.SortBy_Dropdown.isVisible(), "Not Clicking on Giftcards Menu");
		assertTrue(giftspage.DisplayPerPage_Dropdown.isVisible(), "Not Clicking on Giftcards Menu");
		assertTrue(giftspage.ViewAs_Dropdown.isVisible(), "Not Clicking on Giftcards Menu");

		// Click on the $25 VirtualGiftcard Product Link
		giftspage.VirtualGiftcard_ProductLink.click();
		Log.info("Clicking on the product");
		assertTrue(giftspage.VirtualGiftcardProduct_Text.isVisible(), "Not Clicking on Product link");
		assertTrue(giftspage.TwentyFive_Text.isVisible(), "$25 price is not visible");

		// Entering the Reciepents Name and Reciepents Email in the $25 VirtualGiftcard
		// Product Page
		giftspage.ReciepientsName_Textfeild.enterText(data.get("ReciepientsName"));
		Log.info("Entering the data into ReciepientsName_Textfeild");
		assertEquals(giftspage.ReciepientsName_Textfeild.getAttributeValue("value"), data.get("Assertion10"),
				"Recipents Name is not entered in the Recipents Name Textfeild");

		giftspage.ReciepentsMail_Textfeild.enterText(data.get("ReciepientsEmail"));
		Log.info("Entering the data into ReciepientsMail_Textfeild");
		assertEquals(giftspage.ReciepentsMail_Textfeild.getAttributeValue("value"), data.get("Assertion11"),
				"Recipents Email is not entered in the Recipents Email Textfeild");

		giftspage.Message_TextareaFeild.enterText("Never Give up");
		Log.info("Entering the data into Message Textareafeild");

		// Clicking on the Add to cart Button
		giftspage.Addtocart_Button.click();
		Log.info("Clicking on Add to cart Button");
		assertTrue(giftspage.AddedToCart_Message.isVisible(), "Not Clicking on Add to cart Button");

		// Moving the WebPage Up
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_PAGE_UP);
		robo.keyRelease(KeyEvent.VK_PAGE_UP);
		Log.info("Moving the page up");

		giftspage.Crossmark.click();
		Log.info("Clicking on cross mark of the message");
		assertTrue(giftspage.ShoppingCart_Link.isVisible(), "Not Clicking on Cross mark");

		// Clicking on the Shopping Cart Link
		giftspage.ShoppingCart_Link.click();
		Log.info("Clicking on the Shopping Cart Link");
		assertTrue(giftspage.Checkout_Button.isVisible(), "Not Clicking on Shopping Cart Link");

		// Clicking on I Agree Checkbox
		giftspage.Iagree_Checkbox.check();
		Log.info("Clicking on I agree checkbox");
		assertTrue(giftspage.Iagree_Checkbox.isChecked(), "I agree checkbox is checked");

		// Clicking on the Checkout Button
		giftspage.Checkout_Button.click();
		Log.info("Clicking on Checkout Button");
		CheckoutPage checkout = new CheckoutPage();
		assertTrue(checkout.CheckoutPage.isVisible(), "Not Clicking on Checkout Button");

		// Selecting the Option in Billing Address Option in Checkout Page
		checkout.BillingAddressDropDown.selectByVisibleText(data.get("Dropdown Visible Text"));
		Log.info("Selecting the option in Billing Address Dropdown");
		assertEquals(checkout.BillingAddressDropDown.getSelectedOption(), data.get("Assertion1"),
				"Not Clicking on Billing Address option");

		// Entering the FirstName in FirstName Textfeild
		checkout.FirstName.enterText(data.get("FirstName"));
		Log.info("Entering the data into the FirstName Textfeild");
		assertEquals(checkout.FirstName.getAttributeValue("value"), data.get("Assertion2"),
				"FirstName is not entered into the Firstname Textfeild");

		// Entering the LastName in LastName Textfeild
		checkout.LastName.enterText(data.get("LastName"));
		Log.info("Entering the data into the LastName Textfeild");
		assertEquals(checkout.LastName.getAttributeValue("value"), data.get("Assertion3"),
				"LastName is not entered into the Lastname Textfeild");

		// Entering the Email in Email Textfeild
		checkout.Email.enterText(data.get("Email"));
		Log.info("Entering the data into the Email Textfeild");
		assertEquals(checkout.Email.getAttributeValue("value"), data.get("Assertion4"),
				"Email is not entered into the Email Textfeild");

		// Selecting the Country in Country Dropdown
		checkout.CountryIdInBilling.selectByVisibleText(data.get("Country Dropdown Text"));
		Log.info("selecting the option in Country Dropdown");
		assertEquals(checkout.CountryIdInBilling.getSelectedOption(), data.get("Assertion5"),
				"Selected option is not selected");

		// Entering the City in City Textfeild
		checkout.City.enterText(data.get("City"));
		Log.info("Entering the data into the City Textfeild");
		assertEquals(checkout.City.getAttributeValue("value"), data.get("Assertion6"),
				"City is not entered into the City Textfeild");

		// Entering the Address in Address1 Textfeild
		checkout.Address1InBilling.enterText(data.get("Address1"));
		Log.info("Entering the data into the Address1 Textfeild");
		assertEquals(checkout.Address1InBilling.getAttributeValue("value"), data.get("Assertion7"),
				"Address1 is not entered into the Address1 Textfeild");

		// Entering the Zip/Postal Code in Zip/Postal Textfeild
		checkout.ZipPostalCodeInBilling.enterText(data.get("Zip/Postal Code"));
		Log.info("Entering the data into the Zip/Postalcode Textfeild");
		assertEquals(checkout.ZipPostalCodeInBilling.getAttributeValue("value"), data.get("Assertion8"),
				"Zip/PostalCodeinBilling is not entered into the Zip/PostalCodeinBilling Textfeild");

		// Entering the PhoneNumber in PhoneNumber Textfeild
		checkout.PhoneNumberInBilling.enterText(data.get("Phone Number"));
		Log.info("Entering the data into the Phone Number Textfeild");
		assertEquals(checkout.PhoneNumberInBilling.getAttributeValue("value"), data.get("Assertion9"),
				"Phone Number is not entered into the Phone Number Textfeild");

		// Clicking Continue Button in Billing Address Page
		checkout.ContinueInBilling.click(CheckoutPage.class);
		Log.info("Clicking on Continue Button in Billing Address page");
		assertTrue(checkout.CashOnDelivery.isVisible(), "Not Clicking on the Continue Button in Shipping Address ");
		assertTrue(checkout.CheckMoneyOrder.isVisible(), "Not Clicking on the Continue Button in Shipping Address ");
		assertTrue(checkout.PurchaseOrder.isVisible(), "Not Clicking on the Continue Button in Shipping Address ");
		assertTrue(checkout.CreditCard.isVisible(), "Not Clicking on the Continue Button in Shipping Address ");

		// Clicking on the Continue Button in Payment Method
		checkout.ContinueInPaymentMethod.click();
		Log.info("Clicking on the Continue button in payment method");
		assertTrue(checkout.CodText.isVisible(), "Not Clicking on the Continue Button in Payment Method");

		// Clicking on the Continue Button in Payment Information Page
		checkout.ContinueInPaymentInformation.click(CheckoutPage.class);
		Log.info("Clicking on the Continue Button in Payment Information");
		assertTrue(checkout.PaymentmethodText.isVisible(),
				"Not Clicking on the Continue Button in Payment Information");
		assertTrue(checkout.BillingAddressText.isVisible(),
				"Not Clicking on the Continue Button in Payment Information");
		assertTrue(checkout.ConfirmOrderField.isVisible(),
				"Not Clicking on the Continue Button in Payment Information ");
		assertTrue(checkout.ConfirmInConfirmationOrder.isVisible(),
				"Not Clicking on the Continue Button in Payment Information");

		// Clicking on the Confirm Button
		checkout.ConfirmInConfirmationOrder.click(CheckoutPage.class);
		Log.info("Clicking on the Confirm Button");
		assertTrue(checkout.ThankYouPage.isVisible(), "Not Clicking on the Confirm Button ");
		assertTrue(checkout.ConfirmationMessage.isVisible(), "Not Clicking on the Confirm Button ");
		assertTrue(checkout.OrderNumber.isVisible(), "Not Clicking on the Confirm Button");
		assertTrue(checkout.ContinueInThankYouPage.isVisible(), "Not Clicking on the Confirm Button");

		// Clicking on the Continue Button in Thank you Page
		checkout.ContinueInThankYouPage.click(CheckoutPage.class);
		Log.info("Clicking on the Continue Button in Thank you page");
		assertTrue(checkout.ApplicationHomePage.isVisible(), "Not Clicking on the Continue Button in Thank you page");

	}
}