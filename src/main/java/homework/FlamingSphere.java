package homework;

public class FlamingSphere extends Spell {

    private static final String DESCRIPTION = "Creates a flaming sphere";
    private static final int CASTING_TIME = 1;
    private static final int RANGE = 60;
    private static final int DURATION = 1;

    @Override
    public String performOn(AbstractCharacter target) {
        return DESCRIPTION;
    }

    public static class FlamingSphereBuilder extends SpellBuilder<FlamingSphere, SpellBuilder> {

        public FlamingSphereBuilder() {
            this.spell = getSpell();
            this.spellBuilderType = getSpellBuilderType();
            this.spell.setDuration(DURATION);
            this.spell.setRange(RANGE);
            this.spell.setCastingTime(CASTING_TIME);
        }

        @Override
        FlamingSphere getSpell() {
            return new FlamingSphere();
        }

        @Override
        SpellBuilder getSpellBuilderType() {
            return this;
        }
    }


}
