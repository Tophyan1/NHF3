package homework.model;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {


    @Test
    public void ctorTest() {
        Point p = new Point(3, 4);
    }

    @Test
    public void distanceTest() {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(4, 11);
        Assert.assertEquals(8.246211, p1.distanceTo(p2), 1e-5);
    }

    @Test
    public void vectorToPointTest() {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(4, 5);
        Vector v = p1.vectorTo(p2);
    }
}