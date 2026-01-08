package org.jhotdraw.draw.figure;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.jhotdraw.draw.figure.jgiven.GivenEllipsis;
import org.jhotdraw.draw.figure.jgiven.ThenBoundsEqual;
import org.jhotdraw.draw.figure.jgiven.WhenSetBounds;
import org.junit.Test;

import java.awt.geom.Point2D;

public class SetEllipseBoundsTest extends ScenarioTest<GivenEllipsis, WhenSetBounds, ThenBoundsEqual> {

    @Test
    public void testSetBounds() {
        EllipseFigure figure = new EllipseFigure(0, 0, 10, 10);
        Point2D.Double anchor = new Point2D.Double(-10, -10);
        Point2D.Double lead = new Point2D.Double(10, 10);
        Double width = 20d;
        Double height = 20d;


        given().an_ellipse(figure);
        when().bounds_are_set_to(anchor, lead);
        then().height_and_width_equal(height, width);
    }
}
