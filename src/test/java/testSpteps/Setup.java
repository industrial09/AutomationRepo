package testSpteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {
	public WebDriver setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MADELEINY\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        driver.manage().window().maximize();
        return driver;
    }
}
