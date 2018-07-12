package Utils;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by dell on 12/7/18.
 */
public class Util {

    private WebDriver driver;

    private static final String BASE_URL = "https://www.cleartrip.com/";

    public void getUrl(){
        driver.get(BASE_URL);
    }

    public WebDriver getDriver(String browser){
        if (browser == null || browser.equals("")){
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("chrome")){
            setDriverPath();
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            // Likewise we can initialize driver for firefox
        }
        return driver;
    }


    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

    public void waitFor(int durationInMilliSeconds, WebDriver  driver) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void clickOnElement (String locatorType, String value, WebDriver driver){

        locatorType = locatorType.toUpperCase();

        switch (locatorType){
            case "ID":
                driver.findElement(By.id(value)).click();
                break;
            case "XPATH":
                driver.findElement(By.xpath(value)).click();
                break;
            case "LINK_TEXT":
                driver.findElement(By.linkText(value)).click();
                break;
            default:
                System.out.println("Please pass valid locator type.");
        }
    }

    public WebElement getWebElement(String locatorType, String value, WebDriver driver){
        locatorType = locatorType.toUpperCase();

        switch (locatorType){
            case "ID":
                return driver.findElement(By.id(value));
            case "XPATH":
                return driver.findElement(By.xpath(value));
            case "LINK_TEXT":
                return driver.findElement(By.linkText(value));
            case "CLASSNAME":
                return driver.findElement(By.className(value));
            default:
                throw new RuntimeException("Valid locatorType is not found");
        }
    }

    public String getText(String locatorType, String value, WebDriver driver){
        locatorType = locatorType.toUpperCase();

        switch (locatorType){
            case "ID":
                return driver.findElement(By.id(value)).getText();
            case "XPATH":
                return driver.findElement(By.xpath(value)).getText();
            case "LINK_TEXT":
                return driver.findElement(By.linkText(value)).getText();
            case "CLASSNAME":
                return driver.findElement(By.className(value)).getText();
            default:
                System.out.println("Please pass valid locator type.");
        }

        return null;
    }

    public void enterText(String locatorType, String locatorValue, WebDriver driver, String text){
        getWebElement(locatorType,locatorValue,driver).sendKeys(text);
    }

    public void switchToFrameById(WebDriver driver,String id){
        driver.switchTo().frame(id);
    }

    public boolean isElementPresent(String locatorType, String value, WebDriver driver) {
        try {
            getWebElement(locatorType, value, driver);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
