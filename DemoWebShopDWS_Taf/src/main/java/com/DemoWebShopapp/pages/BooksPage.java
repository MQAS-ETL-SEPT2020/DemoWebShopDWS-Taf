package com.DemoWebShopapp.pages;

import org.automation.base.BasePage;
import org.automation.elements.Button;
import org.automation.elements.CheckBox;
import org.automation.elements.DropDown;
import org.automation.elements.Element;
import org.automation.elements.HyperLink;
import org.openqa.selenium.By;

public class BooksPage extends BasePage {

	public final DropDown sortby = new DropDown("sortby", By.id("products-orderby"));
	public final DropDown sortbyText = new DropDown("sortbyText", By.xpath("//option[text()='Position']"));
	public final DropDown display = new DropDown("display", By.id("products-pagesize"));
	public final DropDown displaytext = new DropDown("displaytext", By.xpath("//option[text()='8']"));
	public final DropDown viewas = new DropDown("viewas", By.id("products-viewmode"));
	public final DropDown viewastext = new DropDown("viewastext", By.xpath("//option[text()='Grid']"));
	public final HyperLink computingandinternet = new HyperLink("computingInternet",
			By.linkText("Computing and Internet"));
	public final Element computingInternetPage = new Element("computingandInternet",
			By.xpath("//div[@class='product-name']"));
	public final Element price = new Element("price", By.xpath("//div[@class='product-price']"));
	public final Element Quantity = new Element("Quantity", By.xpath("//label[@class='qty-label']"));
	public final Button addtocart = new Button("addtocart", By.id("add-to-cart-button-13"));
	public final Element confirmMessage = new Element("confirmMessage",
			By.xpath("//p[contains(text(),'The product has been added to your ')]"));
	public final HyperLink shoppingcart = new HyperLink("shoppingcart", By.linkText("Shopping cart"));
	public final DropDown Country = new DropDown("country", By.id("CountryId"));
	public final DropDown selectedCountry = new DropDown("selectedcountry", By.linkText("India"));
	public final DropDown State = new DropDown("state", By.id("StateProvinceId"));
	public final DropDown selectedState = new DropDown("selectedstate", By.linkText("Other (Non US)"));
	public final Element Postalcode = new Element("postalcode", By.xpath("//label[@for='ZipPostalCode']"));
	public final Element zipcode = new Element("zipcode", By.id("ZipPostalCode"));
	public final Element termsOfServiceText = new Element("Terms Of Service",
			By.xpath("//div[@class='terms-of-service']"));
	public final CheckBox termsOfServiceCheckbox = new CheckBox("Terms of Service CheckBox", By.id("termsofservice"));
	public final Button checkOut = new Button("CheckOut button", By.id("checkout"));

}
