package tests;
import base.BaseTest;
import pages.*;
import utils.Accountinformation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelReader;

import java.io.IOException;
import java.time.Duration;

public class FullSenarioTest extends BaseTest {

    @DataProvider(name = "registrationData")
    public Object[][] registrationData() throws IOException {
        String sheetName = "Sheet0";
        return ExcelReader.getTestData(sheetName);
    }
    @DataProvider(name = "accountinformation")
    public Object[][] accountinformation() throws IOException {
        String sheetName = "Sheet1";
        return Accountinformation.getTestData(sheetName);
    }
    @DataProvider(name = "logindata")
    public Object[][] logindata() throws IOException {
        String sheetName = "Sheet2";
        return ExcelReader.getTestData(sheetName);
    }

    @Test(dataProvider = "accountinformation")
    public void testFillAccountInformationForm(String name, String email, String password, String day, String month, String year, String firstName, String lastName, String company, String address, String state, String city, String zipcode, String mobileNumber) {
        SignupPage signupPage = new SignupPage(driver);
        AccountinformationPage accountInfoPage = new AccountinformationPage(driver);
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage=new LoginPage(driver);
        ProductPage productPage=new ProductPage(driver);
        CartPage cartPage=new CartPage(driver);



        // 1-Navigate to Signup Page and Enter Signup Details
        signupPage.navigateToSignupLoginPage();
        signupPage.enterSignupName(name);
        signupPage.enterSignupEmail(email);
        WebDriverWait waitSignup = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement signupButton = waitSignup.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='signup-button']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signupButton);

        //2- Fill out Account Information form
        accountInfoPage.selectGenderMrs();
        accountInfoPage.enterPassword(password);
        accountInfoPage.selectDay(day);
        accountInfoPage.selectMonth(month);
        accountInfoPage.selectYear(year);
        accountInfoPage.enterFirstName(firstName);
        accountInfoPage.enterLastName(lastName);
        accountInfoPage.enterCompany(company);
        accountInfoPage.enterAddress(address);
        accountInfoPage.enterState(state);
        accountInfoPage.enterCity(city);
        accountInfoPage.enterZipcode(zipcode);
        accountInfoPage.enterMobileNumber(mobileNumber);
        accountInfoPage.clickCreateAccountButton();
        accountInfoPage.clickContinueButton();

        //3-logout
        homePage.clickLogout();
        //4-login

        loginPage.enterLoginEmail(email);
        loginPage.enterLoginPassword(password);
        loginPage.clickLoginButton();
        // 4. Add product to cart
        productPage.navigateToProductsPage();
        productPage.clickAddToCart();
        //5.Viewcart
        productPage.clickViewCartFromModal();

        // 6. Proceed to Checkout
        cartPage.clickProceedToCheckout();

        // 7. Delete Account
        homePage.clickDeleteAccount();
        homePage.clickContinueAfterDelete();


    }}



