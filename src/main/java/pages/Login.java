package pages;

import Utils.Util;
import org.openqa.selenium.WebDriver;

/**
 * Created by dell on 12/7/18.
 */
public class Login extends Util{

    private WebDriver driver;

    public Login (WebDriver driver){
        this.driver = driver;
    }

    public void login() {
        waitFor(2000, driver);
        clickOnElement("link_text", "Your trips", driver);
        clickOnElement("id", "SignIn", driver);
        switchToFrameById(driver, "modal_window");
        clickOnElement("id", "signInButton", driver);
    }

    public String getErrorMessageForLogin(){
        return getText("id","errors1",driver);
    }
}
