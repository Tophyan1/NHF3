package homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParticleTest {
    Particle p1;
    Particle p2;

    @Before
    public void setUp() throws Exception {
        p1 = new Particle(new Point(0, 0), 1);
        p2 = new Particle(new Point(4, 3), -1);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void distance() {
        Assert.assertEquals(5, p1.distance(p2), 1e-5);
    }

    @Test
    public void exertForceTo() {
        Point ref = new Point(-19199, -14400);
        Assert.assertEquals(ref, p1.exertForceTo(p2));
    }
}