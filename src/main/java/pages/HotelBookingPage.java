package pages;

import Utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by ChelseaCFC on 7/12/2018.
 */
public class HotelBookingPage extends Util {

    private WebDriver driver;

    public HotelBookingPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchForHotel(){
        clickOnElement("link_text","Hotels", driver);
        enterText("id","Tags",driver,"Indiranagar, Bangalore");
        waitFor(4000,driver);

        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        destinationOptions.get(1).click();

        clickOnElement("xpath","//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[3]/td[5]/a",
                driver);

        waitFor(2000,driver);

        clickOnElement("xpath",
                "//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[3]/td[6]/a",
                driver);

        new Select(getWebElement("id","travellersOnhome", driver))
                .selectByVisibleText("1 room, 2 adults");

        clickOnElement("id","SearchHotelsButton",driver);

    }

    public boolean isHotelsShowing(){
        return isElementPresent("xpath",".//div[@class='resultsCont']//nav[@class='hotelsList']"
        ,driver);
    }
}
