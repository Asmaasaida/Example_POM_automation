package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountinformationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By genderMrRadioButtonLocator = By.id("id_gender1");
    private By genderMrsRadioButtonLocator = By.id("id_gender2");
    private By passwordFieldLocator = By.id("password");
    private By dayDropdownLocator = By.id("days");
    private By monthDropdownLocator = By.id("months");
    private By yearDropdownLocator = By.id("years");
    private By firstNameInputLocator = By.id("first_name");
    private By lastNameInputLocator = By.id("last_name");
    private By companyInputLocator = By.id("company");
    private By addressInputLocator = By.id("address1");
    private By stateInputLocator = By.id("state");
    private By cityInputLocator = By.id("city");
    private By zipcodeInputLocator = By.id("zipcode");
    private By mobileNumberInputLocator = By.id("mobile_number");
    private By createAccountButtonLocator = By.xpath("//button[text()='Create Account']");
    private By continueButtonLocator = By.xpath("//a[text()='Continue']");

    // Constructor
    public AccountinformationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions


    public void selectGenderMrs() {
        WebElement genderMrsRadioButton = wait.until(ExpectedConditions.elementToBeClickable(genderMrsRadioButtonLocator));
        genderMrsRadioButton.click();
    }

    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        passwordField.sendKeys(password);
    }

    public void selectDay(String day) {
        WebElement dayDropdown = wait.until(ExpectedConditions.elementToBeClickable(dayDropdownLocator));
        Select daySelect = new Select(dayDropdown);
        daySelect.selectByVisibleText(day);
    }

    public void selectMonth(String month) {
        WebElement monthDropdown = wait.until(ExpectedConditions.elementToBeClickable(monthDropdownLocator));
        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByVisibleText(month);
    }

    public void selectYear(String year) {
        WebElement yearDropdown = wait.until(ExpectedConditions.elementToBeClickable(yearDropdownLocator));
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByVisibleText(year);
    }

    public void enterFirstName(String firstName) {
        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInputLocator));
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInputLocator));
        lastNameInput.sendKeys(lastName);
    }

    public void enterCompany(String company) {
        WebElement companyInput = wait.until(ExpectedConditions.visibilityOfElementLocated(companyInputLocator));
        companyInput.sendKeys(company);
    }

    public void enterAddress(String address) {
        WebElement addressInput = wait.until(ExpectedConditions.visibilityOfElementLocated(addressInputLocator));
        addressInput.sendKeys(address);
    }

    public void enterState(String state) {
        WebElement stateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(stateInputLocator));
        stateInput.sendKeys(state);
    }

    public void enterCity(String city) {
        WebElement cityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(cityInputLocator));
        cityInput.sendKeys(city);
    }

    public void enterZipcode(String zipcode) {
        WebElement zipcodeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(zipcodeInputLocator));
        zipcodeInput.sendKeys(zipcode);
    }

    public void enterMobileNumber(String mobileNumber) {
        WebElement mobileNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberInputLocator));
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public void clickCreateAccountButton() {
        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(createAccountButtonLocator));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", createAccountButton);
    }

    public void clickContinueButton() {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
        continueButton.click();
    }


}


