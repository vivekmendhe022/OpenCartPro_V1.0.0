package UserTestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClassUser;
import com.object.repository.user.HomePage;
import com.object.repository.user.login.LoginInfoPage;
import com.object.repository.user.login.LoginPage;

public class UserLoginTest extends BaseClassUser {

	@Test
	public void loginAsUserToApplication() throws InterruptedException, IOException {

		String expectedMyAccountHeaderText = "My Account";

		String EMAIL = putil.readDatafromPropertyFileUser("user_username");
		String PASSWORD = putil.readDatafromPropertyFileUser("user_passowrd");

		HomePage hp = new HomePage(d);
		hp.clickOnLoginLink();

		LoginPage lp = new LoginPage(d);
		lp.loginAsUser(EMAIL, PASSWORD);

		LoginInfoPage lip = new LoginInfoPage(d);
		String header = lip.getMyAccountHeaderInfo();
		Assert.assertTrue(header.contains(expectedMyAccountHeaderText));

		Thread.sleep(3000);
	}
}
