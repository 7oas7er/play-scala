package models;

public class Karte {

    public enum Alignment {
        RUNNER("Runner"), CORPORATION("Corporation");

        private final String formatted;

        Alignment(String formatted) {
            this.formatted = formatted;
        }

        public String toString() {
            return this.formatted;
        }
    }

    public enum Edition {
        LIMITED("Limited"), PROTEUS("Proteus"), CLASSIC("Classic");

        private final String formatted;

        Edition(String formatted) {
            this.formatted = formatted;
        }

        public String toString() {
            return this.formatted;
        }
    }

    public enum Type {

        AGENDA("Agenda"), HARDWARE("Hardware"), ICE("Ice"), ICEBREAKER("Icebreaker"), NODE("Node"), OPERATION("Operation"), PREP("Prep"), PROGRAM("Program"), RESOURCE("Resource"), UPGRADE("Upgrade");

        private final String formatted;

        Type(String formatted) {
            this.formatted = formatted;
        }

        public String toString() {
            return this.formatted;
        }

    }

    public enum Rarity {
        VITAL("vital"), COMMON("common"), UNCOMMON("uncommon"), RARE("rare");

        private final String formatted;

        Rarity(String formatted) {
            this.formatted = formatted;
        }

        public String toString() {
            return this.formatted;
        }
    }

    public int id;
    public Alignment alignment;
    public String name;
    public String text;
    public String flavourText;
    public String illustrator;
    public Edition edition;
    public Rarity rarity;
    public Type cardType;

}
