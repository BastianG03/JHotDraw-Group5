package org.jhotdraw.draw.figure.jgiven;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.figure.EllipseFigure;

import java.awt.geom.Point2D;

public class WhenSetBounds extends Stage<WhenSetBounds> {
    @ExpectedScenarioState
    private EllipseFigure ellipse;

    public WhenSetBounds bounds_are_set_to(Point2D.Double anchor, Point2D.Double lead) {
        ellipse.setBounds(anchor, lead);
        return self();
    }

}
