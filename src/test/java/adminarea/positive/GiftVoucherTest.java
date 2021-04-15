package adminarea.positive;

import adminarea.core.BaseTest;
import org.testng.annotations.Test;
import pages.adminarea.AdminLogin;
import pages.adminarea.AdminVoucher;

public class GiftVoucherTest extends BaseTest {

    @Test
    public void GiftVoucher(){
        AdminLogin.goTo();
        AdminLogin.login("admin12","parola123!");

        AdminVoucher.navigate();
        AdminVoucher.deleteIfExist("GeriV");
        AdminVoucher.create("BIG50","StoyanV","stoyanv@holyfoolz.com","GeriV","geriv@holyfoolz.com","120");

        AdminVoucher.verifySuccessfullyCreatedVoucher("Success: You have modified vouchers!");

    }
}
