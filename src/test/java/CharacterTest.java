import homework.AbstractCharacter;
import homework.PlayerCharacter;
import org.junit.Assert;
import org.junit.Test;

public class CharacterTest {

    private AbstractCharacter testCharacter = new PlayerCharacter
            .PlayerCharacterBuilder()
            .playerName("Tim")
            .race("Elf")
            .name("James")
            .level(12)
            .build();

    @Test
    public void characterEqualityTest() {
        AbstractCharacter equalityTestCharacter =
                new PlayerCharacter.PlayerCharacterBuilder().playerName("Tim").race("Elf").level(11).build();

        Assert.assertNotEquals(testCharacter, equalityTestCharacter);
    }
}
