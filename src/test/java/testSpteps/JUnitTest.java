package testSpteps;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JUnitTest extends Setup{
	WebDriver driver = setup();
	public final String invalidEmailMsg = "//div[@class='validation error'][contains(text(), 'Email is required')]";
	 public final String invalidPasswordMsg = "//div[@class='validation error'][contains(text(), 'Password is required')]";
	   /*
	      !!! Do not create your own WebDriver. !!!

	      You can copy credentials from here:
	       - login@codility.com    password
	       - unknown@codility.com  password
	    */

	    @Test
	    public void testLoginFormPresent() {
	      // below you can find already setup webDriver
	      WebElement emailField = driver.findElement(By.id("email-input"));
	      Assert.assertTrue(emailField.isDisplayed());
	      WebElement passwordField = driver.findElement(By.id("password-input"));
	      Assert.assertTrue(passwordField.isDisplayed());
	      WebElement loginButton = driver.findElement(By.id("login-button"));
	      Assert.assertTrue(loginButton.isDisplayed());
	    }

	    @Test
	    public void testLoginWithValidCredentials() {
	      // below you can find already setup webDriver
	      WebDriverWait wait = new WebDriverWait(driver, 10);
	      WebElement emailField = driver.findElement(By.id("email-input"));
	      emailField.sendKeys("login@codility.com");
	      WebElement passwordField = driver.findElement(By.id("password-input"));
	      passwordField.sendKeys("password");
	      WebElement loginButton = driver.findElement(By.id("login-button"));
	      loginButton.click();
	      WebElement successfulMsg = driver.findElement(By.className("message success"));
	      wait.until(ExpectedConditions.visibilityOf(successfulMsg));
	      Assert.assertTrue(successfulMsg.getText().contains("Welcome"));
	    }

	    @Test
	    public void testLoginWithInvalidCredentials() {
	      // below you can find already setup webDriver
	      WebDriverWait wait = new WebDriverWait(driver, 10);
	      WebElement emailField = driver.findElement(By.id("email-input"));
	      emailField.sendKeys("unknown@codility.com");
	      WebElement passwordField = driver.findElement(By.id("password-input"));
	      passwordField.sendKeys("password");
	      WebElement loginButton = driver.findElement(By.id("login-button"));
	      loginButton.click();
	      WebElement unsuccessfulMsg = driver.findElement(By.className("message error"));
	      wait.until(ExpectedConditions.visibilityOf(unsuccessfulMsg));
	      Assert.assertTrue(unsuccessfulMsg.getText().contains("You shall not pass"));
	    }

	    @Test
	    public void testLoginEmailField() {
	      // below you can find already setup webDriver
	      WebDriverWait wait = new WebDriverWait(driver, 10);
	      WebElement emailField = driver.findElement(By.id("email-input"));
	      emailField.sendKeys("unknown_codility.com");
	      WebElement passwordField = driver.findElement(By.id("password-input"));
	      passwordField.sendKeys("password");
	      WebElement loginButton = driver.findElement(By.id("login-button"));
	      loginButton.click();
	      WebElement unsuccessfulMsg = driver.findElement(By.className("validation error"));
	      wait.until(ExpectedConditions.visibilityOf(unsuccessfulMsg));
	      Assert.assertTrue(unsuccessfulMsg.getText().trim().equals("Enter a valid email"));
	    }

	    @Test
	    public void testLoginInputFields() {
	      // below you can find already setup webDriver
	      WebDriverWait wait = new WebDriverWait(driver, 10);
	      WebElement emailField = driver.findElement(By.id("email-input"));
	      emailField.sendKeys("");
	      WebElement passwordField = driver.findElement(By.id("password-input"));
	      passwordField.sendKeys("");
	      WebElement loginButton = driver.findElement(By.id("login-button"));
	      loginButton.click();
	      WebElement unsuccessfulEmailMsg = driver.findElement(By.xpath(invalidEmailMsg));
	      wait.until(ExpectedConditions.visibilityOf(unsuccessfulEmailMsg));
	      Assert.assertTrue(unsuccessfulEmailMsg.getText().trim().equals("Email is required"));
	      WebElement unsuccessfulPswdMsg = driver.findElement(By.xpath(invalidPasswordMsg));
	      wait.until(ExpectedConditions.visibilityOf(unsuccessfulPswdMsg));
	      Assert.assertTrue(unsuccessfulPswdMsg.getText().trim().equals("Password is required"));
	    }
}
