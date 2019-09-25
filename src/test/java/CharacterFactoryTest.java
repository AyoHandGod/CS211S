import homework.AbstractCharacter;
import homework.CharacterFactory;
import homework.Goblin;
import homework.NonPlayerCharacter;
import org.junit.Assert;
import org.junit.Test;

public class CharacterFactoryTest {

    private CharacterFactory characterFactory = new CharacterFactory();

    @Test
    public void canCreateNonPlayerCharacterTest() {
        AbstractCharacter npc = characterFactory.getType("NPC", "Johnny");
        Assert.assertTrue(npc instanceof NonPlayerCharacter);
    }

    @Test
    public void canCreateGoblinCharacterTest() {
        AbstractCharacter goblin = characterFactory.getType("Goblin", "Rara");
        Assert.assertTrue(goblin instanceof Goblin);
    }
}
