package homework;

// M3 Using Factory
public class CharacterFactory {

    private static final String PLAYER = "player";
    private static final String GOBLIN = "goblin";
    private static final String NPC = "npc";

    public AbstractCharacter getType(String type, String name) {
        if (NPC.equalsIgnoreCase(type)) {
            return new NonPlayerCharacter.NonPlayerCharacterBuilder().name(name).build();
        } else if (GOBLIN.equalsIgnoreCase(type)) {
            return new Goblin.GoblinBuilder().name(name).build();
        } else if(PLAYER.equalsIgnoreCase(type)) {
            return new PlayerCharacter.PlayerCharacterBuilder().race("elf").name(name).build();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        CharacterFactory characterFactory = new CharacterFactory();

        AbstractCharacter elfPlayer = characterFactory.getType("player", "Glad Blade");
        System.out.println(elfPlayer);

        AbstractCharacter goblin = characterFactory.getType("goblin", "Uka booga");
        goblin.setAction(new FlamingSphere());

        AbstractCharacter playerCharacter = new PlayerCharacter.PlayerCharacterBuilder()
                .race("Human")
                .name("Jack")
                .action(new Tsunami())
                .level(12)
                .size(Size.LARGE)
                .build();

        System.out.println(goblin.castAt(elfPlayer));
        System.out.println(playerCharacter.castAt(goblin));


    }
}
