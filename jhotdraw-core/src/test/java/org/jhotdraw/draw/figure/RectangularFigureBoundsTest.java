package org.jhotdraw.draw.figure;

import org.junit.Test;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class RectangularFigureBoundsTest {

    public RectangularFigureBoundsTest() {

    }

    @Test
    public void testSetBounds() {
        EllipseFigure ellipse = new EllipseFigure(0, 0, 10, 10);

        ellipse.setBounds(new Point2D.Double(-10d, -10d), new Point2D.Double(10d, 10d));

        Rectangle2D.Double bounds = ellipse.getBounds();

        assert bounds.getWidth() == 20d;
        assert bounds.getHeight() == 20d;
    }


}
