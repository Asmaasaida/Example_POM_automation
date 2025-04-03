package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By logoutLinkLocator = By.xpath("//a[contains(text(), 'Logout')]");
    private By deleteAccountLinkLocator = By.xpath("//a[@href='/delete_account']");
    private By continueButtonAfterDeleteLocator = By.xpath("//div[@class='pull-right']/a[contains(text(), 'Continue')]");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public void clickLogout() {
        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(logoutLinkLocator));
        logoutLink.click();
    }
    public void clickDeleteAccount() {
        WebElement deleteAccountLink = wait.until(ExpectedConditions.elementToBeClickable(deleteAccountLinkLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteAccountLink);
    }


    public void clickContinueAfterDelete() {

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueButtonAfterDeleteLocator));
        continueButton.click();
    }
}