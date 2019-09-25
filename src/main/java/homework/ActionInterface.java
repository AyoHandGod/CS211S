package homework;

public interface ActionInterface {

    /**
     * Perform an action on target object.
     *
     * @param target the object that the action should be carried out against.
     * @return a String describing the action performed.
     */
    String performOn(AbstractCharacter target);

}
