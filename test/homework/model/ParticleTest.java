package homework.model;

import org.junit.Assert;
import org.junit.Test;

public class ParticleTest {

    @Test
    public void forceTestMagnitude() {
        Particle p1 = new Particle(new Point(1, 2), -1);
        Particle p2 = new Particle(new Point(15, 7), -1);
        Vector F = p1.calculateForce(p2);
        Assert.assertEquals(14.8660687, p1.position.distanceTo(p2.position), 1e-5);
        Assert.assertEquals(40667647.31771273, F.length(), 1e5);
    }

    @Test
    public void forceTestDirection() {
        Particle p1 = new Particle(new Point(0, 0), -1);
        Particle p2 = new Particle(new Point(0, 5), -1);
        Vector F = p1.calculateForce(p2);
        F.normalize();
        Assert.assertEquals(0, F.getX(), 1e-5);
        Assert.assertEquals(1, F.getY(), 1e-5);
    }
}