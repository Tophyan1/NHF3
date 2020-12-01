package homework.model;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * A class representing a full game
 */
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

    /**
     * Loads the game from the input files
     */
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

    /**
     * Steps the game, stepping the current level
     *
     * @param deltaTime the time period the games moves through
     */
    public void step(double deltaTime) {
        levels.get(currentLevelIndex).step(deltaTime);
    }

    /**
     * Draws the game's current state on a canvas
     *
     * @param g the Graphics object used to draw
     */
    @Override
    public void draw(Graphics g) {
        levels.get(currentLevelIndex).draw(g);
    }

    /**
     * Checks if the game is finished
     *
     * @return true if the game is won, false otherwise
     */
    public boolean isGameOver() {
        return isGameOver;
    }

    /**
     * Checks if the game has more levels
     *
     * @return false if the game is at the last level, true otherwise
     */
    private boolean hasMoreLevels() {
        return currentLevelIndex < levels.size() - 1;
    }

    /**
     * Saves the game to a parameter file
     *
     * @param fileName the name of the file
     */
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

    /**
     * Loads the game from a parameter file
     *
     * @param fileName the name of the file
     */
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

    /**
     * Gets the current level
     *
     * @return the current level
     */
    public Level getCurrentLevel() {
        return levels.get(currentLevelIndex);
    }

    /**
     * Sets the current level to the next in line
     */
    public void nextLevel() {
        if (hasMoreLevels()) {
            currentLevelIndex++;
        } else {
            isGameOver = true;

        }
    }

    /**
     * Adds one to the tries
     */
    public void addTry() {
        tries += 1;
    }

    /**
     * Adds to the number of particles placed during the course of the game
     *
     * @param number the number to add
     */
    public void addToAllParticles(int number) {
        numberOfAllParticles += number;
    }

    /**
     * Calculates the score of the player upon winning the game
     *
     * @return the score
     */
    public int getScore() {
        return (50 / tries) * (30000 + (210 - numberOfAllParticles) * 500);
    }


}
