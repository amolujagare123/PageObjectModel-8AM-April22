import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SampleJava {


    public static void main(String[] args) throws IOException {

        // 1. read the file in the form of object
        FileInputStream fis = new FileInputStream("Config/config.properties");

        // 2. create object of properties class
        Properties prop = new Properties();

        // 3. load properties object with file object
        prop.load(fis);

        // 4. read the value of key using getProperty() method

        System.out.println(prop.getProperty("url"));
        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));
    }

}
