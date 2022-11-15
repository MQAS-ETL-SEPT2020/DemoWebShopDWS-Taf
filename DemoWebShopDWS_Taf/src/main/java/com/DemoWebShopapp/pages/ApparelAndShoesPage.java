package com.DemoWebShopapp.pages;

import org.automation.base.BasePage;
import org.automation.base.BaseTest;
import org.automation.elements.Button;
import org.automation.elements.CheckBox;
import org.automation.elements.DropDown;
import org.automation.elements.Element;
import org.automation.elements.HyperLink;
import org.automation.elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
	/**
	 * 
	 * @author TYS-Priyanka G M
	 * @version 1.0.0
	 * @since 14/11/2022
	 *
	 */


public class ApparelAndShoesPage extends BasePage{
	public final Element apparelandshoestext=new Element("ApparelandshoesText", By.xpath("//h1[text()='Apparel & Shoes']"));
	public final DropDown sortby=new DropDown("SortBy DropDown", By.xpath("//select[@id='products-orderby']"));
	public final Element sortbytext=new Element("SortbyText",  By.xpath("//span[text()='Sort by']"));
	public final DropDown display=new DropDown("Display DropDown", By.xpath("//select[@id='products-pagesize']"));
	public final Element displaytext=new Element("DisplayText", By.xpath("//span[text()='Display']"));
	public final DropDown viewas=new DropDown("Viewas DropDown", By.xpath("//select[@id='products-viewmode']"));
	public final Element viewastext=new Element("ViewasText", By.xpath("//span[text()='View as']"));
	public final HyperLink product=new HyperLink("Product HyperLink", By.xpath("//img[@src=\"https://demowebshop.tricentis.com/content/images/thumbs/0000018_50s-rockabilly-polka-dot-top-jr-plus-size_125.jpg\"]"));
	public final Element producttext=new Element("ProductText", By.xpath("//strong[@class='current-item']"));
	
	public final DropDown size=new DropDown("Size DropDown", By.xpath("//select[@class='valid']"));
	public final Element sizetext=new Element("SizeText", By.xpath("//label[@class='text-prompt']"));
	
	public final TextBox qty=new TextBox("Qty TextBox", By.xpath("//input[@class='qty-input valid']"));
	public final Element qtytext=new Element("QtyText", By.xpath("//label[@class='qty-label']"));
	
	public final Button addtocart=new Button("AddToCart", By.xpath("//input[@id='add-to-cart-button-5']"));
	
	
	public final Element productaddedtext=new Element("ProductAddedText Element", By.xpath("//div[@style='display: block;']"));
	public final HyperLink shoppingcart=new HyperLink("ShoppingCart HyperLink", By.className("cart-label"));
	public final Element shoppingcarttext=new  Element("ShoppingCartText", By.xpath("//h1[text()='Shopping cart']"));
	
	public final DropDown country=new DropDown("Country DropDown", By.xpath("//select[@class='country-input valid']"));
	public final DropDown india=new DropDown("India DropDown", By.xpath("//option[text()='India']"));
	public final DropDown state=new DropDown("State DropDown", By.xpath("//select[@class='state-input valid']"));
	public final TextBox zippostalcode=new TextBox("ZipPostalCode TextBox", By.xpath("//input[@id='ZipPostalCode']"));
	public final CheckBox termsandconditions=new CheckBox("TermsAndConditions", By.xpath("//input[@name='termsofservice']"));
	public final Button checkout=new Button("CheckOut", By.xpath("//button[@id='checkout']"));
	
	
	public final TextBox handlealert=new TextBox("Handlealert", By.xpath("//div[@class='page-body checkout-data']"));
	
	

	
}
