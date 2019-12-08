package homework.model;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Level implements Serializable, Drawable {

    private static final long serialVersionUID = 4695694190538321899L;
    private MovableParticle movableParticle;
    private ArrayList<Collidable> collidables;
    private transient LinkedList<Particle> particles;
    public transient String fileName;
    private transient Timer timer;
    private transient Game game;

    public Level(String fileName) {
        this.load(fileName);
    }

    private void initCollidables() {
        for (Collidable collidable : collidables) {
            collidable.setLevel(this);
        }
    }

    public void pushParticle(Particle p) {
        particles.add(p);
    }

    public void popParticle() {
        if (!particles.isEmpty()) {
            particles.removeLast();
        }
    }

    public void step(double deltaTime) {
        Vector force = sumForces();
        movableParticle.move(force, deltaTime);
        checkCollisions();
        ensureMovableParticleIsInside();
    }

    private void ensureMovableParticleIsInside() {
        if (movableParticle.getPosition().getX() > 1280 || movableParticle.getPosition().getX() < 0 ||
                movableParticle.getPosition().getY() > 640 || movableParticle.getPosition().getY() < 0) {
            reset();
        }
    }

    public void reset() {
        timer.stop();
        this.load(fileName);
        game.addTry();
        game.addToAllParticles(particles.size());
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void finishLevel() {
        game.addTry();
        game.addToAllParticles(particles.size());
        game.nextLevel();
    }

    private void checkCollisions() {
        for (Collidable collidable : collidables) {
            if (collidable.didCollide(movableParticle)) {
                timer.stop();
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
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String fileName) {
        particles = new LinkedList<>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            movableParticle = (MovableParticle) ois.readObject();
            collidables = (ArrayList<Collidable>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        this.fileName = fileName;
        initCollidables();
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

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
