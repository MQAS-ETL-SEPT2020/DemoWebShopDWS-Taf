package com.DemoWebShopapp.pages;

	import org.automation.base.BasePage;
	import org.automation.elements.Button;
	import org.automation.elements.TextBox;
	import org.openqa.selenium.By;

	public class LoginPageDWS extends BasePage {

		public final TextBox email = new TextBox("Email", By.id("Email"));
		public final TextBox password = new TextBox("Password", By.id("Password"));
		public final Button loginButton = new Button("Login", By.xpath("//input[@class='button-1 login-button']"));

}
