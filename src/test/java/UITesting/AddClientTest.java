package UITesting;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Menu;
import utility.DoLogin;

public class AddClientTest extends DoLogin {

    AddClient addClient;
    @BeforeClass
    public void initAddClient()
    {
        addClient = new AddClient(driver);
        Menu menu = new Menu(driver);
        menu.clickAddCient();
    }


    @Test
    public void checkActiveSelectionCheck()
    {
        boolean expected = true;
        boolean actual = false;
        try {
             actual = addClient.activeCheckbox.isSelected();
        }
        catch (Exception e)
        {

        }
        System.out.println("expected="+expected);

        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected,"element is not selected");
    }
}
