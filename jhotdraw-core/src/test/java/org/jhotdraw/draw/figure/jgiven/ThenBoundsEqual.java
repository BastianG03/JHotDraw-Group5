package org.jhotdraw.draw.figure.jgiven;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.figure.EllipseFigure;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ThenBoundsEqual extends Stage<ThenBoundsEqual> {
    @ExpectedScenarioState
    private EllipseFigure ellipse;

    public ThenBoundsEqual height_and_width_equal(Double height, Double width) {
        Rectangle2D.Double bounds = ellipse.getBounds();

        assert (bounds.getHeight() == height && bounds.getWidth() == width);

        return self();
    }
}
