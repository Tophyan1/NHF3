package homework.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GoalTest {

    @Test
    public void collisionTest1() {
        Goal goal = new Goal(0, 0, 1, 1);
        MovableParticle particle = new MovableParticle(new Point(50, 4), -1);
        assertFalse(goal.didCollide(particle));
    }

    @Test
    public void collisionTest2() {
        Goal goal = new Goal(0, 0, 5, 5);
        MovableParticle particle = new MovableParticle(new Point(-9, 3), 1);
        assertTrue(goal.didCollide(particle));
    }

    @Test
    public void collisionTest3() {
        Goal goal = new Goal(0, 0, 30, 30);
        MovableParticle particle = new MovableParticle(new Point(15, 15), 6);
        assertTrue(goal.didCollide(particle));
    }

}