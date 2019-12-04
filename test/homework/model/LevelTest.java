package homework.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

public class LevelTest {
    Level level;

    @Before
    public void setUp() {
        level = new Level("resources/Levels/Level_2.dat");
        Timer t = new Timer(20, null);
        level.setTimer(t);
    }

    @Test
    public void moveParticleToGoal() {
        level.getMovableParticle().setPosition(new Point(1200, 300));
        level.step(1e-4);
        Assert.assertTrue(true);
    }

}