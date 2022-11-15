package com.DemoWebShopapp.pages;

import org.automation.base.BasePage;
import org.automation.elements.Button;
import org.automation.elements.CheckBox;
import org.automation.elements.DropDown;
import org.automation.elements.Element;
import org.automation.elements.HyperLink;
import org.automation.elements.TextBox;
import org.openqa.selenium.By;

/**
 * 
 * @author TYS-Vanishree
 * @version 1.0.0
 * @since 14/11/2022
 *
 */
public class JewelryPage extends BasePage {
	public final Element jewelText = new Element("JewelpageText", By.xpath("//h1[text()='Jewelry']"));
	public final DropDown option = new DropDown("Sort by dropdown", By.id("products-orderby"));
	public final DropDown sortby = new DropDown("Position", By.xpath("//option[text()='Position']"));
	public final DropDown option1 = new DropDown("Display dropdown", By.id("products-pagesize"));
	public final DropDown display = new DropDown("8", By.xpath("//option[text()='8']"));
	public final DropDown option2 = new DropDown("View as dropdown", By.id("products-viewmode"));
	public final DropDown viewas = new DropDown("8", By.xpath("//option[text()='Grid']"));
	public final HyperLink link = new HyperLink("Black&whitediamondheart",
			By.xpath("(//h2[@class='product-title'])[2]"));
	public final Element BlackandWhiteDiamond = new Element("black&whitediamondheartpage",
			By.xpath("//strong[text()='Black & White Diamond Heart']"));
	public final TextBox qty = new TextBox("Qty", By.id("addtocart_14_EnteredQuantity"));
	public final Element cartpop = new Element("popupmsg",
			By.xpath("//p[text()='The product has been added to your ']"));
	public final Element shoppingpage = new Element("ShoppingPage", By.xpath("//h1[text()='Shopping cart']"));
	public final Button add = new Button("Addtocart", By.id("add-to-cart-button-14"));
	public final HyperLink shoplink = new HyperLink("shoppingcartlink", By.xpath("//span[text()='Shopping cart']"));
	public final DropDown country = new DropDown("Display dropdown", By.id("CountryId"));
	public final DropDown Selectedcountry = new DropDown("SelectIndia", By.xpath("//option[text()='India']"));
	public final DropDown State = new DropDown("StateProvince", By.id("StateProvinceId"));
	public final DropDown SelectedState = new DropDown("SelectState", By.id("StateProvinceId"));
	public final TextBox postalcode = new TextBox("Zipcode", By.id("ZipPostalCode"));
	public final Button estimate = new Button("Estimate", By.name("estimateshipping"));
	public final CheckBox Terms = new CheckBox("Terms&conditions", By.id("termsofservice"));
	public final Button checkout = new Button("CheckOut", By.id("checkout"));

}
