package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //Locators
    private By LoginEmailLocator = By.xpath("//input[@data-qa='login-email']");
    private By LoginPsaawordLocator = By.xpath("//input[@data-qa='login-password']");
    private By LoginButtonLocator = By.xpath("//button[@data-qa='login-button']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //actions
    public void enterLoginEmail(String email) {
        WebElement LoginEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginEmailLocator));
        LoginEmail.sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        WebElement LoginPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPsaawordLocator));
        LoginPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement LoginButton = wait.until(ExpectedConditions.elementToBeClickable(LoginButtonLocator));
        LoginButton.click();
    }

}
