package homework;
/**
 * Goblin Character type class.
 */
public class Goblin extends AbstractCharacter {

    public static class GoblinBuilder extends AbstractCharacterBuilder<Goblin, GoblinBuilder> {

        @Override
        protected Goblin getActual() {
            return new Goblin();
        }

        @Override
        protected GoblinBuilder getActualBuilder() {
            return this;
        }
    }

    @Override
    public String toString() {
        return "(Goblin) " + super.toString();
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
