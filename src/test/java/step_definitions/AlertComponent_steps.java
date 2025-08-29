package step_definitions;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.AlertComponent;


public class AlertComponent_steps {

    private final AlertComponent alertComponent;

    public AlertComponent_steps(AlertComponent alertComponent) {
        this.alertComponent = alertComponent;
    }

    @Then("Message {string} is displayed")
    public void messageIsDisplayed(String message) {
        Assertions.assertThat(alertComponent.getAlertText()).contains(message);
    }
}

