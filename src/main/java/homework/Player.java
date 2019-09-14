package homework;

/**
 * Player Character class.
 */
public class Player extends Character {

    private static final int STARTING_HEALTH_BONUS = 15;
    private static final int PLAYER_STARTING_HEALTH = Character.DEFAULT_STARTING_HEALTH + STARTING_HEALTH_BONUS;

    private String playerName;

    public Player(String name, String playerName, String job){
        super(name, job, PLAYER_STARTING_HEALTH);
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    /**
     * Observe target character, displaying character attributes, disposition or current activities.
     * @param otherCharacter Character object to be observed by player.
     */
    public void observe(Character otherCharacter) {
        System.out.println(otherCharacter.toString());
    }

    /**
     * Perform an attack on target character. Reduces health of character.
     * @param targetCharacter The target victim of this attack.
     */
    public void attack(Character targetCharacter) {
        targetCharacter.setHealthPoints(targetCharacter.getHealthPoints() - 5);
    }
}
