package pages.adminarea;

import org.openqa.selenium.By;
import pages.utils.Browser;

public class AdminLogin {
    public static void goTo() {
        Browser.driver.get("http://shop.pragmatic.bg/admin");
    }

    public static void login(String username, String password) {
        Browser.driver.findElement(By.id("input-username")).sendKeys(username);
        Browser.driver.findElement(By.id("input-password")).sendKeys(password);
        Browser.driver.findElement(By.cssSelector(".btn-primary")).click();
    }
}
