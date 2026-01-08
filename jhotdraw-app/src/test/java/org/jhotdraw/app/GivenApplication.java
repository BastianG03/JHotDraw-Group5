package org.jhotdraw.app;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class GivenApplication extends Stage<GivenApplication> {

    @ProvidedScenarioState
    TestApplication app;

    public GivenApplication an_application_with_one_open_view() {
        app = new TestApplication();
        app.setModel(new FakeApplicationModel());
        app.openNewView(); // opens the first view
        return self();
    }
}
