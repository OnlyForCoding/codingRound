import Utils.Util;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by dell on 12/7/18.
 */
public class BaseClass {

    public WebDriver driver;
    Util util;

    @BeforeClass
    public void init(){
        util = new Util();
        driver = util.getDriver("chrome");
        util.getUrl();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
