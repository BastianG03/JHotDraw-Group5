package org.jhotdraw.app;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;

/**
 * JGiven When stage for performing actions on the application.
 */
public class WhenApplicationAction extends Stage<WhenApplicationAction> {

    @ScenarioState
    TestApplication app;

    public WhenApplicationAction I_open_a_new_view() {
        app.openNewView();
        return self();
    }

    public WhenApplicationAction I_open_$_new_views(int count) {
        for (int i = 0; i < count; i++) {
            app.openNewView();
        }
        return self();
    }
}
