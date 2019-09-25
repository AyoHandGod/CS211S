package homework;

// M3 Using Strategy
public class Tsunami extends Spell {

    private static final String DESCRIPTION = " launches a tidal wave of titanic proportions";

    @Override
    public String performOn(AbstractCharacter target) {
        return DESCRIPTION;
    }

    public static class TsunamiBuilder extends SpellBuilder<Tsunami, TsunamiBuilder>{

        @Override
        Tsunami getSpell() {
            return new Tsunami();
        }

        @Override
        TsunamiBuilder getSpellBuilderType() {
            return this;
        }
    }

    public static void main(String[] args) {
        Spell tsunami = new TsunamiBuilder().build();
    }
}
