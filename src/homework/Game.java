package homework;

import java.io.Serializable;

public class Game implements Serializable {
    private static final long serialVersionUID = -5420055921745751848L;
    private Player player;
    private Level level;

    public Game(Player player, Level level) {
        this.player = player;
        this.level = level;
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


}
