import homework.*;
import org.junit.Test;

public class ActionInterfaceTest {
    @Test
    public void canPerformAction() {
        ActionInterface spell = new Tsunami.TsunamiBuilder().build();
        PlayerCharacter playerCharacter = new PlayerCharacter.PlayerCharacterBuilder()
                .playerName("Mark")
                .race("elf")
                .build();
        spell.performOn(playerCharacter);
    }
}
