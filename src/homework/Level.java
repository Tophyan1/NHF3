package homework;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Level implements Serializable {
    private MovingParticle part;
    transient private LinkedList<Particle> partList;
    private ArrayList<Area> walls;
    private int levelNumber;
    private Area goal;
    private int tryNumber = 0;

    public Level(String fileName) {
        part = new MovingParticle();
        partList = new LinkedList<Particle>();
        walls = new ArrayList<Area>();
        goal = new Area();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        return levelNumber;
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

    public void save(ObjectOutputStream out) {
        try {
            out.writeObject(this);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(ObjectInputStream in) {
        try {
            part = (MovingParticle) in.readObject();
            walls = (ArrayList<Area>) in.readObject();
            levelNumber = (int) in.readObject();
            goal = (Area) in.readObject();
            tryNumber = (int) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
