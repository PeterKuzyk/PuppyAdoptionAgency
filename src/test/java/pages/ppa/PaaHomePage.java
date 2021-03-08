package pages.ppa;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class PaaHomePage extends Page {

    @FindBy(xpath = "//h1[contains(text(),'Puppy List')]")
    private WebElement listName;

    @FindBy(xpath = "//h3[contains(text(),'\" + value + \"')]")
    private WebElement nameOfPappy;

    @FindBy(id = "notice")
    private WebElement thankYou;

    public PaaHomePage() {
        url = "http://puppies.herokuapp.com/";
        title = "Sally's Puppy Adoption Agency";
    }

    public void clickAdoptPuppy(String value) {
        getByXpath("//a[contains(text(),'" + value + "')]").click();
    }

    public boolean listNamePresent(String value) {
        if (!listName.getText().equals(value)) {
            return false;
        } else {
            return true;
        }
    }

    public void clickViewDetails(String value) {
        getByXpath("//h3[contains(text(),'" + value + "')]/../..//input[@class='rounded_button']").click();
    }

    public void orderPleasedSuccessfully(String value) {
        Assert.assertEquals(thankYou.getText(), value);
    }


}