package homework;

import java.io.*;

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

    public void reset() {
        score = 0;
        name = "";
    }

    public void loadFromText(BufferedReader br) {
        String line = null;
        try {
            line = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] tokens = line.split(";");
        this.score = Integer.parseInt(tokens[0]);
        this.name = tokens[1];
    }

    public void saveToText(FileWriter fw) {
        try {
            fw.write(this.score + ";" + this.name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
