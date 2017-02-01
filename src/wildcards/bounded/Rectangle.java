package wildcards.bounded;

/**
 * Created by tomi on 1/31/17.
 */
public class Rectangle extends Shape {

    private long x, y, height, width;

    public Rectangle(long x, long y, long height, long width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    @Override
    protected void draw(final Canvas canvas) {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rectangle{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append('}');
        return sb.toString();
    }
}
