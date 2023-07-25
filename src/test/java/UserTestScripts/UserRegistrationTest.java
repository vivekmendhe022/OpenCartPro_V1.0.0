package UserTestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;
import com.generic.utilities.BaseClassAdmin;
import com.generic.utilities.BaseClassUser;
import com.object.repository.user.HomePage;
import com.object.repository.user.registration.RegistartionInfoPage;
import com.object.repository.user.registration.RegisterAccountInfoPage;
import com.object.repository.user.registration.RegistrationPage;

@Listeners(com.generic.utilities.ListenersImplementationUtility.class)
public class UserRegistrationTest extends BaseClassUser {

	int r = jutil.getRandomNumber();

	@Test
	public void userRegistrationTest() throws EncryptedDocumentException, IOException {

		String ExpectedRegistrationHeader = "Your Account Has Been Created!";

		String FIRSTNAME = eutil.readDataFromExcel("UserRegistration", 1, 2);
		String LASTNAME = eutil.readDataFromExcel("UserRegistration", 1, 3);
		String EMAIL = eutil.readDataFromExcel("UserRegistration", 1, 4);
		String PASSWORD = eutil.readDataFromExcel("UserRegistration", 1, 5);

		HomePage hp = new HomePage(d);
		hp.clickOnMyAccountIcon();
		RegisterAccountInfoPage registerAccountInfoPage = new RegisterAccountInfoPage(d);
		String registerAccountHeader = registerAccountInfoPage.getRegisterAccountHeader();
		Assert.assertTrue(registerAccountHeader.equalsIgnoreCase("Register Account"));

		RegistrationPage registrationPage = new RegistrationPage(d);
		registrationPage.createRegistrationForUser(d, FIRSTNAME, LASTNAME, r + EMAIL, PASSWORD);
		RegistartionInfoPage registartionInfoPage = new RegistartionInfoPage(d);
		String registrationHeader = registartionInfoPage.getRegistrationHeader();
		Assert.assertTrue(registrationHeader.equalsIgnoreCase(ExpectedRegistrationHeader));

	}
}
