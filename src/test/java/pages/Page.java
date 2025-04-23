package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static support.TestContext.*;

public class Page {

    protected String url;
    protected String title;

    public Page() {
        PageFactory.initElements(getDriver(), this);
    }

    public void open() {
        getDriver().get(url);
    }

    protected void mouseOver(WebElement element) {
        getActions().moveToElement(element).perform();
    }

    protected void waitForVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForDisappear(WebElement element) {
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilContainsText(WebElement element) {
        getWait().until(driver -> !element.getText().isEmpty());
    }

    protected void waitToBeSelected(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeSelected(element));
    }

    protected WebElement getByXpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    protected List<WebElement> getAllByXpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    protected void click(WebElement element) {
        waitForClickable(element);
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            System.err.print("Failed clicking on element! Clicking with JS... ");
            clickWithJS(element);
        }
    }

    protected void clickWithJS(WebElement element) {
        getExecutor().executeScript("arguments[0].click()", element);
    }

    protected void sendKeys(WebElement element, String value) {
        waitForVisible(element);
        element.sendKeys(value);
    }

    protected void iAcceptAlert() {
        getDriver().switchTo().alert().accept();
    }
}