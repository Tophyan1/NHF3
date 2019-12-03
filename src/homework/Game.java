package homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Game implements Serializable {
    private static final long serialVersionUID = -5420055921745751848L;
    private Player player;
    private Level level;
    boolean finished = false;

    public Game(Player player, Level level) {
        this.player = player;
        this.level = level;
    }

    public Game() {
        this.player = new Player("");
        this.level = new Level("resources/Levels/Level_1.dat");
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void save(ObjectOutputStream out) {
        player.save(out);
        level.save(out);
    }

    public void load(ObjectInputStream in) {
        player.load(in);
        level.load(in);
    }

    public void placeParticle(Point p, int charge) {
        level.addParticle(new Particle(p, charge));
    }

    public void reset(String fileName) {
        player.reset();
        level.reset(fileName);
    }

    public void updateHallOfFame() {
        ArrayList<Player> players = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader("resources/HallOfFame.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        for (int i = 0; i < 10; ++i) {
            players.add(new Player(""));
            players.get(i).loadFromText(br);
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        players.add(this.player);
        players.sort(Comparator.comparingInt(Player::getScore));
        FileWriter fw = null;
        try {
            fw = new FileWriter("resources/HallOfFame.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 11; i > 0; --i) {
            players.get(i).saveToText(fw);
        }
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void winLevel() {
        player.addScore(level.scoreUponWin());
        if (level.getLevelNumber() < 5)
            level.reset("resources/Levels/Level_" + (level.getLevelNumber() + 1) + ".dat");
        else {
            updateHallOfFame();
            finished = true;
        }
    }


}
