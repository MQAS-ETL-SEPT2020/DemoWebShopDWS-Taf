package com.DemoWebShopapp.tests;

import java.util.Map;

import org.automation.base.BaseTest;
import org.automation.utilities.Configuration;
import org.testng.annotations.Test;

import com.DemoWebShopapp.pages.HomePageDWS;
import com.DemoWebShopapp.pages.LoginPageDWS;

/**
 * @author TYS-Megha D
 * 
 * @version 1.0.0
 * @since 14/11/2022
 *
 */
public class LoginDWSExecution extends BaseTest {

//reading data from config.properties
	@Test(dataProvider = "ExcelDataProvider")
	public void testLogin1(Map<String, String> data) {
		HomePageDWS home = new HomePageDWS();
		LoginPageDWS login = home.login.click(LoginPageDWS.class);
		login.email.enterText(Configuration.get("username"));
		login.password.enterText(Configuration.get("password"));
		login.loginButton.click(LoginPageDWS.class);

	}

//reading data from ExcelData.xlsx
	@Test(dataProvider = "ExcelDataProvider")
	public void testLogin2(Map<String, String> data) {
		HomePageDWS home = new HomePageDWS();
		LoginPageDWS login = home.login.click(LoginPageDWS.class);
		login.email.enterText(data.get("Username"));
		login.password.enterText(data.get("Password"));
		login = login.loginButton.click(LoginPageDWS.class);

	}

}
