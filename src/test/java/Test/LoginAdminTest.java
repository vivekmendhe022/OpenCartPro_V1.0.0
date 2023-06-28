package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

public class LoginAdminTest extends BaseClass {

	@Test
	public void loginAsAdminTest() throws InterruptedException {
		WebElement username = d.findElement(By.id("input-username"));
		WebElement password = d.findElement(By.id("input-password"));
		WebElement loginbtn = d.findElement(By.xpath("//button[.=' Login']"));
		username.sendKeys("admin");
		password.sendKeys("Root12345");
		loginbtn.click();
		Thread.sleep(5000);
	}

}
