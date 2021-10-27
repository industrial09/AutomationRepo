package testSpteps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestNGMethods extends Setup{
	WebDriver driver = setup();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	Actions action = new Actions(driver);
	
	final String rowsData = "//table/tbody/tr";
	public static final String aboutLinkXpath = "//a[contains(@href, 'about')]";
	public final String aboutModalHeaderXpath = "//h2[text()= 'About']";
	public final String modalAuthorXpath = "(//div[@class='modal-body']/p[2])[2]";
	public final String modalCloseButtonXpath = "(//button[@data-dismiss='modal'])[2]";
	public final String firstTxtBoxXpath = "//input[@id='number1Field']";
	public final String secondTxtBoxXpath = "//input[@id='number2Field']";
	public final String resultTxtBoxXpath = "//input[@id='numberAnswerField']";
	public final String operationSelectXpath = "//*[@name='selectOperation']";
	public final String calculateButtonXpath = "//*[@id='calculateButton']";
	public final String seleniumTutLinkXpath = "//*[contains(text(), 'SeleniumTutorial')]";
	
	public void goToSite() {
		driver.get("http://computer-database.gatling.io/computers");
	}
	
	public void getTableData() {
		List<WebElement> rows = driver.findElements(By.xpath(rowsData));
		List<String> data = new ArrayList();
		for(WebElement row: rows) {
			List<WebElement> columns = row.findElements(By.tagName("td"));
			for(WebElement col:columns) {
				String coldData = col.getText();
				data.add(coldData);
			}
		}
		System.out.println(data);
	}
	
	public void gotToSite2() {
		driver.get("https://testsheepnz.github.io/BasicCalculator.html");
	}
	
	public void getAboutWindowTitleAndCompare() {
		driver.get("https://testsheepnz.github.io/BasicCalculator.html");
		WebElement aboutLink = driver.findElement(By.xpath(aboutLinkXpath));
		wait.until(ExpectedConditions.visibilityOf(aboutLink));
		action.moveToElement(aboutLink);
		aboutLink.click();
		WebElement modalHeader = driver.findElement(By.xpath(aboutModalHeaderXpath));
		wait.until(ExpectedConditions.visibilityOf(modalHeader));
		WebElement modalAuthorText = driver.findElement(By.xpath(modalAuthorXpath));
		Assert.assertTrue(modalAuthorText.getText().contains("Mike"), "Mike is not the author of this site being tested");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(modalCloseButtonXpath)));
		WebElement closeModalButton = driver.findElement(By.xpath(modalCloseButtonXpath));
		closeModalButton.click();
		System.out.println("Change to load");
	}
	
	public void makeASumAndValidateResult() throws InterruptedException {
		WebElement firstTxtBox = driver.findElement(By.xpath(firstTxtBoxXpath));
		wait.until(ExpectedConditions.visibilityOf(firstTxtBox));
		firstTxtBox.sendKeys("5");
		Thread.sleep(1500);
		int firstValue = Integer.parseInt(firstTxtBox.getAttribute("value"));
		System.out.println(firstValue);
		WebElement secondTxtBox = driver.findElement(By.xpath(secondTxtBoxXpath));
		wait.until(ExpectedConditions.visibilityOf(secondTxtBox));
		secondTxtBox.sendKeys("6");
		Thread.sleep(1500);
		int secondValue = Integer.parseInt(secondTxtBox.getAttribute("value"));
		System.out.println(secondValue);
		WebElement selectOperation = driver.findElement(By.xpath(operationSelectXpath));
		Select se = new Select(selectOperation);
		se.selectByVisibleText("Multiply");
		WebElement calculateButton = driver.findElement(By.xpath(calculateButtonXpath));
		calculateButton.click();
		Thread.sleep(1500);
		WebElement resultTxtBox = driver.findElement(By.xpath(resultTxtBoxXpath));
		int result = Integer.parseInt(resultTxtBox.getAttribute("value"));
		Assert.assertTrue(result == (firstValue * secondValue), "Result is not the expected");
	}
	
	public void handleWindows() throws InterruptedException {
		driver.get("http://omayo.blogspot.com/");
		WebElement seleniumLink = driver.findElement(By.xpath(seleniumTutLinkXpath));
		wait.until(ExpectedConditions.visibilityOf(seleniumLink));
		String parentWindow = driver.getWindowHandle();
		seleniumLink.click();
		Set<String> windows = driver.getWindowHandles();
		for(String win: windows) {
			if(!win.equals(parentWindow)) {
				driver.switchTo().window(win);
				Thread.sleep(8000);
				Assert.assertTrue(driver.getCurrentUrl().contains("selenium143"), "User wasn't landed to expected site");
				driver.close();
			}
			
		}
	}
	
	public void tearDown() {
		driver.quit();
	}
}
