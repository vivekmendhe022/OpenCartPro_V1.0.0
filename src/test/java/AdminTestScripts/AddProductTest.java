package AdminTestScripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClassAdmin;
import com.object.repository.admin.CategoryPage;
import com.object.repository.admin.product.ProductsPage;

@Listeners(com.generic.utilities.ListenersImplementationUtility.class)
public class AddProductTest extends BaseClassAdmin {

	@Test
	public void addProductTest() throws InterruptedException {

		String PNAME = "Lava Mobile";
		String MEGATITLE = "Unleashing the Power of Lava Mobile: Experience Seamless Shopping on our E-Commerce Store!";
		String MODELNAME = "Lava Z6";
		String SEO = " Buy Lava Mobile Z6, Lava Mobile Phones Prices, Best Lava Smartphone";

		CategoryPage cp = new CategoryPage(d);
		cp.clickOnProducts();

		ProductsPage pp = new ProductsPage(d);
		pp.clickOnAddNewLookUpImg();
		pp.addNewProduct(PNAME, MEGATITLE, MODELNAME, SEO);

		Thread.sleep(3000);

	}
}
