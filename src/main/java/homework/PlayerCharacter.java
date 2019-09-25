package homework;
/**
 * PlayerCharacter class.
 *
 * @author Dante L. Anthony
 * @version 1.4.0
 */
public class PlayerCharacter extends AbstractCharacter {

    private static final int STARTING_HEALTH_BONUS = 15;
    private static final int PLAYER_STARTING_HEALTH =
            AbstractCharacter.DEFAULT_STARTING_HEALTH + STARTING_HEALTH_BONUS;

    private Race race;
    private String playerName;

    private PlayerCharacter(){}

    /**
     * Get the name of the player.
     * @return the players name.
     */
    public String getPlayerName() {
        return this.playerName;
    }

    public static class PlayerCharacterBuilder extends
            AbstractCharacterBuilder<PlayerCharacter, PlayerCharacterBuilder> {

        private Race race;
        private String playerName;

        /**
         * Assign a race to the PlayerCharacter using a string.
         *
         * @param race string representation of the PlayerCharacter's race.
         * @return this PlayerCharacterBuilder instance.
         */
        public PlayerCharacterBuilder race(String race){
            this.character.race = Race.findByName(race);
            return this;
        }

        /**
         * Assign a race to the PlayerCharacter using a specific Race type value.
         *
         * @param race a Race type from the Race Enum.
         * @return this PlayerCharacterBuilder instance.
         */
        public PlayerCharacterBuilder race(Race race) {
            this.character.race = race;
            return this;
        }

        public PlayerCharacterBuilder playerName(String playerName){
            this.character.playerName = playerName;
            return this;
        }

        @Override
        protected PlayerCharacter getActual() {
            return new PlayerCharacter();
        }

        @Override
        protected PlayerCharacterBuilder getActualBuilder() {
            return this;
        }

    }
}
