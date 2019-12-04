package homework.model;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;


public class Game implements Drawable, Serializable {
    private static final long serialVersionUID = -2363365680917184571L;
    private transient ArrayList<Level> levels;
    private int currentLevelIndex = 0;
    private transient boolean isGameOver = false;
    private int tries = 0;
    private int numberOfAllParticles = 0;


    public Game() {
        setUpLevels();
    }

    private void setUpLevels() {
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
        for (Level level : levels) {
            level.setGame(this);
        }
    }

    public void step(double deltaTime) {
        levels.get(currentLevelIndex).step(deltaTime);
    }

    @Override
    public void draw(Graphics g) {
        levels.get(currentLevelIndex).draw(g);
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    private boolean hasMoreLevels() {
        return currentLevelIndex < levels.size() - 1;
    }

    public void save(String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(currentLevelIndex);
            oos.writeObject(tries);
            oos.writeObject(numberOfAllParticles);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            currentLevelIndex = (int) ois.readObject();
            tries = (int) ois.readObject();
            numberOfAllParticles = (int) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        setUpLevels();
        isGameOver = false;
    }

    public Level getCurrentLevel() {
        return levels.get(currentLevelIndex);
    }

    public void nextLevel() {
        if (hasMoreLevels()) {
            currentLevelIndex++;
        } else {
            isGameOver = true;

        }
    }

    public void addTry() {
        tries += 1;
    }

    public void addToAllParticles(int number) {
        numberOfAllParticles += number;
    }

    public int getScore() {
        System.out.println(tries);
        System.out.println(numberOfAllParticles);
        return (50 / tries) * (30000 + (210 - numberOfAllParticles) * 500);
    }


}
