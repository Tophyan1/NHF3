package homework.model;


/**
 * An interface representing objects with witch a MovableParticle can collide
 */
public interface Collidable {


    void onCollide();

    boolean didCollide(MovableParticle p);

    void setLevel(Level level);
}
