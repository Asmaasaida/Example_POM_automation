package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.PackageUtils;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver ;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ascho\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");


    }
    @AfterMethod
    public void teardown(){
        if (driver!=null){
            driver.quit();
        }
    }

}
