package org.jhotdraw.draw.figure;

import org.jhotdraw.geom.Dimension2DDouble;

import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

public abstract class AbstractAttributedRectangularFigure extends AbstractAttributedFigure {

    protected final RectangularShape rectangularShape;

    protected AbstractAttributedRectangularFigure(RectangularShape rectangularShape) {
        this.rectangularShape = rectangularShape;
    }

    @Override
    public void setBounds(Point2D.Double anchor, Point2D.Double lead) {
        double x = Math.min(anchor.x, lead.x);
        double y = Math.min(anchor.y, lead.y);
        double width = Math.max(0.1, Math.abs(lead.x - anchor.x));
        double height = Math.max(0.1, Math.abs(lead.y - anchor.y));

        rectangularShape.setFrame(new Point2D.Double(x, y), new Dimension2DDouble(width, height));
    }
}
