package wildcards.bounded;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by tomi on 1/31/17.
 */
public class Client {

    public static void main(final String[] args) {
        final Canvas c = new Canvas();

        final List<Shape> shapes = Arrays.asList(new Circle(1L, 2L, 3L),
                new Rectangle(1L, 2L, 5L, 7L));


        c.drawAll(shapes);

        c.addRectangle(new ArrayList<>(shapes), new Rectangle(5L, 6L, 9L, 10L));

        c.drawAll(shapes);
        Collections.shuffle();
    }

    // void aMethod(List⟨? extends Number⟩ list) {...}
    //we cannot write (anything but null) to the list,
    // since the actual element type is unknown, but we are now allowed to read Numbers from it
    //Number num = list.get(0);
    //lits.add(new Double(0,0));

}
