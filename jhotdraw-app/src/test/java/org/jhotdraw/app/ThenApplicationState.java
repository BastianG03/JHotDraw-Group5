package org.jhotdraw.app;

import static org.junit.Assert.*;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

/**
 * JGiven Then stage for asserting application state.
 */
public class ThenApplicationState extends Stage<ThenApplicationState> {

    @ExpectedScenarioState
    TestApplication app;

    public ThenApplicationState the_application_should_have_no_views() {
        assertTrue("Application should have no views", app.getViews().isEmpty());
        return self();
    }

    public ThenApplicationState the_application_should_have_$_views(int count) {
        assertEquals("Application should have " + count + " views", count, app.getViews().size());
        return self();
    }

    public ThenApplicationState the_last_opened_view_should_be_active() {
        assertEquals("Last opened view should be active",
                app.getViews().get(app.getViews().size() - 1),
                app.getActiveView());
        return self();
    }

    public ThenApplicationState a_view_should_be_created() {
        assertFalse("A view should be created", app.getViews().isEmpty());
        return self();
    }
}
