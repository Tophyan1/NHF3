package homework.model;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A class representong a level in the game
 */
public class Level implements Serializable, Drawable {

    private static final long serialVersionUID = 4695694190538321899L;
    private MovableParticle movableParticle;
    private ArrayList<Collidable> collidables;
    private transient LinkedList<Particle> particles;
    public transient String fileName;
    private transient Timer timer;
    private transient Game game;

    /**
     * Creates a Level from a file whose name is given as a parameter
     *
     * @param fileName the name of the file
     */
    public Level(String fileName) {
        this.load(fileName);
    }

    /**
     * Sets the Collidable objects' level attributes to this
     */
    private void initCollidables() {
        for (Collidable collidable : collidables) {
            collidable.setLevel(this);
        }
    }

    /**
     * Pushes a particle into the list of particles placed
     *
     * @param p the particle to be pushed
     */
    public void pushParticle(Particle p) {
        particles.add(p);
    }

    /**
     * Removes the last particle from the placed list
     */
    public void popParticle() {
        if (!particles.isEmpty()) {
            particles.removeLast();
        }
    }

    /**
     * Moves the level by a given time
     *
     * @param deltaTime the time period
     */
    public void step(double deltaTime) {
        Vector force = sumForces();
        movableParticle.move(force, deltaTime);
        checkCollisions();
        ensureMovableParticleIsInside();
    }

    /**
     * Resets the level if the particle has left the active area
     */
    private void ensureMovableParticleIsInside() {
        if (movableParticle.getPosition().getX() > 1280 || movableParticle.getPosition().getX() < 0 ||
                movableParticle.getPosition().getY() > 640 || movableParticle.getPosition().getY() < 0) {
            reset();
        }
    }

    /**
     * Reloads the level to its original state
     */
    public void reset() {
        timer.stop();
        this.load(fileName);
        game.addTry();
        game.addToAllParticles(particles.size());
    }

    /**
     * Sets the game whose level this is
     *
     * @param game the owner game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * finalises the level upon the moving particle reaches the goal
     */
    public void finishLevel() {
        game.addTry();
        game.addToAllParticles(particles.size());
        game.nextLevel();
    }

    /**
     * Checks if the moving particle has collided with anything, and acts accordingly
     */
    private void checkCollisions() {
        for (Collidable collidable : collidables) {
            if (collidable.didCollide(movableParticle)) {
                timer.stop();
                collidable.onCollide();
            }
        }
    }

    /**
     * Calculates the force vector that all the placed particles exert on the moving one
     *
     * @return the force vector
     */
    private Vector sumForces() {
        Vector force = new Vector(0, 0);
        for (Particle particle : particles) {
            force.addVector(particle.calculateForce(movableParticle));
        }
        return force;
    }

    /**
     * Gets the movable particle
     *
     * @return the movable particle
     */
    public MovableParticle getMovableParticle() {
        return movableParticle;
    }

    /**
     * Saves the level to a file given by name as a parameter
     *
     * @param fileName the name of the file
     */
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

    /**
     * Loads the game from a given file
     *
     * @param fileName the name of the file
     */
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

    /**
     * Draws the level on a canvas
     *
     * @param g the Graphics object used to draw
     */
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

    /**
     * sets the timer that ticks
     *
     * @param timer the timer
     */
    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
