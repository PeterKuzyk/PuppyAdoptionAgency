package pages.ppa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class PaaCartPage extends Page {

    @FindBy(xpath = "//h2[normalize-space()='Your Litter']")
    private WebElement pageHeader;

    @FindBy(xpath = "//input[@value='Complete the Adoption']")
    private WebElement complete;


    public boolean soppingCardHeader() {
        if (!pageHeader.isDisplayed()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isPuppyInCart(String name) {
        if (!getByXpath("//tbody/tr/td/h2[contains(text(),'" + name + "')]").isDisplayed()) {
            return false;
        } else {
            return true;
        }
    }

    public void clickCompleteAdoption(String value) {
        getByXpath("//input[@value='" + value + "']").click();
    }


}
