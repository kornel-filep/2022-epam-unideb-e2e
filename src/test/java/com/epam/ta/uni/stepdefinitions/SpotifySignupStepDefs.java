package com.epam.ta.uni.stepdefinitions;

import com.epam.ta.uni.config.TestConfig;
import com.epam.ta.uni.pageobjects.HomePage;
import com.epam.ta.uni.pageobjects.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.awaitility.Awaitility;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.Duration;

import static com.epam.ta.uni.config.TestConfig.PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS;

@CucumberContextConfiguration
@ContextConfiguration(classes = TestConfig.class)
public class SpotifySignupStepDefs {

    @Autowired
    private HomePage homePage;

    @Autowired
    private SignUpPage signUpPage;

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.navigateToHomePage();
    }

    @And("the Cookie disclaimer is closed")
    public void theCookieDisclaimerIsClosed() {
        homePage.clickOnCookieDisclaimer();
    }

    @And("the Regisztráció header button is clicked")
    public void theRegistrationHeaderButtonIsClicked() {
        homePage.clickOnRegistrationButton();
    }

    @Given("it is scrolled down")
    public void itIsScrolledDown() {
        signUpPage.scrollToTheBottomOfThePage();
    }

    @When("the Regisztráció button is clicked")
    public void theRegistrationButtonIsClicked() {
        signUpPage.clickOnRegistrationButton();
    }

    @And("^the '(.*)' error message of the '(?:.*)' (?:field|dropdown|radio buttons|checkbox) should be shown$")
    public void theErrorMessageShouldBeShown(final String message) {
        Awaitility.await(String.format("Element was not loaded in %s seconds", PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .atMost(Duration.ofSeconds(PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .until(() -> signUpPage.getWebDriverFromFactory().findElements(
                                By.xpath(String.format("//div[text()='%s' or ./span[text()='%s']]", message, message))
                        ).size(),
                        Matchers.is(1));
    }

    @When("the {string} is filled in with {string}")
    public void theFieldIsFilledWithParameter(final String field, final String content) {
        signUpPage.getInputFieldByName(field).sendKeys(content);
    }

    @When("the Tab button is pressed")
    public void theTabButtonIsPressed() {
        new Actions(signUpPage.getWebDriverFromFactory()).sendKeys(Keys.TAB).build().perform();
        signUpPage.waitForPageReadiness();
    }
}
