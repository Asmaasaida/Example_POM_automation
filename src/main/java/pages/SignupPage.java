package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By signupNameLocator = By.xpath("//input[@data-qa='signup-name']");
    private By signupEmailLocator = By.xpath("//input[@data-qa='signup-email']");
    private By signupButtonLocator = By.xpath("//button[@data-qa='signup-button']");
    private By signupLoginLinkLocator = By.xpath("//*[contains(text(), 'Signup / Login')]");

    // Constructor
    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public void navigateToSignupLoginPage() {
        WebElement signupLoginLink = wait.until(ExpectedConditions.elementToBeClickable(signupLoginLinkLocator));
        signupLoginLink.click();
    }

    public void enterSignupName(String name) {
        WebElement signupName = wait.until(ExpectedConditions.visibilityOfElementLocated(signupNameLocator));
        signupName.sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        WebElement signupEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(signupEmailLocator));
        signupEmail.sendKeys(email);
    }

    public void clickSignupButton() {
        WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(signupButtonLocator));
        signupButton.click();
    }

}