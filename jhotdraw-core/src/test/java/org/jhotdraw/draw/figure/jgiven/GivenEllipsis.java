package org.jhotdraw.draw.figure.jgiven;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.figure.EllipseFigure;

public class GivenEllipsis extends Stage<GivenEllipsis> {
    @ProvidedScenarioState
    protected EllipseFigure ellipse;

    public GivenEllipsis an_ellipse(EllipseFigure ellipse) {
        this.ellipse = ellipse;
        return self();
    }
}
