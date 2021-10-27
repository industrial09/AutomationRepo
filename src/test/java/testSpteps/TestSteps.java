package testSpteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TestSteps {
	Setup setup = new Setup();
    Locators locators = new Locators();
    WebDriver driver = new ChromeDriver();

    @When("I click on Iniciar sesion on landing page")
    public void i_click_on_iniciar_sesion_on_landing_page() {
        setup.setup();
        driver.get("https://www.musixmatch.com/es");
        driver.findElement(By.xpath(locators.iniciarSesionXpath)).click();
    }

    @Then("I enter my user credentials")
    public void i_enter_my_user_credentials() {
        driver.findElement(By.xpath(locators.correoTxtboxXpath)).sendKeys("patopatri09@gmail.com");
        driver.findElement(By.xpath(locators.contraseñaTxtboxXpath)).sendKeys("Dark0993");
    }

    @And("I click on Iniciar sesion button")
    public void i_click_on_iniciar_sesion_button() {
        driver.findElement(By.xpath(locators.iniciarSesionLoginXpath)).click();
    }

    @Given("I go to my profile")
    public void i_go_to_my_profile() {
        driver.findElement(By.xpath(locators.profileIconXpath)).click();
        driver.findElement(By.xpath(locators.perfilLinkXpath)).click();
    }

    @Then("I verify my account data")
    public void i_verify_my_account_data() {
        String expectedValue = "Test";
        String actualValue = driver.findElement(By.xpath(locators.perfilNameData)).getText();
        if (expectedValue == actualValue) System.out.println("Profile verified");
    }
}
