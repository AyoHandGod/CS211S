package homework;

import java.util.UUID;

public abstract class Character {

    private String name;
    private String job;
    private int healthPoints;
    private UUID characterId;

    public static final int DEFAULT_STARTING_HEALTH = 30;


    public Character() {
        characterId = UUID.randomUUID();
    }

    public Character(String name, String job) {
        this();
        this.name = name;
        this.job = job;
    }

    public Character(String name, String job, int healthPoints){
        this(name, job);
        this.healthPoints = healthPoints;
    }

    public UUID getCharacterId() {
        return this.characterId;
    }

    public String getName() {
        return this.name;
    }

    public String getJob() {
        return this.job;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public String toString() {
        return this.name + ", is a " + this.job + ". This character currently" +
                "has " + healthPoints + " remaining.";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Character)) {
            return false;
        }

        Character otherCharacter = (Character) o;

        return this.name.equalsIgnoreCase(otherCharacter.getName()) &&
                this.job.equalsIgnoreCase(otherCharacter.getJob()) &&
                this.characterId.equals(otherCharacter.getCharacterId());
    }

    @Override
    public int hashCode() {
        int result = this.name.hashCode();
        result = 31 * result + this.job.hashCode();
        result = 31 * result + this.characterId.hashCode();
        return result;
    }
}
