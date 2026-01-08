package org.jhotdraw.app;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

public class WhenOpeningView extends Stage<WhenOpeningView> {

    @ExpectedScenarioState
    TestApplication app;

    public WhenOpeningView a_new_view_is_opened() {
        app.openNewView(); // opens the second view
        return self();
    }
}
