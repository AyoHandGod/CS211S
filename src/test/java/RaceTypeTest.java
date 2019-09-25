import homework.Race;
import org.junit.Assert;
import org.junit.Test;

public class RaceTypeTest {

    @Test
    public void validNameReturnsRaceTest(){
        Race race = Race.findByName("Elf");
        Assert.assertNotNull(race);
    }

    @Test
    public void invalidNameReturnsNullTest() {
        Race race = Race.findByName("Dodo");
        Assert.assertNull(race);
    }
}
