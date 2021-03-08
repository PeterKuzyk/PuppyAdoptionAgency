package pages.ppa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.Page;

public class PaaOrderFormPage extends Page {

    @FindBy(id = "order_name")
    private WebElement name;

    @FindBy(id = "order_address")
    private WebElement address;

    @FindBy(id = "order_email")
    private WebElement email;

    @FindBy(id = "order_pay_type")
    private WebElement payment;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement submit;

    public void fillName(String value) {
        name.sendKeys(value);
    }

    public void fillAddress(String value) {
        address.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void selectPayment(String value) {
        new Select(payment).selectByValue(value);
    }

    public void placeOrder() {
        submit.click();
    }


}
