package homework.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

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

    public static ArrayList<Player> readHallOfFame() {
        ArrayList<Player> hallOfFame = new ArrayList<>();
        try {
            FileReader fr = new FileReader("resources/HallOfFame.txt");
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < 10; ++i) {
                Player p = new Player("", 0);
                p.loadFromText(br);
                hallOfFame.add(p);
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hallOfFame;
    }

    public static void writeHallOfFame(ArrayList<Player> hallOfFame) {
        hallOfFame.sort(Comparator.comparingInt(player -> -player.score));
        try {
            FileWriter fw = new FileWriter("resources/HallOfFame.txt");
            for (int i = 0; i < 10; ++i) {
                hallOfFame.get(i).saveToText(fw);
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToText(FileWriter fw) {
        try {
            fw.write(this.score + ";" + this.name + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromText(BufferedReader br) {
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (line == null)
            return;
        String[] tokens = line.split(";");
        this.score = Integer.parseInt(tokens[0]);
        this.name = tokens[1];
    }

}
