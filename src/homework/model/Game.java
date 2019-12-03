package homework.model;

import java.util.ArrayList;

public class Game {
    private ArrayList<Level> levels;
    private int currentLevelIndex = 0;
    private boolean isGameOver;

    public void step(double deltaTime) {
        levels.get(currentLevelIndex).step(deltaTime);
        if (levels.get(currentLevelIndex).isFinished() && this.hasMoreLevels()) {
            currentLevelIndex++;
        }

    }


    public boolean isGameOver() {
        return isGameOver;
    }

    private boolean hasMoreLevels() {
        return currentLevelIndex < levels.size();
    }
}
