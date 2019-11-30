package homework;

import java.io.Serializable;

public class Area implements Serializable {
    private int x = 0;
    private int y = 0;
    private int height = 0;
    private int width = 0;

    public Area(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


}
