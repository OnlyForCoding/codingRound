import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightBooking;

import java.util.List;

public class FlightBookingTest extends BaseClass{

    @Test
    public void testThatResultsAppearForAOneWayJourney() {
        FlightBooking flightBooking = new FlightBooking(driver);
        flightBooking.bookFlight();
        Assert.assertTrue(flightBooking.isFlightBooked());
    }
}
