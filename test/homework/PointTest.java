package homework;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PointTest {

    private Point p1, p2, p3, p4;

    @Before
    public void setUp() throws Exception {
        p1 = new Point(1,0);
        p2 = new Point(0,1);
        p3 = new Point(4,4);
        p4 = new Point(3,5);
    }

    @Test
    public void distance() {
        double d = p3.distance(p2);
        Assert.assertEquals(5, d,  1e-5);
    }

    @Test
    public void angleTo() {
        Assert.assertEquals(0.75 * Math.PI, p1.angleTo(p2), 1e-5);
    }

    @Test
    public void scale() {
        Point p = new Point(21, 35);
        p4.scale(7);
        Assert.assertEquals(p4, p);
    }

    @Test
    public void addPoint() {
        Point p = new Point(1, 1);
        Assert.assertEquals(p, p1.addPoint(p2));
    }

    @Test
    public void subtractPoint() {
        Point p = new Point(-1, 1);
        Assert.assertEquals(p, p4.subtractPoint(p3));
    }
}