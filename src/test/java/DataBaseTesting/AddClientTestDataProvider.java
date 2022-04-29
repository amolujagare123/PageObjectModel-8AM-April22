package DataBaseTesting;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Menu;
import utility.DoLogin;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static utility.Conversion.*;
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
                              String vat,String tax) throws ClassNotFoundException, SQLException, ParseException {
        Menu menu = new Menu(driver);
        menu.clickAddCient();


        ArrayList<String> expected = new ArrayList<>();

        expected.add(name);
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(add1);
        expected.add(add2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(country);
        expected.add(gender);
        expected.add(birthDate);
        expected.add(phone);
        expected.add(fax);
        expected.add(mobile);
        expected.add(email);
        expected.add(web);
        expected.add(vat);
        expected.add(tax);




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

        Class.forName("com.mysql.cj.jdbc.Driver");

        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/ip";

        Connection con = DriverManager.getConnection(url,username,password);

        Statement st = con.createStatement();

        String sql = "SELECT * FROM ip_clients where client_name='"+name+"'";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            String shortCountry = rs.getString("client_country");

            String countryFull = convertCountry(shortCountry);

            actual.add(countryFull);


            actual.add(getGender(rs.getString("client_gender")));


            actual.add(convertDate(rs.getString("client_birthDate")));


            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

        System.out.println("expected="+expected);
        System.out.println("Actual="+actual);

        Assert.assertEquals(actual,expected,"data is not matching");

    }
    @DataProvider
    public Object[][] getData() throws IOException {
        return getMyData("Data/InvoicePlaneData.xlsx","DatabaseTesting");
    }
}
