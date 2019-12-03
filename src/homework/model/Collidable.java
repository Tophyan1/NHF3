package homework.model;

public interface Collidable {

    void onCollide();

    boolean didCollide(MovableParticle p);

    void setLevel(Level level);
}
