package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;
import utility.DoLogin;

import java.io.IOException;

import static util.ConfigReader.*;

public class AddClientTest extends DoLogin {
   /* WebDriver driver;
    @BeforeClass
    public void doLogin() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(getUrl());

        Login login = new Login(driver);

        login.setTxtUsername(getUsername());
        login.setTxtPassword(getPassword());
        login.clickButtonLogin();
    }*/

    @Test
    public void addClientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddCient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName("Sandip1");
        addClient.setClientSurname("Aradhye");
        addClient.setLanguage("Spanish");
        addClient.setClientAdd1("xyz");
        addClient.setClientAdd2("abcd");
        addClient.setClientCity("Pune");
        addClient.setClientState("MH");
        addClient.setClientZip("411046");
        addClient.setCountry("Israel");
        addClient.setGender("Male");
        addClient.setBirthDate("09/23/1985");
        addClient.setClientPhone("545445");
        addClient.setClientFax("545445");
        addClient.setClientMobile("545445");
        addClient.setClientEmail("a@b.com");
        addClient.setClientWeb("www.google.com");
        addClient.setClientVat("454545");
        addClient.setClientTax("989898");
        addClient.clickBtnSave();


        menu.clickViewClient();

    }
}
