package homework;
/**
 * Goblin Character type class.
 */
public class Goblin extends Character {

    public Goblin(String name, String job) {
        super(name, job, Character.DEFAULT_STARTING_HEALTH);
    }

    @Override
    public String toString() {
        return "Goblin{ " + super.toString() + " }";
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
