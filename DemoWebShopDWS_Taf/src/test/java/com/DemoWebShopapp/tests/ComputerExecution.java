package com.DemoWebShopapp.tests;

import static org.testng.Assert.assertTrue;
import java.util.Map;
import org.automation.base.BaseTest;
import org.testng.annotations.Test;
import com.DemoWebShopapp.pages.CheckoutPage;
import com.DemoWebShopapp.pages.ComputerPage;
import com.DemoWebShopapp.pages.HomePageDWS;
import com.DemoWebShopapp.pages.LoginPageDWS;

public class ComputerExecution extends BaseTest {

	@Test(dataProvider = "ExcelDataProvider")

	public void checkout(Map<String, String> data) throws InterruptedException {
//		HomePageDWS home = new HomePageDWS();
//		LoginPageDWS login = home.login.click(LoginPageDWS.class);
//		login.email.enterText(Configuration.get("username"));
//		login.password.enterText(Configuration.get("password"));
//		login.loginButton.click(LoginPageDWS.class);

		HomePageDWS home = new HomePageDWS();
		LoginPageDWS login = home.login.click(LoginPageDWS.class);
		login.email.enterText(data.get("Username"));
		login.password.enterText(data.get("Password"));
		login = login.loginButton.click(LoginPageDWS.class);

		ComputerPage computer = home.computers.click(ComputerPage.class);
		assertTrue(computer.computertext.isVisible(), "computer page is not displayed");
		computer.desktops.click();
		assertTrue(computer.SortbyText.isVisible(), "By default Sortby dropdown is not selected as Position ");
		assertTrue(computer.DisplayText.isVisible(), "By default Display per page dropdown is not selected as 8 ");
		assertTrue(computer.ViewAsText.isVisible(), "By default ViewAs dropdown is not selected as Grid ");
		computer.computer.click();
		assertTrue(computer.ExpensivecomputerText.isVisible(), "By default Expensivecomputer page  is not displayed");
		assertTrue(computer.Processor.isVisible(), "By default Processor is not selected as  Medium [+15.00]");
		assertTrue(computer.RAM.isVisible(), "By default Ram is not selected as 2GB");
		computer.Softwares.click();
		assertTrue(computer.Quality.isVisible(), "By default Quality will be 1");
		computer.AddtoCart.click();
//		assertTrue(computer.message.isVisible(),"The product is added to cart message is not displayed");
		computer.shoppingcart.click();
		assertTrue(computer.shoppingcartText.isVisible(), "shopping cart page is not displayed");
		computer.Terms.check();
		computer.checkout.click();

//	@Test(dataProvider = "ExcelDataProvider")
//	public void checkout(Map<String, String> data) throws InterruptedException {
		CheckoutPage checkout1 = new CheckoutPage();
		assertTrue(checkout1.CheckoutPage.isVisible(), "Checkoutpage is not displayed");
		Thread.sleep(2000);
		;
		checkout1.BillingAddressDropDown.selectByVisibleText(data.get("Dropdown Visible Text"));
		checkout1.FirstName.enterText(data.get("FirstName"));
		checkout1.LastName.enterText(data.get("LastName"));
		checkout1.Email.enterText(data.get("Email"));
		checkout1.CountryIdInBilling.selectByVisibleText(data.get("Dropdown Value"));
		checkout1.City.enterText("City");
		checkout1.Address1InBilling.enterText(data.get("Address1"));
		checkout1.ZipPostalCodeInBilling.enterText(data.get("Zip/Postal Code"));
		checkout1.PhoneNumberInBilling.enterText(data.get("Phone Number"));
		checkout1.ContinueInBilling.click();
		checkout1.InStorePickup.check();
//    Thread.sleep(2000);
		checkout1.ContinueinShipping.click();

		assertTrue(checkout1.PaymentMethodField.isVisible(), "PaymentMethodField page is not displayed");
		checkout1.CashOnDelivery.click();
		checkout1.ContinueInPaymentMethod.click();

		assertTrue(checkout1.PaymentInformationField.isVisible(), "Payment information page is displayed");
		assertTrue(checkout1.CodText.isVisible(), "You will pay by cash on delivery message is not displayed");
		checkout1.ContinueInPaymentInformation.click();

		checkout1.ConfirmInConfirmationOrder.click();
		assertTrue(checkout1.ConfirmationMessage.isVisible(), "confirmation message is not displayed");

		assertTrue(checkout1.ThankYouPage.isVisible(), "Thank you page is not displayed");
		assertTrue(checkout1.OrderNumber.isVisible(), "Order number 1315200 is not displayed");
		checkout1.ContinueInThankYouPage.click();
		assertTrue(checkout1.ApplicationHomePage.isVisible(), "Demo web shop home page is not displayed");
	}
}