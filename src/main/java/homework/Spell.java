package homework;

//M3 Using Strategy
public abstract class Spell implements ActionInterface {

    private double castingTime;
    private double range;
    private double duration;

    public Spell() {}

    @Override
    public abstract String performOn(AbstractCharacter target);

    Spell(SpellBuilder spellBuilder) {
        this.castingTime = spellBuilder.spell.castingTime;
        this.range = spellBuilder.spell.range;
        this.duration = spellBuilder.spell.duration;
    }


    void setCastingTime(double castingTime) {
        this.castingTime = castingTime;
    }

    void setRange(double range) {
        this.range = range;
    }

    void setDuration(double duration) {
        this.duration = duration;
    }

    public abstract static class SpellBuilder<T extends Spell, B extends SpellBuilder> {
        T spell;
        B spellBuilderType;

        abstract T getSpell();

        abstract B getSpellBuilderType();

        private double castingTime;
        private double range;
        private double duration;

        SpellBuilder() {
            spell = getSpell();
            spellBuilderType = getSpellBuilderType();
        }

        public SpellBuilder castingTime(double castingTime) {
            this.spell.setCastingTime(castingTime);
            return this;
        }

        public SpellBuilder range(double range) {
            this.spell.setRange(range);
            return this;
        }

        public Spell build() {
            return this.spell;
        }
    }
}
