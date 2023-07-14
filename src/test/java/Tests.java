import com.google.common.annotations.VisibleForTesting;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SignInPage;
import utils.Constants;
import utils.FrameworkProperties;

import static org.junit.Assert.assertEquals;

public class Tests {

    static FrameworkProperties frameworkProperties;
    static WebDriver driver;
    static HomePage homePage;
    static SignInPage signInPage;
    static CheckoutPage checkoutPage;

    @BeforeClass
    public static void initializationObjects(){
        frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
        driver = DriverSingleton.getDriver();
        homePage = new HomePage();
        checkoutPage = new CheckoutPage();
        signInPage = new SignInPage();
    }
    @Test
    public void testingAuthentication(){
        driver.get(Constants.URL);
        homePage.clickSignIn();
        signInPage.logIn(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD) );
        assertEquals(frameworkProperties.getProperty(Constants.USERNAME), homePage.getUserName());
    }

    @AfterClass
    public static void closeObjects(){
        driver.close();
    }

//    FrameworkProperties frameworkProperties = new FrameworkProperties();
//
//    DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
//    WebDriver driver = DriverSingleton.getDriver();
//        driver.get("http://automationpractice.com");
//    HomePage homepage = new HomePage();
//        homepage.addFirstElementToCart();
//        homepage.addSecondElementToCart();
//
//    CheckoutPage checkoutPage = new CheckoutPage();
//        checkoutPage.goToCheckout();
//
//    SignInPage signInPage = new SignInPage();
//        signInPage.logIn(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD));
//
//        checkoutPage.confirmAddress();
//        checkoutPage.confirmShipping();
//        checkoutPage.payByBankWire();
//        checkoutPage.confirmFinalOrder();
//        if(checkoutPage.checkFinalStatus())
//                System.out.println("Test case completed!");
}
