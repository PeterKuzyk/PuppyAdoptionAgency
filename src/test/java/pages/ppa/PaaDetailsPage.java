package pages.ppa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class PaaDetailsPage extends Page {

    @FindBy(xpath = "//input[@value='Adopt Me!']")
    WebElement button;

    public boolean verifyMoreDetailsPageOpens(String name) {
        if (!getByXpath("//h2[contains(text(),'" + name + "')]").getText().equals(name)) {
            return false;
        } else {
            return true;
        }
    }

    public void clickAdoptMe() {
        button.click();
    }

}
