package homework.model;

public class Wall extends Rectangle {

    private static final long serialVersionUID = 8174863775110098761L;

    public Wall(double x, double y, double height, double width, Level level) {
        super(x, y, height, width, level);
    }

    public Wall(double x, double y, double height, double width) {
        super(x, y, height, width);
    }

    @Override
    public void onCollide() {
        level.reset();
    }
}
