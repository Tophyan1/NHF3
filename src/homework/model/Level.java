package homework.model;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Level implements Serializable, Drawable {

    private static final long serialVersionUID = 4695694190538321899L;
    private MovableParticle movableParticle;
    private ArrayList<Collidable> collidables;
    private transient LinkedList<Particle> particles;
    private transient boolean isFinished = false;
    private transient String fileName;
    private int tryNumber = 1;

    public Level(String fileName) {
        this.load(fileName);
        initCollidables();
    }

    public Level(MovableParticle movableParticle, ArrayList<Collidable> collidables, LinkedList<Particle> particles) {
        this.movableParticle = movableParticle;
        this.collidables = collidables;
        this.particles = particles;
        initCollidables();
    }

    private void initCollidables() {
        for (Collidable collidable : collidables) {
            collidable.setLevel(this);
        }
    }

    public void pushParticle(Particle p) {
        particles.add(p);
    }

    public Particle popParticle() {
        return particles.pop();
    }

    public void step(double deltaTime) {
        Vector force = sumForces();
        movableParticle.move(force, deltaTime);
        checkCollisions();
    }

    public void reset() {
        this.load(fileName);
        tryNumber++;
        this.save(fileName);
    }

    public void finishLevel() {
        isFinished = true;
    }

    public boolean isFinished() {
        return isFinished;
    }

    private void checkCollisions() {
        for (Collidable collidable : collidables) {
            if (collidable.didCollide(movableParticle)) {
                collidable.onCollide();
            }
        }
    }

    private Vector sumForces() {
        Vector force = new Vector(0, 0);
        for (Particle particle : particles) {
            force.addVector(particle.calculateForce(movableParticle));
        }
        return force;
    }

    public MovableParticle getMovableParticle() {
        return movableParticle;
    }

    public void save(String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(movableParticle);
            oos.writeObject(collidables);
            oos.writeObject(tryNumber);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            movableParticle = (MovableParticle) ois.readObject();
            collidables = (ArrayList<Collidable>) ois.readObject();
            tryNumber = (int) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        particles = new LinkedList<>();
        isFinished = false;
        this.fileName = fileName;
    }

    @Override
    public void draw(Graphics g) {
        movableParticle.draw(g);
        for (Collidable collidable : collidables) {
            ((Rectangle) collidable).draw(g);
        }
        for (Particle particle : particles) {
            particle.draw(g);
        }
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
