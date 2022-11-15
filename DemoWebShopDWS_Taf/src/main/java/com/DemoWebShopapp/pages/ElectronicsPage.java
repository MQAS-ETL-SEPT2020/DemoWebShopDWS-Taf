package com.DemoWebShopapp.pages;

import org.automation.base.BasePage;
import org.automation.elements.Button;
import org.automation.elements.CheckBox;
import org.automation.elements.DropDown;
import org.automation.elements.HyperLink;
import org.automation.elements.TextBox;
import org.openqa.selenium.By;
/***
 * 
 * @author TYS-AnilKumar SM
 * @version 1.0.0
 * @since 14/11/2022
 *
 */
public class ElectronicsPage extends BasePage {

	public final HyperLink Electronics = new HyperLink("Electronics button",
			By.xpath("(//a[contains(text(),'Cell phones')])[4]"));
	public final org.automation.elements.Element electronicsPage=new org.automation.elements.Element("electronicspage", By.xpath("//h1[text()='Electronics']"));
	public final DropDown SortBy = new DropDown("SortBy DropDown", By.id("products-orderby"));
	public final DropDown SortbyPosition=new DropDown("SortbyPosition DropDown",By.xpath("//option[text()='Position']"));
	public final DropDown SortbyAtoZ=new DropDown("SortbyAtoZ DropDown",By.xpath("//option[text()='Name: A to Z']"));
	public final DropDown SortbyZtoA=new DropDown("SortbyZtoA DropDown", By.xpath("Name: Z to A"));
	public final DropDown SortbyPriceLowToHigh=new DropDown("SortbyPriceLowToHigh DropDown", By.xpath("//option[text()='Price: Low to High']"));
	public final DropDown SortbyHighLowToLow=new DropDown("SortbyHighLowToLow DropDown", By.xpath("//option[text()='Price: High to Low']"));
	public final DropDown CreatedOn=new DropDown("CreatedOn DropDown", By.xpath("//option[text()='Created on']"));
	
	public final DropDown Display = new DropDown("Display DropDown", By.id("products-pagesize"));
	public final DropDown Display8PerPage = new DropDown("Display8PerPage DropDown", By.xpath("//option[text()='8']"));
	public final DropDown Display4PerPage = new DropDown("Display4PerPage DropDown", By.xpath("//option[text()='4']"));
	public final DropDown Display12PerPage = new DropDown("Display12PerPage DropDown", By.xpath("//option[text()='12']"));

	
	
	public final DropDown viewAs = new DropDown("ViewAs DropDown", By.id("products-viewmode"));
	public final DropDown viewAsGrid = new DropDown("viewAsGrid DropDown", By.xpath("//option[text()='Grid']"));
	public final DropDown viewAsList = new DropDown("viewAsList DropDown", By.xpath("//option[text()='List']"));
    
	public final HyperLink cellphones=new HyperLink("cellphones link", By.xpath("//h2[@class='title']//a[contains(text(),'Cell phones')]"));
	public final HyperLink Smartphone = new HyperLink("Smartphone link", By.xpath("//h2[@class='product-title']//a[text()='Smartphone']"));
	public final TextBox Qty = new TextBox("Qty Textbox", By.id("addtocart_43_EnteredQuantity"));
	public final Button AddToCart = new Button("AddToCart Button",
			By.xpath("//input[@class='button-1 add-to-cart-button']"));
	public final HyperLink ShoppingCart = new HyperLink("ShoppingCart Button",
			By.xpath("//span[text()='Shopping cart']"));
	public final org.automation.elements.Element confmsg = new org.automation.elements.Element("confmsg",
			By.xpath("//p[@class='content']"));
	public final DropDown CountryId = new DropDown("CountryId DropDown", By.xpath("//select[@id='CountryId']"));
	public final DropDown StateOrProvince = new DropDown("StateOrProvince DropDown",
			By.xpath("//select[@id='StateProvinceId']"));
	public final DropDown PostalCode = new DropDown("PostalCode DropDown", By.xpath("//input[@id='ZipPostalCode']"));
	public final CheckBox TermsAndService = new CheckBox("TermsAndService DropDown",
			By.xpath("//input[@id='termsofservice']"));
	public final Button CheckOutbutton = new Button("CheckOut Button", By.xpath("//button['checkout']"));
   
}
