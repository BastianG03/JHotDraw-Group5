package org.jhotdraw.app;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class OpenNewWindowBDDTest
        extends ScenarioTest<GivenApplication, WhenOpeningView, ThenApplicationState> {

    @Test
    public void opening_a_new_view_creates_a_second_view() {

        given().an_application_with_one_open_view();

        when().a_new_view_is_opened();

        then().the_application_should_have_two_views();
        then().the_last_opened_view_should_be_active();
    }
}
