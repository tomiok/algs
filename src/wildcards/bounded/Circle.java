package wildcards.bounded;

/**
 * Created by tomi on 1/31/17.
 */
public class Circle extends Shape {

    private long x, y, radius;

    public Circle(long x, long y, long radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    protected void draw(final Canvas canvas) {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
}
