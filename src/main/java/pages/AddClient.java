package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {

    @FindBy(xpath="//input[@id='client_name']")
    WebElement clientName;

    public void setClientName(String name)
    {
        clientName.sendKeys(name);
    }

    @FindBy (xpath="//input[@id='client_surname']")
    WebElement clientSurname;

    public void setClientSurname(String surname)
    {
        clientSurname.sendKeys(surname);
    }

    @FindBy (xpath="//input[@id='client_address_1']")
    WebElement clientAddress1;

    public void setClientAdd1(String address)
    {
        clientAddress1.sendKeys(address);
    }

    @FindBy (xpath="//input[@id='client_address_2']")
    WebElement clientAddress2;

    public void setClientAdd2(String address)
    {
        clientAddress2.sendKeys(address);
    }

    @FindBy (xpath="//input[@id='client_city']")
    WebElement clientCity;

    public void setClientCity(String city)
    {
        clientCity.sendKeys(city);
    }

    @FindBy (xpath="//input[@id='client_state']")
    WebElement clientState;

    public void setClientState(String state)
    {
        clientState.sendKeys(state);
    }


    @FindBy (xpath="//input[@id='client_zip']")
    WebElement clientZip;

    public void setClientZip(String zip)
    {
        clientZip.sendKeys(zip);
    }

    @FindBy (xpath="//input[@id='client_phone']")
    WebElement clientPhone;

    public void setClientPhone(String phone)
    {
        clientPhone.sendKeys(phone);
    }

    @FindBy (xpath="//input[@id='client_fax']")
    WebElement clientFax;

    public void setClientFax(String fax)
    {
        clientFax.sendKeys(fax);
    }

    @FindBy (xpath="//input[@id='client_mobile']")
    WebElement clientMobile;

    public void setClientMobile(String mobile)
    {
        clientMobile.sendKeys(mobile);
    }

    @FindBy (xpath="//input[@id='client_email']")
    WebElement clientEmail;

    public void setClientEmail(String email)
    {
        clientEmail.sendKeys(email);
    }

    @FindBy (xpath="//input[@id='client_web']")
    WebElement clientWeb;

    public void setClientWeb(String web)
    {
        clientWeb.sendKeys(web);
    }

    @FindBy (xpath="//input[@id='client_vat_id']")
    WebElement clientVat;

    public void setClientVat(String vat)
    {
        clientVat.sendKeys(vat);
    }

    @FindBy (xpath="//input[@id='client_tax_code']")
    WebElement clientTax;

    @FindBy(xpath = "//input[@id='client_active']")
    public WebElement activeCheckbox;

    public void setClientTax(String tax)
    {
        clientTax.sendKeys(tax);
    }

    @FindBy (xpath="//button[@id='btn-submit']")
    WebElement btnSave;

    public void clickBtnSave()
    {
        btnSave.click();
    }

    @FindBy (xpath="//span[@id='select2-client_language-container']")
    WebElement containerLanguage;

    @FindBy (xpath="//input[@role='searchbox']")
    WebElement searchBox;


    WebDriver driver;
    public void setLanguage(String language)
    {

        containerLanguage.click();
        searchBox.sendKeys(language);

        driver.findElement(By.xpath("//li[normalize-space()='"+language+"']")).click();
    }

    @FindBy (xpath="//span[@id='select2-client_country-container']")
    WebElement containerCountry;

    public void setCountry(String country)
    {
        containerCountry.click();
        searchBox.sendKeys(country);
        driver.findElement(By.xpath("//li[normalize-space()='"+country+"']")).click();
    }

    @FindBy (xpath="//span[@id='select2-client_gender-container']")
    WebElement containerGender;

    public void setGender(String gender)
    {
        containerGender.click();
        driver.findElement(By.xpath("//li[normalize-space()='"+gender+"']")).click();
    }
    @FindBy (xpath="//input[@id='client_birthdate']")
    WebElement birthDate;

    public void setBirthDate(String bdate)
    {
       // birthDate.sendKeys(bdate);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+bdate+"')",birthDate);
    }


    public AddClient(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

}
