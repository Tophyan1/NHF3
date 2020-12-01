package homework.model;

import org.junit.Assert;
import org.junit.Test;

public class VectorTest {


    @Test
    public void scaleTest() {
        Vector v = new Vector(3, 4);
        v.scale(3.5);
        Assert.assertEquals(10.5, v.getX(), 1e-5);
        Assert.assertEquals(14, v.getY(), 1e-5);
    }

    @Test
    public void vectorLengthTest() {
        Vector v = new Vector(3, 4);
        Assert.assertEquals(5, v.length(), 1e-5);
    }

    @Test
    public void normalizeVector() {
        Vector v = new Vector(4, 4);
        v.normalize();
        Assert.assertEquals(1 / Math.sqrt(2), v.getX(), 1e-5);
        Assert.assertEquals(1 / Math.sqrt(2), v.getY(), 1e-5);

    }
}