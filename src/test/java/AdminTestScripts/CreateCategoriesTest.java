package AdminTestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClassAdmin;
import com.object.repository.admin.CategoryPage;

public class CreateCategoriesTest extends BaseClassAdmin {

	@Test
	public void createCategoriesTest() throws InterruptedException {

		int r = jutil.getRandomNumber();
		String CATEGORYNAME = "Laptops Bags > Mac";
		String METATAGTITLE = "Browse a Wide Selection of Windows Laptop Bags in the Laptops Bags Category";
		String SEODEFAULT = "Shop Stylish and Functional Windows Laptop Bags in the Laptops Bags Category | YourSiteName";

		CategoryPage cp = new CategoryPage(d);
		cp.createCategory(d, CATEGORYNAME, METATAGTITLE, r + SEODEFAULT);

		WebElement ProductsLink = d.findElement(By.linkText("Products"));
		ProductsLink.click();

	}

}
