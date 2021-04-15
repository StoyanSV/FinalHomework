package adminarea.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.utils.Browser;

public class BaseTest {
    @BeforeMethod
    public void setup(){ Browser.setup();}

    @AfterMethod
    public void quit(){ Browser.quit();}
}
