import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelBookingPage;

public class HotelBookingTest extends BaseClass {

    @Test
    public void shouldBeAbleToSearchForHotels() {
        HotelBookingPage hotelBookingPage = new HotelBookingPage(driver);
        hotelBookingPage.searchForHotel();
        Assert.assertTrue(hotelBookingPage.isHotelsShowing());
    }
}
