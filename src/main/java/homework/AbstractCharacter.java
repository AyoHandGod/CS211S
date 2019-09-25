package homework;

import java.util.Comparator;
import java.util.UUID;

/**
 * Represents the base for future Character classes.
 *
 * @author Dante
 * @version 1.2
 * @date 9/12/19
 */
public abstract class AbstractCharacter implements Comparable<AbstractCharacter> {

    /**
     * Default starting health value for all characters in game.
     */
    public static final int DEFAULT_STARTING_HEALTH = 30;
    // M2 HOMEWORK STATIC
    /**
     * Population of Characters.
     */
    public static int populationSize = 0;

    public static final Comparator<AbstractCharacter> LEVEL_COMPARATOR = new LevelSorter();
    public static final Comparator<AbstractCharacter> SIZE_COMPARATOR = new SizeSorter();

    /**
     * ********
     * Fields *
     * ********
     * */
    private String name;
    private Size size;
    private int healthPoints;
    private UUID characterId;
    private int characterLevel;
    private ActionInterface action;

    /**
     * AbstractCharacter no parameter constructor.
     */
    public AbstractCharacter() {
        characterId = UUID.randomUUID();
        characterLevel = 1;
        size = Size.MEDIUM;
        AbstractCharacter.populationSize += 1;
    }

    private AbstractCharacter(AbstractCharacterBuilder builder){
        this();
        this.name = builder.character.name;
        this.healthPoints = builder.character.healthPoints;
        this.action = builder.character.action;
        this.size = builder.character.size;
    }

    /**
     * Retrieve the id of this character instance.
     *
     * @return The UUID character id of this particular character.
     */
    public UUID getCharacterId() {
        return this.characterId;
    }

    /**
     * Retrieve the name of this Character object.
     *
     * @return the String representation of this Character's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrieve the current amount of health points that this Character has.
     *
     * @return the current amount of this characters health points as an integer.
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * Set the health of this character to the provided amount.
     *
     * @param healthPoints the integer amount of health points that the characters health points should be updated to.
     */
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * Retrieve the characters current Level of experience.
     *
     * @return the integer level of this character.
     */
    public int getCharacterLevel() { return this.characterLevel; }

    /**
     * Retrieve the Size type for this object.
     *
     * @return The Size type value enum for this object.
     */
    public Size getSize() {
        return this.size;
    }

    /**
     * Set the name for the
     * @param name
     */
    protected void setName(String name) { this.name = name; }

    /**
     * Set the size type of this character to the provided Size value.
     *
     * @param size a Size type value to be applied to character.
     */
    protected void setSize(Size size) { this.size = size; }

    /**
     * Increase the characters level by one.
     */
    protected void levelUp() {
        this.characterLevel++;
    }

    // M3 Using Strategy
    /**
     * Cast an Action at target AbstractCharacter object.
     *
     * @param target an AbstractCharacter to be the recepient of target action.
     * @return True if action successfully completed, false if not.
     */
    public String castAt(AbstractCharacter target) {
        return this.name + " " + action.performOn(target) + " at " + target.name;
    }

    public void setAction(ActionInterface action){
        this.action = action;
    }

    @Override
    public String toString() {
        return this.name + ", is a " + characterLevel + " level character. This character's size is "  + size.getName()
                + ". Character_id: " + this.characterId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof AbstractCharacter)) {
            return false;
        }

        AbstractCharacter otherCharacter = (AbstractCharacter) o;

        return this.characterId.equals(otherCharacter.getCharacterId());
    }

    @Override
    public int hashCode() {
        int result = this.name.hashCode();
        result = 31 * result + this.characterId.hashCode();
        return result;
    }

    @Override
    public int compareTo(AbstractCharacter otherCharacter){
        return Integer.compare(this.characterLevel, otherCharacter.getCharacterLevel());
    }

    // end methods

    // M2 HOMEWORK STATIC METHOD
    /**
     * Gets the amount of character objects that have been instantiated.
     *
     * @return Current Population size of Characters
     */
    public static int getPopulationSize() {
        return AbstractCharacter.populationSize;
    }

    // M3 Using Builder
    /**
     * AbstractCharacterBuilder class. Responsible for creating AbstractCharacter class objects.
     *
     * @param <T> A subclass of AbstractCharacter.
     * @param <B> A subclass of AbstractCharacterBuilder.
     */
    public static abstract class AbstractCharacterBuilder <T extends AbstractCharacter,
            B extends AbstractCharacterBuilder> {

        T character;
        B builder;

        /**
         * Gets the actual Type of object being built.
         *
         * @return An object of the AbstractCharacter subclass being built.
         */
        abstract T getActual();

        /**
         * Gets the actual Type of builder being used.
         *
         * @return An object of the AbstractCharacterBuilder subclass being used to build this Character.
         */
        abstract B getActualBuilder();

        public AbstractCharacterBuilder() {
            character = getActual();
            builder = getActualBuilder();
        }

        /**
         * Assign a name value to the name field of the AbstractCharacter object being built.
         *
         * @param name the String representation of the name that should be assigned to the AbstractCharacter.
         * @return this AbstractCharacterBuilder instance with the name update completed.
         */
        public AbstractCharacterBuilder name(String name){
            this.character.setName(name);
            return this;
        }

        /**
         * Assign a Size value to the size field of the AbstractCharacter object being built.
         *
         * @param size the Size type value to be assigned to the AbstractCharacter.
         * @return this AbstractCharacterBuilder instance with the size update completed.
         */
        public AbstractCharacterBuilder size(Size size){
            this.character.setSize(size);
            return this;
        }

        /**
         * Assign an integer value to the healthPoints field of the AbstractCharacter object being built.
         *
         * @param healthPoints the integer value to be assigned to the healthPoints field. Must be positive.
         * @return this AbstractCharacterBuilder instance with the update completed.
         */
        public AbstractCharacterBuilder healthPoints(int healthPoints){
            this.character.setHealthPoints(healthPoints);
            return this;
        }

        /**
         * Assign the provided level to the characterLevel of the Character being built.
         *
         * @param level the integer level that should be set to the characterLevel field.
         * @return this AbstractCharacterBuilder instance with the update completed.
         */
        public AbstractCharacterBuilder level(int level){
            for(int i = this.character.getCharacterLevel(); i < level - 1; i++){
                this.character.levelUp();
            }
            return this;
        }

        public AbstractCharacterBuilder action(ActionInterface action){
            this.character.setAction(action);
            return this;
        }

        public T build() {
            return this.character;
        }
    }

    // M3 Using Comparator
    /**
     * Sorts Character objects based on characterLevel, lowest to highest.
     */
    private static class LevelSorter implements Comparator<AbstractCharacter> {

        @Override
        public int compare(AbstractCharacter o1, AbstractCharacter o2) {
            return Integer.compare(o1.characterLevel, o2.characterLevel);
        }
    }

    /**
     * Sorts Characters based on size, smallest to largest.
     */
    private static class SizeSorter implements Comparator<AbstractCharacter> {

        @Override
        public int compare(AbstractCharacter o1, AbstractCharacter o2) {
            return o1.size.compareTo(o2.size);
        }
    }
}
