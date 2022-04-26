package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ForgotPassword;
import pages.Login;
import pages.WebMailPortal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import static util.ConfigReader.getUrl;

public class ForgotPasswordTest {

    @Test
    public  void forgotPassTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

      //  driver.get("http://localhost/ip");
        driver.get(getUrl());

        Login login = new Login(driver);
        login.clickForgotPassword();

        ForgotPassword forgotPassword = new ForgotPassword(driver);

        forgotPassword.setTxtEmail("amolujagare@scriptinglogic.com");
        forgotPassword.clickBtnReset();

       driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://ipage.com/mail");

        WebMailPortal webMailPortal = new WebMailPortal(driver);
        webMailPortal.setEmailUser("amolujagare@scriptinglogic.com");
        webMailPortal.setEmailPassword("Amol@1234");
        webMailPortal.clickSignIn();

        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windows.get(2));


      /*  ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());

        String invoicePlaneWindow = windows.get(0);
        String newWindow = windows.get(1);

        System.out.println("invoicePlaneWindow="+invoicePlaneWindow);
        System.out.println("newWindow="+newWindow);

        driver.switchTo().window(invoicePlaneWindow);*/


       /* Set<String> windows = driver.getWindowHandles();

        System.out.println("total windows="+windows.size()) ; // 2

        Iterator itr = windows.iterator();

        String ipWindow = (String) itr.next();
        String newWindow = (String) itr.next();

        driver.switchTo().window(newWindow);*/





    }
}
