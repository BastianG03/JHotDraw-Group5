package org.jhotdraw.app;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.assertj.core.api.Assertions;

/**
 * JGiven Then stage for asserting application state using AssertJ.
 */
public class ThenApplicationState extends Stage<ThenApplicationState> {

    @ExpectedScenarioState
    TestApplication app;

    public ThenApplicationState the_application_should_have_no_views() {
        Assertions.assertThat(app.getViews())
                  .as("Application should have no views")
                  .isEmpty();
        return self();
    }

    public ThenApplicationState the_application_should_have_$_views(int count) {
        Assertions.assertThat(app.getViews())
                  .as("Application should have %s views", count)
                  .hasSize(count);
        return self();
    }

    public ThenApplicationState the_last_opened_view_should_be_active() {
        Assertions.assertThat(app.getViews())
                  .as("There should be at least one view to have an active view")
                  .isNotEmpty();

        Assertions.assertThat(app.getActiveView())
                  .as("Last opened view should be the active view")
                  .isSameAs(app.getViews().get(app.getViews().size() - 1));

        return self();
    }

    public ThenApplicationState a_view_should_be_created() {
        Assertions.assertThat(app.getViews())
                  .as("A view should be created")
                  .isNotEmpty();
        return self();
    }
}
