package UITesting;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import utility.OpenUrl;

public class LoginTest extends OpenUrl {

    Login login;

    @BeforeClass
    public void iinitLoginObject() {
        login = new Login(driver);
    }


    @Test
    public void txtUsernameVisibilityCheck() {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = login.txtUsername.isDisplayed();
        } catch (Exception e) {
            //  actual = false;
        }
        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);
        Assert.assertEquals(actual, expected, "element is not present");
    }

    @Test
    public void txtPasswordEnabilityCheck() {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = login.txtUsername.isEnabled();
        } catch (Exception e) {
            //  actual = false;
        }
        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);
        Assert.assertEquals(actual, expected, "element is not enabled");
    }


    @Test
    public void lblLoginSpellCheck()
    {
        String expected = "Email";

        String actual = "";
        try {
            actual = login.lblEmail.getText();
        } catch (Exception e) {
            //  actual = false;
        }
        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);

        Assert.assertEquals(actual, expected, "spelling is incorrect");
    }

    @Test
    public void txtEmailWatermarkCheck()
    {
        String expected = "Email";

        String actual = "";
        try {
            actual = login.txtUsername.getAttribute("placeholder");
        } catch (Exception e) {
            //  actual = false;
        }
        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);

        Assert.assertEquals(actual, expected, "spelling is incorrect");
    }

    @Test
    public void txtPasswordWatermarkCheck()
    {
        String expected = "Password";

        String actual = "";
        try {
            actual = login.txtPassword.getAttribute("placeholder");
        } catch (Exception e) {
            //  actual = false;
        }
        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);

        Assert.assertEquals(actual, expected, "spelling is incorrect");
    }


    @Test
    public void lblEmailFontSizeCheck()
    {
        String expected = "14px";
        String actual = "";

        try{
            actual = login.lblEmail.getCssValue("font-size");
        }
        catch (Exception e) {
            //  actual = false;
        }
        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);

        Assert.assertEquals(actual, expected, "font size is incorrect");
    }


    @Test
    public void lblEmailFontFamilyCheck()
    {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";
        String actual = "";

        try{
            actual = login.lblEmail.getCssValue("font-family");
        }
        catch (Exception e) {
            //  actual = false;
        }
        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);

        Assert.assertEquals(actual, expected, "font size is incorrect");
    }


    @Test
    public void lblEmailFontCheck()
    {
      //  String expected = "sans-serif";
        String expected = "Times new Roman";
        String actual = "";

        try{
            actual = login.lblEmail.getCssValue("font-family");
        }
        catch (Exception e) {
            //  actual = false;
        }
        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);

        boolean result = actual.contains(expected);

        Assert.assertTrue(result,"given font is not in the font family");

    }

}
