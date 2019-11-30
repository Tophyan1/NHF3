package homework;

import java.util.ArrayList;
import java.util.LinkedList;

public class Level {
    private MovingParticle part;
    transient private LinkedList<Particle> partList;
    private ArrayList<Area> walls;
    private Area goal;
    private int LevelNumber;
    private int tryNumber = 0;

    public Level(String fileName) {
        //TODO
    }

    public MovingParticle getPart() {
        return part;
    }

    public LinkedList<Particle> getPartList() {
        return partList;
    }

    public ArrayList<Area> getWalls() {
        return walls;
    }

    public Area getGoal() {
        return goal;
    }

    public int getLevelNumber() {
        return LevelNumber;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public void addTry() {
        tryNumber++;
    }

    public int numberOfParticles() {
        return partList.size();
    }

    public int scoreUponWin() {
        return (int) ((10.0 / (double) tryNumber) * (3000 + (21 - numberOfParticles()) * 500));
    }

    public void addParticle(Particle p) {
        partList.add(p);
    }

    void removeParticle(Particle p) {
        partList.remove(p);
    }

    public Point sumForce() {
        Point force = new Point(0, 0);
        for (Particle particle : partList) {
            force.addPoint(particle.exertForceTo(part));
        }
        return force;
    }
}
