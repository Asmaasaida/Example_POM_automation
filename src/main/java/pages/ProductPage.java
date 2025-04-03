package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By productsLinkLocator = By.xpath("//a[@href='/products']");
    private By addToCartButtonLocator = By.xpath("//a[@data-product-id='1' and contains(@class, 'add-to-cart')]");
    private By viewCartLinkInModalLocator = By.xpath("//u[contains(text(), 'View Cart')]/parent::a");

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions

    /**
     * Navigates to the Products page.
     */
    public void navigateToProductsPage() {
        WebElement productsLink = wait.until(ExpectedConditions.elementToBeClickable(productsLinkLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productsLink);
    }

    public void clickAddToCart() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement addToCartButton = wait1.until(ExpectedConditions.elementToBeClickable(addToCartButtonLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
    }

    public void clickViewCartFromModal() {
        WebDriverWait waitViewCart = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement viewCartLink = waitViewCart.until(ExpectedConditions.elementToBeClickable(viewCartLinkInModalLocator));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", viewCartLink);
    }
}