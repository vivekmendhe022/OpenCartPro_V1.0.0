package Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClassAdmin;

public class CustomerDetails extends BaseClassAdmin {

	@Test
	public void totalCustomers() throws EncryptedDocumentException, IOException {
		WebElement customerDetails = d.findElement(By.xpath(
				"//a[.='View more...']/../../../following-sibling::div//div[text()='Total Customers ']/following-sibling::div[2]/a"));
		wutil.mouseHoverAction(d, customerDetails);
		customerDetails.click();

		WebElement customerName = d.findElement(By.xpath("//a[text()='Customer Name']"));
		getWebElementText(customerName);
		List<WebElement> customerNameList = d
				.findElements(By.xpath("//input[@name='selected[]']/../following-sibling::td[1]"));
		printFindElementsList(customerNameList);

		writeWebElementListToExcel("CustomerList.xlsx", "Customer List", customerNameList);
		WebElement next = d.findElement(By.xpath("//a[@class='page-link']/../following-sibling::li[1]"));
		wutil.scrollBy(d, 0, 500);
		wutil.waitForElementToBeVisible(d, next);
		next.click();
		writeWebElementListToExcel("CustomerList.xlsx", "Customer List", customerNameList);

	}

	public static void writeWebElementListToExcel(String fileName, String sheetName, List<WebElement> elements)
			throws IOException {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(sheetName);

		int rowIdx = 0;
		for (WebElement element : elements) {
			Row row = sheet.createRow(rowIdx++);
			Cell cell = row.createCell(0);
			cell.setCellValue(element.getText());
		}

		FileOutputStream fileOut = new FileOutputStream(fileName);
		workbook.write(fileOut);
		fileOut.close();
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
}
