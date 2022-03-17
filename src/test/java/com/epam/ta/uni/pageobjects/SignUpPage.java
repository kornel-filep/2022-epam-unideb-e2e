package com.epam.ta.uni.pageobjects;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import com.epam.ta.uni.factory.WebDriverFactory;

@Component
public class SignUpPage extends CommonPageObject {

    @FindBy(css = ".EmailForm__Center-jwtojv-0 > div")
    private WebElement registrationButton;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "confirm")
    private WebElement confirmEmailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "year")
    private WebElement yearInput;

    @FindBy(id = "day")
    private WebElement dayInput;

    private final Map<String, WebElement> inputFieldsMap = Map.of(
        "Enter your email.", emailInput,
        "Enter your email again.", confirmEmailInput,
        "Create password.", passwordInput,
        "YYYY", yearInput,
        "DD", dayInput
    );

    public SignUpPage(final WebDriverFactory factory) {
        super(factory);
    }

    public void clickOnRegistrationButton() {
        waitForElementToBeClickable(registrationButton);
        registrationButton.click();
        waitForPageReadiness();
    }

    public WebElement getInputFieldByName(final String name) {
        return inputFieldsMap.get(name);
    }
}
