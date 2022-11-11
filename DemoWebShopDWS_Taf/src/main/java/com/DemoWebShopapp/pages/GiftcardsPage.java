package com.DemoWebShopapp.pages;

import org.automation.elements.Button;
import org.automation.elements.CheckBox;
import org.automation.elements.DropDown;
import org.automation.elements.Element;
import org.automation.elements.HyperLink;
import org.automation.elements.TextBox;
import org.openqa.selenium.By;


public class GiftcardsPage {

	public DropDown SortBy_Dropdown =new DropDown("SortBy Dropdown",By.xpath("//select[@id='products-orderby']"));
	public DropDown DisplayPerPage_Dropdown=new DropDown("Display per page Dropdown",By.xpath("//select[@id='products-pagesize']"));
	public DropDown ViewAs_Dropdown=new DropDown("View as Dropdown",By.id("products-viewmode"));
	public HyperLink VirtualGiftcard_ProductLink=new HyperLink("$25 Virtual product link",By.xpath("//div[@class='product-grid']//a[text()='$25 Virtual Gift Card']"));
	public TextBox ReciepientsName_Textfeild=new TextBox("Reciepents name textfeild",By.xpath("//input[@class='recipient-name']"));
	public TextBox ReciepentsMail_Textfeild=new TextBox("ReciepentsMail",By.id("giftcard_2_RecipientEmail"));
	public TextBox Message_TextareaFeild=new TextBox("Message Textareafeild",By.id("giftcard_2_Message"));
	public Button Addtocart_Button=new Button("Addtocart Button",By.xpath("//input[@id='add-to-cart-button-2']"));
	public HyperLink ShoppingCart_Link=new HyperLink("Shopping cart Link",By.xpath("//span[text()='Shopping cart']"));
	public CheckBox Iagree_Checkbox=new CheckBox("I agree Checkbox",By.id("termsofservice"));
	public Button Checkout_Button=new Button("Checkout Button",By.xpath("//button[@id='checkout']"));
	

	//Assertion Methods
	public Element VirtualGiftcardProduct_Text=new Element("Product text",By.xpath("//h1[@itemprop='name']"));
	public Element AddedToCart_Message=new Element("The product has been added to cart --message",By.xpath("//p[text()='The product has been added to your ']"));
	public TextBox Qty_Textfeild=new TextBox("Qty Textfeild",By.id("addtocart_2_EnteredQuantity"));
	public Element TwentyFive_Text=new Element("$ 25 Text",By.xpath("//span[@itemprop='price']"));
	public HyperLink Crossmark=new HyperLink("Close option to close the message of added to shopping cart",By.xpath("//span[@class='close']"));
}
