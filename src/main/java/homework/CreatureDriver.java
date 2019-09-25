package homework;

import java.util.ArrayList;
import java.util.Collections;

public class CreatureDriver {
    public static void main(String[] args) {


        ArrayList<AbstractCharacter> characterList = new ArrayList<>();
        characterList.add(new PlayerCharacter.PlayerCharacterBuilder()
                .playerName("Dante")
                .race("Elf")
                .name("Maxine")
                .build());
        characterList.add(new NonPlayerCharacter.NonPlayerCharacterBuilder().name("John").build());
        characterList.add(new PlayerCharacter.PlayerCharacterBuilder()
                .playerName("Jernee")
                .name("Jerry")
                .size(Size.TINY)
                .level(8)
                .build());
        characterList.add(new Goblin.GoblinBuilder().name("Glob Lob").build());
        characterList.add(new PlayerCharacter.PlayerCharacterBuilder()
                .playerName("Mark")
                .race("elf")
                .name("Jason")
                .size(Size.GARGANTUAN)
                .level(12)
                .build());

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

        characterList.sort(AbstractCharacter.SIZE_COMPARATOR);

        for(AbstractCharacter character: characterList){
            System.out.println(character);
        }

        Collections.sort(characterList, AbstractCharacter.LEVEL_COMPARATOR);

        for(AbstractCharacter character: characterList){
            System.out.println(character);
        }
    }
}
