package pages;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ppa.PaaCartPage;
import pages.ppa.PaaDetailsPage;
import pages.ppa.PaaHomePage;
import pages.ppa.PaaOrderFormPage;

public class PaaStepsDefs {

    PaaHomePage home = new PaaHomePage();
    PaaOrderFormPage formPage = new PaaOrderFormPage();
    PaaDetailsPage detailsPage = new PaaDetailsPage();
    PaaCartPage cartPage = new PaaCartPage();

    @Given("I open {string} page")
    public void iOpenPage(String page) {
        switch (page) {
            case "PAA":
                PaaHomePage paa = new PaaHomePage();
                paa.open();
                break;
            default:
                throw new RuntimeException("Unknown page: " + page);
        }
    }

    @When("I click on {string}")
    public void iClickOn(String list) {
        home.clickAdoptPuppy(list);
    }

    @And("I validate {string} present")
    public void iValidatePresent(String name) {
        home.listNamePresent(name);
    }

    @When("I click More Details button for {string}")
    public void iClickMoreDetailsButtonFor(String name) {
        home.clickViewDetails(name);
    }

    @And("I validate {string} details page opens")
    public void iValidateDetailsPageOpens(String value) {
        detailsPage.verifyMoreDetailsPageOpens(value);
    }

    @And("I click Adopt Me! button")
    public void iClickAdoptMeButton() {
        detailsPage.clickAdoptMe();
    }

    @Then("I validate I add {string} to my cart")
    public void iValidateIAddToMyCart(String name) {
        cartPage.soppingCardHeader();
        cartPage.isPuppyInCart(name);
    }

    @And("I click {string} button in my cart")
    public void iClickButtonInMyCart(String button) {
        cartPage.clickCompleteAdoption(button);
    }

    @Then("I fill out {string} name, {string} address, {string} email, {string} payment")
    public void iFillOutNameAddressEmailPayment(String name, String address, String email, String payment) {
        formPage.fillName(name);
        formPage.fillAddress(address);
        formPage.fillEmail(email);
        formPage.selectPayment(payment);
        formPage.placeOrder();
    }

    @And("I verify message {string} is present")
    public void iVerifyMessageIsPresent(String value) {
        home.orderPleasedSuccessfully(value);
    }
}

