package homework.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class LevelTest {
    Level level;

    @Before
    public void setUp() {
        MovableParticle particle = new MovableParticle(new Point(50, 50), 1);
        ArrayList<Collidable> arrayList = new ArrayList<>();
        Wall wall = new Wall(100, 100, 30, 30);
        Goal goal = new Goal(200, 200, 50, 50);
        arrayList.add(wall);
        arrayList.add(goal);
        LinkedList<Particle> particleLinkedList = new LinkedList<>();
        level = new Level(particle, arrayList, particleLinkedList);
        goal.setLevel(level);
        wall.setLevel(level);
    }

    @Test
    public void moveParticleToGoal() {
        level.getMovableParticle().setPosition(new Point(225, 225));
        level.step(1);
        Assert.assertTrue(level.isFinished());
    }

    @Test
    public void moveParticleToWall() {
        level.getMovableParticle().setPosition(new Point(115, 115));
        level.step(1);
        Assert.assertEquals(50, level.getMovableParticle().getPosition().getX(), 1e-5);
        Assert.assertEquals(50, level.getMovableParticle().getPosition().getY(), 1e-5);
        Assert.assertFalse(level.isFinished());
    }
}