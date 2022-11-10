package com.DemoWebShopapp.pages;

import org.automation.base.BasePage;
import org.automation.elements.Button;
import org.automation.elements.CheckBox;
import org.automation.elements.DropDown;
import org.automation.elements.HyperLink;
import org.automation.elements.RadioButton;
import org.automation.elements.TextBox;
import org.openqa.selenium.By;

public class ComputerPage extends BasePage {
	public final Button desktops = new Button("desktops button", By.xpath("(//a[contains(text(),'Desktops')])[4]"));
	public final HyperLink computertext = new HyperLink("computertext Button", By.xpath("//h1[text()='Computers']"));
	public final DropDown Sortby = new DropDown("Sortby button", By.id("products-orderby"));
	public final DropDown SortbyText = new DropDown("SortbyText Button", By.xpath("//span[text()='Sort by']"));

	public final DropDown Display = new DropDown("Display Dropdown", By.id("products-pagesize"));
	public final DropDown DisplayText = new DropDown("Display DropDown", By.xpath("//span[text()='Display']"));
	public final DropDown ViewAs = new DropDown("ViewAs DropDown", By.id("products-viewmode"));
	public final DropDown ViewAsText = new DropDown("ViewAs DropDown", By.xpath("//span[text()='View as']"));
	public final Button computer = new Button("computer link", By.xpath("(//h2[@class='product-title'])[3]"));
	public final HyperLink ExpensivecomputerText = new HyperLink("expensivecomputer HyperLink",
			By.xpath("//h1[@itemprop='name']"));
	public final RadioButton Processor = new RadioButton("Processor RadioButton",
			By.xpath("//label[text()='Medium  [+15.00]']"));
	public final RadioButton RAM = new RadioButton("RAM RadioButton", By.xpath("//label[text()='2 GB ']"));
	public final RadioButton HDD = new RadioButton("HDD RadioButton", By.xpath("//label[text()='320 GB ']"));
	public final RadioButton Softwares = new RadioButton("Softwares RadioButton",
			By.xpath("//label[text()='Image Viewer  [+5.00]']"));
	public final TextBox Quality = new TextBox("Quality TextBox", By.id("addtocart_74_EnteredQuantity"));
	public final Button AddtoCart = new Button("AddtoCart Button", By.id("add-to-cart-button-74"));
	public final TextBox message = new TextBox("message TextBox", By.xpath("//p[@class='content']"));
	public final HyperLink shoppingcart = new HyperLink("shopping HyperLink", By.xpath("(//a[@class='ico-cart'])[1]"));
	public final TextBox shoppingcartText = new TextBox("shoppingcartText ",
			By.xpath("//span[text()='Shopping cart']"));
	public final CheckBox Terms = new CheckBox("Terms", By.xpath("//input[@id='termsofservice']"));
	public final Button checkout = new Button("checkout", By.xpath("//button[@id='checkout']"));

}
