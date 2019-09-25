package homework;

/**
 * Represents a Non-Player Character.
 *
 * @author Dante Anthony
 */
public class NonPlayerCharacter extends AbstractCharacter {

    public static class NonPlayerCharacterBuilder extends
            AbstractCharacterBuilder<NonPlayerCharacter, NonPlayerCharacterBuilder> {

        @Override
        protected NonPlayerCharacter getActual() {
            return new NonPlayerCharacter();
        }

        @Override
        protected NonPlayerCharacterBuilder getActualBuilder() {
            return this;
        }
    }

    public NonPlayerCharacter(){}

}
