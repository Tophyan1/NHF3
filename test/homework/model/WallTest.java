package homework.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WallTest {


    @Test
    public void collisionTest1() {
        Wall wall = new Wall(0, 0, 1, 1);
        MovableParticle particle = new MovableParticle(new Point(50, 4), -1);
        assertFalse(wall.didCollide(particle));
    }

    @Test
    public void collisionTest2() {
        Wall wall = new Wall(0, 0, 5, 5);
        MovableParticle particle = new MovableParticle(new Point(-9, 3), 1);
        assertTrue(wall.didCollide(particle));
    }

    @Test
    public void collisionTest3() {
        Wall wall = new Wall(0, 0, 30, 30);
        MovableParticle particle = new MovableParticle(new Point(15, 15), 6);
        assertTrue(wall.didCollide(particle));
    }
}