package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;
import com.generic.utilities.BaseClassUser;

@Listeners(com.generic.utilities.ListenersImplementationUtility.class)
public class Test1 extends BaseClassUser {

	@Test
	public void test() throws InterruptedException {
		WebElement Account = d.findElement(By.xpath("//span[.='My Account']"));
		Account.click();
		WebElement Register = d.findElement(By.linkText("Register"));
		Register.click();
		WebElement Header = d.findElement(By.xpath("//h1[.='Register Account']"));
		String textHeader = Header.getText();
		if (textHeader.equalsIgnoreCase("Register Account")) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}

		WebElement FirstNameTextField = d.findElement(By.id("input-firstname"));
		WebElement LastNameTextField = d.findElement(By.id("input-lastname"));
		WebElement EmailTextField = d.findElement(By.id("input-email"));
		WebElement PasswordTextField = d.findElement(By.id("input-password"));
		WebElement SubscribeCircularToggleButton = d.findElement(By.id("input-newsletter"));
		WebElement PrivacyPolicyCircularToggleButton = d.findElement(By.name("agree"));
		WebElement ContinueBtn = d.findElement(By.xpath("//button[.='Continue']"));
		
		int r = jutil.getRandomNumber();

		FirstNameTextField.sendKeys("Manoj");
		LastNameTextField.sendKeys("Tiwari");
		EmailTextField.sendKeys(r+"manoj123@gmail.com");
		PasswordTextField.sendKeys("123456");
		SubscribeCircularToggleButton.click();
		wutil.scrollBy(d, 0, 500);
		wutil.waitForElementToBeVisible(d, PrivacyPolicyCircularToggleButton);
		PrivacyPolicyCircularToggleButton.click();
		ContinueBtn.click();

		WebElement AccountCreatedText = d.findElement(By.xpath("//h1[contains(.,'Created')]"));
		String textCreated = AccountCreatedText.getText();

		if (textCreated.equalsIgnoreCase("Your Account Has Been Created!")) {
			System.out.println("Account Created");
		} else {
			System.out.println("Account Creation Failed");
		}
	}
}
