package homework;

public class Player {
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
}
