package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

    @FindBy(xpath="//a[normalize-space()='Dashboard']")
    WebElement dashboard;

    public void clickDashboard()
    {
        dashboard.click();
    }

    @FindBy (xpath="//span[normalize-space()='Clients']")
    WebElement clients;

    @FindBy (xpath="//a[contains(text(),'Add Client')]")
    WebElement addClients;

    public void clickAddCient()
    {
        clients.click();
        addClients.click();
    }

    @FindBy (xpath="//a[normalize-space()='View Clients']")
    WebElement viewClients;

    public void clickViewClient()
    {
        clients.click();
        viewClients.click();
    }

    @FindBy (xpath="//span[normalize-space()='Quotes']")
    WebElement quotes;

    @FindBy (xpath="//a[@class='create-quote']")
    WebElement createQuote;

    public void clickCreateQuote()
    {
        quotes.click();
        createQuote.click();
    }

    @FindBy (xpath="//a[normalize-space()='View Quotes']")
    WebElement viewQuotes;

    public void clickViewQuote()
    {
        quotes.click();
        viewQuotes.click();
    }

    public Menu(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

}
