package homework;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public void save(ObjectOutputStream out) {
        try {
            out.writeObject(name);
            out.writeObject(score);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(ObjectInputStream in) {
        try {
            name = (String) in.readObject();
            score = (int) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
