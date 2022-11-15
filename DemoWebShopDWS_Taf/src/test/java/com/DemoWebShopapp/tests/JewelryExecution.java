//package com.DemoWebShopapp.tests;
	package com.DemoWebShopapp.tests;
	import static org.testng.Assert.assertEquals;
	import static org.testng.Assert.assertTrue;
	//import static org.testng.Assert.assertTrue;
	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.util.Map;
	//import java.util.Map;
	//import org.automation.base.BasePage;
	import org.automation.base.BaseTest;
	import org.automation.config.DriverType;
	import org.automation.elements.Alert;
	import org.automation.logger.Log;
	import org.automation.utilities.Configuration;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Action;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	//import org.automation.utilities.Configuration;
	import org.testng.annotations.Test;
	import com.DemoWebShopapp.pages.CheckoutPage;
	import com.DemoWebShopapp.pages.HomePageDWS;
	import com.DemoWebShopapp.pages.JewelryPage;
	import com.DemoWebShopapp.pages.LoginPageDWS;

	/**
	 * 
	 * @author TYS-Vanishree
	 * @version 1.0.0
	 * @since 14/11/2022
	 *
	 */
	public class JewelryExecution extends BaseTest {
//			@Test
		// public void Jewelrypagetest() throws InterruptedException, AWTException {

//				
//				HomePageDWS home=new HomePageDWS();
//				LoginPageDWS login = home.login.click(LoginPageDWS.class);
//				login.email.enterText(Configuration.get("username"));
//				login.password.enterText(Configuration.get("password"));
//				login.loginButton.click(LoginPageDWS.class);
		@Test(dataProvider = "ExcelDataProvider")
		public void checkout(Map<String, String> data) throws InterruptedException, AWTException {
			
			// Home Page
			HomePageDWS home = new HomePageDWS();
			
			// login Page
			LoginPageDWS login = home.login.click(LoginPageDWS.class);
            assertTrue(login.email.isVisible(), "Not  clicking on Login link");
			assertTrue(login.password.isVisible(), "Not clicking on Login Link");
			assertTrue(login.loginButton.isVisible(), "Not clicking on Login Link");
			login.email.enterText(data.get("Username"));
			Log.info("Entering  the Email into the Email Textfield");
			assertEquals(login.email.getAttributeValue("value"), data.get("Username_Assertion"),
					"Email is not entered into the Email");
			login.password.enterText(data.get("Password"));
			Log.info("Entering the Email into the Password Textfield");
			assertEquals(login.password.getAttributeValue("value"), data.get("Password_Assertion"),
					"Password is not entered into the Email");
            login = login.loginButton.click(LoginPageDWS.class);

			HomePageDWS homepage = new HomePageDWS();
			assertTrue(homepage.books.isVisible(), "Not clicking on Login Button");
			assertTrue(homepage.computers.isVisible(), "Not clicking on Login Button");
			assertTrue(homepage.electronics.isVisible(), "Not clicking on Login Button");
			assertTrue(homepage.apparelAndShoes.isVisible(), "Not clicking on login button");
			assertTrue(homepage.digitalDownloads.isVisible(), "Not clicking on Login Button");
			assertTrue(homepage.jewellery.isVisible(), "Not clicking on login button");
			assertTrue(homepage.giftCards.isVisible(), "Not clicking on Login Button");
             
			//JewelryPage
			JewelryPage jewel = home.jewellery.click(JewelryPage.class);
			assertTrue(jewel.jewelText.isVisible(), "Jewelry Page is not displayed");
			assertTrue(jewel.sortby.isVisible(), "By default position is not displayed");
			assertTrue(jewel.display.isVisible(), "By default 8 is not displayed");
			assertTrue(jewel.viewas.isVisible(), "By default Grid is not displayed");
			jewel.link.click();

			assertTrue(jewel.BlackandWhiteDiamond.isVisible(), "product page is not displayed");
			jewel.add.click();

			assertTrue(jewel.cartpop.isVisible(), "Addtocart popup msg is not displaying");
			Robot rbt = new Robot();
			rbt.keyPress(KeyEvent.VK_UP);
			rbt.keyRelease(KeyEvent.VK_UP);
			Thread.sleep(2000);
			Thread.sleep(2000);
			jewel.shoplink.click();
			assertTrue(jewel.shoppingpage.isVisible(), "Shoppingpage is not displaying");

			jewel.Terms.check();
			// assertTrue(jewel.termsandcond.isChecked(), "Checkbox is not Checked");
			jewel.checkout.click();
             
			//CheckoutPage
			CheckoutPage checkout1 = new CheckoutPage();
			 assertTrue(checkout1.CheckoutPage.isVisible(), "Checkoutpage is not displayed");
			 
			//BillingAddressPage  
			checkout1.BillingAddressDropDown.selectByVisibleText(data.get("Dropdown Visible Text"));
			// assertTrue(checkout1.);
			assertEquals(checkout1.BillingAddressDropDown.getSelectedOption(), data.get("Assertion1"),
					"Incorrect option selected from dropdown");
			
			checkout1.FirstName.enterText(data.get("FirstName"));
			Log.info("Entering  the FirstName into the FirstName Textfield");
			assertEquals(checkout1.FirstName.getAttributeValue("value"), data.get("Assertion2"),
					"FirstName is not entered into the FirstName Textfield");
			checkout1.LastName.enterText(data.get("LastName"));
			Log.info("Entering  the LastName into the LastName Textfield");
			assertEquals(checkout1.LastName.getAttributeValue("value"), data.get("Assertion3"),
					"LastName is not entered into the LastName Textfield");
			checkout1.Email.enterText(data.get("Email"));
			Log.info("Entering  the Email into the Email Textfield");
			assertEquals(checkout1.Email.getAttributeValue("value"), data.get("Assertion4"),
					"Email is not entered into the LastName Textfield");
			checkout1.CountryIdInBilling.selectByVisibleText(data.get("Country Dropdown Text"));
			assertEquals(checkout1.CountryIdInBilling.getSelectedOption(), data.get("Assertion5"),
					"Incorrect option selected from dropdown");
			checkout1.City.enterText(data.get("City"));
			assertEquals(checkout1.City.getAttributeValue("value"), data.get("Assertion6"), "Incorrect City");
			checkout1.Address1InBilling.enterText(data.get("Address1"));
			assertEquals(checkout1.Address1InBilling.getAttributeValue("value"), data.get("Assertion7"),
					"Incorrect Address1");
			checkout1.ZipPostalCodeInBilling.enterText(data.get("Zip/Postal Code"));
			assertEquals(checkout1.ZipPostalCodeInBilling.getAttributeValue("value"), data.get("Assertion8"),
					"Incorrect Zip/Postal Code");
			checkout1.PhoneNumberInBilling.enterText(data.get("Phone Number"));
			assertEquals(checkout1.PhoneNumberInBilling.getAttributeValue("value"), data.get("Assertion9"),
					"Incorrect Phone Number");
			assertTrue(checkout1.ContinueInBilling.isEnabled(), "Continue In Billing is  disabled");
			checkout1.ContinueInBilling.click();
            
			//ShippingAddressPage
			assertTrue(checkout1.ShippingAddressFeild.isVisible(), "Shipping Address Feild is not displayed");
			checkout1.InStorePickup.check();
			assertTrue(checkout1.InStorePickup.isChecked(), "InStorePickup  Checkbox is not checked");
			checkout1.ContinueinShipping.click();

			// Payment Method
			assertTrue(checkout1.PaymentMethodField.isVisible(), "Payment Method Feild is not displayed");
			checkout1.CheckMoneyOrder.click();
			assertTrue(checkout1.ContinueInPaymentMethod.isEnabled(), "Continue In Payment Method is  disabled");
			checkout1.ContinueInPaymentMethod.click();

			// Payment Information
			assertTrue(checkout1.PaymentInformationField.isVisible(), "Payment Information Feild is not displayed");
			assertTrue(checkout1.ContinueInPaymentInformation.isEnabled(), "Continue In Payment Information  is  disabled");
			checkout1.ContinueInPaymentInformation.click();

			// Confirmation Order
			assertTrue(checkout1.ConfirmOrderField.isVisible(), "Confirm Order Feild is not displayed");
			assertTrue(checkout1.BillingAddressText.isVisible(), "Billing  Address Text  is not displayed");
			assertTrue(checkout1.ConfirmInConfirmationOrder.isEnabled(), "Confirm In ConfirmationOrder is  diasbled");
			checkout1.ConfirmInConfirmationOrder.click();

			// ThankYou Page
			assertTrue(checkout1.ThankYouPage.isVisible(), "ThankYouPage is not displayed");
			assertTrue(checkout1.OrderNumber.isVisible(), "OrderNumber is not displayed");
			assertTrue(checkout1.ConfirmationMessage.isVisible(), "ConfirmationMessage is not displayed");
			assertTrue(checkout1.ContinueInThankYouPage.isEnabled(), "Continue In ThankYouPage is  disabled");
			checkout1.ContinueInThankYouPage.click();
			assertTrue(checkout1.ApplicationHomePage.isVisible(), "Application HomePage is displayed");

		}

	}



