package org.jhotdraw.app;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

/**
 * JGiven Given stage for setting up application state before tests.
 */
public class GivenApplicationState extends Stage<GivenApplicationState> {

    @ProvidedScenarioState
    TestApplication app;

    public GivenApplicationState a_fresh_application() {
        app = new TestApplication();
        app.setModel(new FakeApplicationModel());
        return self();
    }

    public GivenApplicationState an_application_with_one_view() {
        a_fresh_application();
        app.openNewView();
        return self();
    }

    public GivenApplicationState an_application_with_multiple_views(int count) {
        a_fresh_application();
        for (int i = 0; i < count; i++) {
            app.openNewView();
        }
        return self();
    }
}
