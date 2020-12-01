package homework.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;


/**
 * A class perpesenting a player, having a name and a score
 */
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

    /**
     * Returns a list of players currently in the Hall of Fame
     *
     * @return the list of Champions in the Hall of Fame
     */
    public static ArrayList<Player> readHallOfFame() {
        ArrayList<Player> hallOfFame = new ArrayList<>();
        try {
            FileReader fr = new FileReader("resources/HallOfFame.txt");
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < 10; ++i) {
                Player p = new Player("", 0);
                p.loadFromText(br);
                hallOfFame.add(p);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hallOfFame;
    }

    /**
     * Writes the top 10 players to the Hall of Fame
     *
     * @param hallOfFame the list of players who competed
     */
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

    /**
     * Saves the player to a text file
     *
     * @param fw the file stream
     */
    public void saveToText(FileWriter fw) {
        try {
            fw.write(this.score + ";" + this.name + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the player from a text file
     *
     * @param br the file stream
     */
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
