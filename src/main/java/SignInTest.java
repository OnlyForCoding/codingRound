import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;

public class SignInTest extends BaseClass {


    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
        Login login = new Login(driver);
        login.login();
        Assert.assertTrue(login.getErrorMessageForLogin().contains("There were errors in your submission"));
    }

}
