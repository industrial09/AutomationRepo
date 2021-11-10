package mainScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Setup {
	public WebDriver setup(String driverType) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MADELEINY\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = null;
        if(driverType == "chrome") driver = new ChromeDriver();
        else if(driverType == "firefox") driver = new FirefoxDriver();
        else if(driverType == "IE") driver = new InternetExplorerDriver();
        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        driver.manage().window().maximize();
        return driver;
    }
}
