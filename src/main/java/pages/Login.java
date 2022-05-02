package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

   /* WebDriver driver;
    WebElement txtUser = driver.findElement(By.xpath("//input[@id='email']"));*/

    @FindBy (xpath="//input[@id='email']")
    public WebElement txtUsername;

    @FindBy (xpath="//input[@id='password']")
    public WebElement txtPassword;

    @FindBy (xpath="//button[normalize-space()='Login']")
    public WebElement btnLogin;

    @FindBy (xpath="//a[normalize-space()='I forgot my password']")
    public WebElement btnForgotPassword;

    @FindBy (xpath="//label[@for='email']")
    public WebElement lblEmail;


    public void clickForgotPassword()
    {
        btnForgotPassword.click();
    }

    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }


    public void setTxtUsername(String username)
    {
        txtUsername.sendKeys(username);
    }

    public void setTxtPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void clickButtonLogin()
    {
        btnLogin.click();
    }
}



