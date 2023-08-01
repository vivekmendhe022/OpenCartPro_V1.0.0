package com.object.repository.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.BaseClassAdmin;
import com.generic.utilities.WebDriverUtility;

public class CategoryPage extends WebDriverUtility {
	@FindBy(xpath = " //a[text()=' Catalog']")
	private WebElement CatalogDropDownMenu;

	@FindBy(linkText = "Categories")
	private WebElement CategoriesLink;

	@FindBy(xpath = "//i[@class='fa-solid fa-plus']")
	private WebElement CreatCaregoriesAddIcon;

	@FindBy(xpath = "//input[@id='input-name-1']")
	private WebElement CategoryNameTextField;

	@FindBy(xpath = "//input[@id='input-meta-title-1']")
	private WebElement MetaTagTitleTextField;

	@FindBy(xpath = "//a[normalize-space()='SEO']")
	private WebElement SEOTabLink;

	@FindBy(xpath = "//input[@id='input-keyword-0-1']")
	private WebElement SEODefaultTextField;

	@FindBy(xpath = "//i[@class='fa-solid fa-floppy-disk']")
	private WebElement SaveIcon;

	@FindBy(linkText = "Products")
	private WebElement ProductsLinkText;

	public CategoryPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getCatalogDropDownMenu() {
		return CatalogDropDownMenu;
	}

	public WebElement getCategoriesLink() {
		return CategoriesLink;
	}

	public WebElement getCreatCaregoriesAddIcon() {
		return CreatCaregoriesAddIcon;
	}

	public WebElement getCategoryNameTextField() {
		return CategoryNameTextField;
	}

	public WebElement getMetaTagTitleTextField() {
		return MetaTagTitleTextField;
	}

	public WebElement getSEOTabLink() {
		return SEOTabLink;
	}

	public WebElement getSEODefaultTextField() {
		return SEODefaultTextField;
	}

	public WebElement getSaveIcon() {
		return SaveIcon;
	}

	public void createCategory(WebDriver d, String CATEGORYNAME, String METATAGTITLE, String SEODEFAULT)
			throws InterruptedException {
		CatalogDropDownMenu.click();
		CategoriesLink.click();
		CreatCaregoriesAddIcon.click();
		CategoryNameTextField.sendKeys(CATEGORYNAME);
		scrollBy(d, 0, 500);
		MetaTagTitleTextField.sendKeys(METATAGTITLE);
		SEOTabLink.click();
		waitForElementToBeVisible(d, SEODefaultTextField);
		SEODefaultTextField.sendKeys(SEODEFAULT);
		SaveIcon.click();
	}

	public void clickOnProducts() {
		CatalogDropDownMenu.click();
		ProductsLinkText.click();
	}

}
