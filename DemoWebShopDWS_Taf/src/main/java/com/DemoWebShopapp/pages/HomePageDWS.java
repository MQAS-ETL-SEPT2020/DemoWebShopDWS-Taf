package com.DemoWebShopapp.pages;

import org.automation.base.BasePage;
import org.automation.elements.Button;
import org.automation.elements.HyperLink;
import org.automation.utilities.Configuration;
import org.openqa.selenium.By;

public class HomePageDWS extends BasePage {
	public HomePageDWS() {
		super.openUrl(Configuration.get("url"));
	}

	public final HyperLink login = new HyperLink("Login link", By.xpath("//a[text()='Log in']"));

	public final Button books = new Button("Books Button", By.xpath("(//a[contains(text(),'Books')])[1]"));
	public final Button computers = new Button("Computers button", By.xpath("(//a[contains(text(),'Computers')])[1]"));
	public final Button electronics = new Button("Electronics", By.xpath("(//a[contains(text(),'Electronics')])[1]"));
	public final Button apparelAndShoes = new Button("ApparelAndShoes",
			By.xpath("(//a[contains(text(),'Apparel & Shoes')])[1]"));
	public final Button digitalDownloads = new Button("Digital Downloads",
			By.xpath("(//a[contains(text(),'Digital downloads')])[1]"));
	public final Button jewellery = new Button("Jewellery", By.xpath("(//a[contains(text(),'Jewelry')])[1]"));
	public final Button giftCards = new Button("Gift Cards", By.xpath("(//a[contains(text(),'Gift Cards')])[1]"));

}
