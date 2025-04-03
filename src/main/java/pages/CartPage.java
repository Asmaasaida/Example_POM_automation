package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators

    private By proceedToCheckoutButtonLocator = By.xpath("//a[@class='btn btn-default check_out']");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions


    public void clickProceedToCheckout() {
        WebElement proceedToCheckoutButton = wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButtonLocator));
        proceedToCheckoutButton.click();
    }
}