package homework;

/**
 * The fantasy archetypal races for Role Playing.
 */
public enum Race {
    /**
     * The Races available for players to select from for their character.
     */
    DWARF("Dwarf"), DRAGONBORN("Dragonborn"),
    ELF("Elf"), HALF_ELF("Elf"), HALF_ORC("Orc"), HALFLING("Halfling"),
    HUMAN("Human"), GNOME("Gnome");

    private String name;

    Race(String name) {
        this.name = name;
    }

    public String getName() {return name; }

    /**
     * Find Race type by name.
     *
     * @param aName the name of the race.
     * @return The Race type if found, else null.
     */
    public static Race findByName(String aName) {
        for (Race race : Race.values()) {
            if (race.name.equalsIgnoreCase(aName)) {
                return race;
            }
        }
        return null;
    }
}
