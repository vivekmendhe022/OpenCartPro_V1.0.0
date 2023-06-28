package Test;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;
import com.generic.utilities.BaseClassAdmin;

public class TotalCustomers extends BaseClassAdmin {

	@Test
	public void totalCustomers() throws EncryptedDocumentException, IOException {
		WebElement CustomerDetails = d.findElement(By.xpath(
				"//a[.='View more...']/../../../following-sibling::div//div[text()='Total Customers ']/following-sibling::div[2]/a"));
		wutil.mouseHoverAction(d, CustomerDetails);
		CustomerDetails.click();

		WebElement CustomerName = d.findElement(By.xpath("//a[text()='Customer Name']"));
		getWebElementText(CustomerName);
		List<WebElement> CustomerNameList = d
				.findElements(By.xpath("//input[@name='selected[]']/../following-sibling::td[1]"));
		printFindElementsList(CustomerNameList);

		System.out.println();

		WebElement EMail = d.findElement(By.xpath("//a[text()='Customer Name']/../following-sibling::td[1]"));
		getWebElementText(EMail);
		List<WebElement> EmailList = d
				.findElements(By.xpath("//input[@name='selected[]']/../following-sibling::td[2]"));
		printFindElementsList(EmailList);

		System.out.println();

		WebElement CustomerGroup = d.findElement(By.xpath("//a[text()='Customer Name']/../following-sibling::td[2]"));
		getWebElementText(CustomerGroup);
		List<WebElement> CustomerGroupList = d
				.findElements(By.xpath("//input[@name='selected[]']/../following-sibling::td[3]"));
		printFindElementsList(CustomerGroupList);

		System.out.println();

		WebElement Status = d.findElement(By.xpath("//a[text()='Customer Name']/../following-sibling::td[3]"));
		getWebElementText(Status);
		List<WebElement> StatusList = d
				.findElements(By.xpath("//input[@name='selected[]']/../following-sibling::td[4]"));
		printFindElementsList(StatusList);

		System.out.println();

		WebElement DateAdded = d.findElement(By.xpath("//a[text()='Customer Name']/../following-sibling::td[4]"));
		getWebElementText(DateAdded);
		List<WebElement> DateAddedList = d
				.findElements(By.xpath("//input[@name='selected[]']/../following-sibling::td[5]"));
		printFindElementsList(DateAddedList);

	}

	public static void getWebElementText(WebElement element) {
		String textCustomer = element.getText();
		System.out.println(textCustomer);
	}

	public static void printFindElementsList(List<WebElement> Element) {
		for (WebElement webElement : Element) {
			System.out.println(webElement.getText());
		}
	}

	public static String writeFindElementsList(List<WebElement> elements) {
		StringBuilder text = new StringBuilder();
		for (WebElement element : elements) {
			text.append(element.getText()).append(" ");
		}
		return text.toString().trim();
	}
}
