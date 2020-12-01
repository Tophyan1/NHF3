package homework.model;

import org.junit.Assert;
import org.junit.Test;

public class MovableParticleTest {

    @Test
    public void moveTest() {
        MovableParticle p = new MovableParticle(new Point(0, 0), 1, new Vector(0, 0), 1.28);
        Vector force = new Vector(10, 4);
        double t = 2.4;
        p.move(force, t);
        Assert.assertEquals(45, p.getPosition().getX(), 1e-5);
        Assert.assertEquals(18, p.getPosition().getY(), 1e-5);
    }

    @Test
    public void moveTestWithStartingVelocity() {
        MovableParticle p = new MovableParticle(new Point(0, 0), 1, new Vector(2, 8), 1.28);
        Vector force = new Vector(10, 4);
        double t = 2.4;
        p.move(force, t);
        Assert.assertEquals(49.8, p.getPosition().getX(), 1e-5);
        Assert.assertEquals(37.2, p.getPosition().getY(), 1e-5);
    }
}