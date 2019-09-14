package homework;

import java.util.ArrayList;

public class CreatureDriver {
    public static void main(String[] args) {
        ArrayList<Character> characterList = new ArrayList<>();
        characterList.add(new Player("Maxine", "Dante", "Carpenter"));
        characterList.add(new NonPlayerCharacter("John", "Shopkeeper"));
        characterList.add(new Goblin("Grublub", "Chieftan"));

        Player player = (Player) characterList.get(0);
        Goblin goblin =  (Goblin) characterList.get(2);

        player.attack(goblin);
        player.observe(goblin);
    }
}
