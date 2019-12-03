package homework.model;

public class Goal extends Rectangle {


    private static final long serialVersionUID = -1798537072646776227L;

    public Goal(double x, double y, double height, double width, Level level) {
        super(x, y, height, width, level);
    }

    public Goal(double x, double y, double height, double width) {
        super(x, y, height, width);
    }

    @Override
    public void onCollide() {
        level.finishLevel();
    }
}
