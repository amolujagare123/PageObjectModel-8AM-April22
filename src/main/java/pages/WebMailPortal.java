package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebMailPortal {

    @FindBy(xpath="//input[@id='address']")
    WebElement emailUser;

    @FindBy (xpath="//input[@id='password']")
    WebElement emailPassword;

    @FindBy (xpath="//button[@id='webmailLogin']")
    WebElement emailSignIn;

    public WebMailPortal(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setEmailUser(String email)
    {
        emailUser.sendKeys(email);
    }

    public void setEmailPassword(String password)
    {
        emailPassword.sendKeys(password);
    }

    public void clickSignIn()
    {
        emailSignIn.click();
    }
}
