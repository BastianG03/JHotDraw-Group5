package org.jhotdraw.app;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 * BDD-style tests for AbstractApplication using JGiven.
 * Tests the openNewView() behavior with Given-When-Then scenarios.
 */
public class AbstractApplicationBDDTest extends ScenarioTest<GivenApplicationState, WhenApplicationAction, ThenApplicationState> {

    @Test
    public void opening_multiple_views_creates_multiple_views() {
        given().a_fresh_application();
        when().I_open_$_new_views(3);
        then().the_application_should_have_$_views(3);
    }

    @Test
    public void last_opened_view_is_the_active_view() {
        given().a_fresh_application();
        when().I_open_$_new_views(2);
        then().the_last_opened_view_should_be_active();
    }

    @Test
    public void opening_a_view_creates_a_new_view() {
        given().a_fresh_application();
        when().I_open_a_new_view();
        then().a_view_should_be_created();
    }

    @Test
    public void opening_a_view_sets_it_as_active() {
        given().a_fresh_application();
        when().I_open_a_new_view();
        then().the_application_should_have_$_views(1)
                .and()
                .the_last_opened_view_should_be_active();
    }

    @Test
    public void application_starts_with_no_views() {
        given().a_fresh_application();
        then().the_application_should_have_no_views();
    }
}
