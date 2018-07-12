package pages;

import Utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by ChelseaCFC on 7/12/2018.
 */
public class FlightBooking extends Util{

    private WebDriver driver;

    public FlightBooking(WebDriver driver){
        this.driver = driver;
    }

    public void bookFlight(){
        clickOnElement("id","OneWay", driver);
        getWebElement("id","FromTag",driver).clear();
        enterText("id","FromTag", driver, "Bangalore");
        waitFor(4000, driver);

        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        originOptions.get(0).click();

        getWebElement("id","ToTag", driver).clear();
        enterText("id","ToTag", driver, "Delhi");
        waitFor(4000, driver);
        //select the first item from the destination auto complete list
        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        destinationOptions.get(0).click();

        clickOnElement("xpath","//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a",
                driver);

        //all fields filled in. Now click on search
        clickOnElement("id","SearchBtn",driver);
        waitFor(5000, driver);
    }

    public boolean isFlightBooked(){
        return isElementPresent("classname","searchSummary",driver);
    }
}
