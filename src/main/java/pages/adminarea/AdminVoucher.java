package pages.adminarea;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.utils.Browser;

import java.util.List;

public class AdminVoucher {
    public static void navigate() {
        Browser.driver.findElement(By.id("menu-sale")).click();
        Browser.driver.findElement(By.cssSelector("#collapse4 a.collapsed")).click();
        Browser.driver.findElement(By.cssSelector("#menu-sale li:nth-of-type(4) li:nth-of-type(1)")).click();
    }

    public static void deleteIfExist(String recipient) {
        List<WebElement> vouchers = Browser.driver.findElements(By.cssSelector(".table tbody tr"));
        for(WebElement voucher : vouchers){
            if(voucher.getText().contains(recipient)){
                voucher.findElement(By.cssSelector("input")).click();
                Browser.driver.findElement(By.cssSelector(".btn-danger")).click();
                Browser.driver.switchTo().alert().accept();
                break;
            }
        }
    }

    public static void create(String code, String voucherFrom, String voucherFromEmail, String voucherTo, String voucherToEmail, String amount) {
        Browser.driver.findElement(By.cssSelector(".fa-plus")).click();
        Browser.driver.findElement(By.id("input-code")).sendKeys(code);
        Browser.driver.findElement(By.id("input-from-name")).sendKeys(voucherFrom);
        Browser.driver.findElement(By.id("input-from-email")).sendKeys(voucherFromEmail);
        Browser.driver.findElement(By.id("input-to-name")).sendKeys(voucherTo);
        Browser.driver.findElement(By.id("input-to-email")).sendKeys(voucherToEmail);
        Browser.driver.findElement(By.id("input-amount")).sendKeys(amount);

        Browser.driver.findElement(By.cssSelector(".fa-save")).click();

    }

    public static void verifySuccessfullyCreatedVoucher(String expectedSuccessfulVoucherText) {
        String actualSuccessfulVoucherText = Browser.driver.findElement(By.cssSelector(".alert-success")).getText();

        Assert.assertTrue(actualSuccessfulVoucherText.contains(expectedSuccessfulVoucherText));
    }
}
