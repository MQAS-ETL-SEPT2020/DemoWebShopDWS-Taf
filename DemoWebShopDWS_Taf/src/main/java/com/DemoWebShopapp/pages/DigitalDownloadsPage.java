package com.DemoWebShopapp.pages;

import org.automation.base.BasePage;
import org.automation.elements.Button;
import org.automation.elements.CheckBox;
import org.automation.elements.DropDown;
import org.automation.elements.Element;
import org.automation.elements.HyperLink;
import org.openqa.selenium.By;

public class DigitalDownloadsPage extends BasePage {

	public final Element digitalDownloadspage = new Element("DigitalDownloadsPage",
			By.xpath("//h1[text()='Digital downloads']"));

	public final DropDown sortby = new DropDown("SortBy DropDown", By.id("products-orderby"));
	public final DropDown position_sortby = new DropDown("Position_sortby", By.xpath("//option[text()='Position']"));

	public final DropDown displayPerPage = new DropDown("DisplayPerPage DropDown ", By.id("products-pagesize"));
	public final DropDown eight_displayPerPage = new DropDown("Eight_displayPerPage", By.xpath("//option[text()='8']"));

	public final DropDown viewAs = new DropDown("ViewAs DropDown", By.id("products-viewmode"));
	public final DropDown grid_viewAs = new DropDown("Grid_viewAs DropDown", By.xpath("//option[text()='Grid']"));

	public final HyperLink thirdAlbum = new HyperLink("ThirdAlbum", By.xpath("(//a[text()='3rd Album'])[2]"));

	public final Element thirdAlbumPage = new Element("ThirdAlbumPage", By.xpath("//div[@class='product-name']"));
	public final Element price = new Element("Price", By.xpath("//div[@class='product-price']"));
	public final Element quantity = new Element("Quantity", By.id("addtocart_53_EnteredQuantity"));
	public final Button addToCart = new Button("Add to Cart Button", By.id("add-to-cart-button-53"));
	public final Element confirmationMessage = new Element("Confirmation Message",
			By.xpath("//p[contains(text(),'The product has been added to your')]"));

	public final HyperLink shoppingCart = new HyperLink("Shopping Cart Link",
			By.xpath("//span[text()='Shopping cart']"));
	public final Element shoppingCartPage = new Element("ShoppingCartPage", By.xpath("//h1[text()='Shopping cart']"));
	public final Element termsOfServiceText = new Element("Terms Of Service", By.xpath("//div[@class='terms-of-service']"));
	public final CheckBox termsOfServiceCheckbox = new CheckBox("Terms of Service CheckBox", By.id("termsofservice"));
	public final Button checkOut = new Button("CheckOut button", By.id("checkout"));

}
