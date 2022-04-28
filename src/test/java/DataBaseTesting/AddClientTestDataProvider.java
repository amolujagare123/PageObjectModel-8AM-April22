package DataBaseTesting;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Menu;
import utility.DoLogin;

import java.io.IOException;

import static utility.DataProvider.getMyData;

public class AddClientTestDataProvider extends DoLogin {


    @Test (dataProvider = "getData")
    public void addClientTest(String name,String surname,
                              String language,String add1,
                              String add2,String city,
                              String state,String zip,
                              String country,String gender,
                              String birthDate,String phone,
                              String fax,String mobile,
                              String email,String web,
                              String vat,String tax,
                              String expected, String xpathActual,String assertionType) {
        Menu menu = new Menu(driver);
        menu.clickAddCient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName(name);
        addClient.setClientSurname(surname);
        addClient.setLanguage(language);
        addClient.setClientAdd1(add1);
        addClient.setClientAdd2(add2);
        addClient.setClientCity(city);
        addClient.setClientState(state);
        addClient.setClientZip(zip);
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setBirthDate(birthDate);
        addClient.setClientPhone(phone);
        addClient.setClientFax(fax);
        addClient.setClientMobile(mobile);
        addClient.setClientEmail(email);
        addClient.setClientWeb(web);
        addClient.setClientVat(vat);
        addClient.setClientTax(tax);
        addClient.clickBtnSave();

        String actual = "";
        switch (assertionType) {

            case "textVerify":


                try {
                    actual = driver.findElement(By.xpath(xpathActual)).getText();
                } catch (Exception e) {

                }
                Assert.assertEquals(actual, expected, "wrong output");

                break;

            case "titleVerify": actual = driver.getTitle();
                Assert.assertEquals(actual, expected, "wrong output");
                break;

            case "urlContains": actual = driver.getCurrentUrl();
                    boolean result = actual.contains(expected);
                    Assert.assertTrue(result);
                break;
        }
    }
    @DataProvider
    public Object[][] getData() throws IOException {
        return getMyData("Data/InvoicePlaneData.xlsx","Sheet1");
    }
}
