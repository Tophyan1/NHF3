package homework;

import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = -1150707591619638389L;
    private String name;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    void addScore(int score) {
        this.score += score;
    }

    @Override
    public String toString() {
        return score + " " + name;
    }
}
