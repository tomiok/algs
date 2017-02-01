package wildcards.bounded;

import java.util.List;

/**
 * Created by tomi on 1/31/17.
 */
public class Canvas {

    public void draw(final Shape s) {
        s.draw(this);
    }

    public void drawAll(final List<? extends Shape> shapes) { // Shape is the upper bound of the wildcard.
        for (final Shape s : shapes) {
            s.draw(this);
        }
    }

    // If we use <? extends Shape> an unknown subtype of Shape. Since we don't know what type it is, we don't know
    // if it is a supertype of Rectangle; it might or might not be such a supertype,
    // so it isn't safe to pass a Rectangle there.
    public void addRectangle(final List<? super Shape> shapes, final Rectangle r) {
        shapes.add(r);
    }


}
