package homework.view;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Player {

    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return score + " " + name;
    }

    public void loadFromText(BufferedReader br) {
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] tokens = line.split(";");
        this.score = Integer.parseInt(tokens[0]);
        this.name = tokens[1];
    }

    public void saveToText(FileWriter fw) {
        try {
            fw.write(this.score + ";" + this.name + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
