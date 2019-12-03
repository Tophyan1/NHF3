package homework.model;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;


public class Game implements Drawable, Serializable {
    private static final long serialVersionUID = -2363365680917184571L;
    private ArrayList<Level> levels;
    private int currentLevelIndex = 0;
    private transient boolean isGameOver = false;
    private transient boolean isFailed = false;


    public Game() {
        levels = new ArrayList<>();
        Level level1 = new Level("resources/Levels/Level_1.dat");
        Level level2 = new Level("resources/Levels/Level_2.dat");
        Level level3 = new Level("resources/Levels/Level_3.dat");
        Level level4 = new Level("resources/Levels/Level_4.dat");
        Level level5 = new Level("resources/Levels/Level_5.dat");
        levels.add(level1);
        levels.add(level2);
        levels.add(level3);
        levels.add(level4);
        levels.add(level5);
    }

    public void step(double deltaTime) {
        int ref = levels.get(currentLevelIndex).getTryNumber();
        levels.get(currentLevelIndex).step(deltaTime);
        if (ref != levels.get(currentLevelIndex).getTryNumber()) {
            isFailed = true;
            return;
        }
        if (levels.get(currentLevelIndex).isFinished() && this.hasMoreLevels()) {
            currentLevelIndex++;
        } else {
            isGameOver = true;
        }

    }

    public void addParticle(Point p, double charge) {
        levels.get(currentLevelIndex).pushParticle(new Particle(p, charge));
    }

    @Override
    public void draw(Graphics g) {
        levels.get(currentLevelIndex).draw(g);
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    private boolean hasMoreLevels() {
        return currentLevelIndex < levels.size();
    }

    public boolean isFailed() {
        return isFailed;
    }

    public void save(String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(levels);
            oos.writeObject(currentLevelIndex);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            levels = (ArrayList<Level>) ois.readObject();
            currentLevelIndex = (int) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        isGameOver = false;
        isFailed = false;
    }
}
