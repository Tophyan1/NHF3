package homework;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Game implements Serializable {
    private static final long serialVersionUID = -5420055921745751848L;
    private Player player;
    private Level level;

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


}
