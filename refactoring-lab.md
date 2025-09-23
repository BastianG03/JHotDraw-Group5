
## Refactor idea
All of the setBounds methods of classes derived from RectangularShape seem to be largely the same.
They do however all depend on different implementations of the same idea of a Double implementation of each shape. These are all contained within awt, so I cant do anything about those.

## Implementation
I have added an abstract class in between all the figures that use a rectangularshape. It is called AbstractAttributedRectangularFigure. It extends AbstractAttributedFigure, and implements the setBounds method in the way all the duplicates do.

The refactor works, and reduces duplicate code.
It uses generalization by extracting a method up the inheritance tree, to get rid of duplicate methods
