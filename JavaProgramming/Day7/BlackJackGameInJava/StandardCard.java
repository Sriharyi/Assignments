package game;

public class StandardCard implements Card {
    private String suit;
    private String face;
    private Integer value;

    public void setStandardCard(String suit, String face, Integer value) {
        this.suit = suit;
        this.face = face;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getFace() {
        return face;
    }

    public Integer getValue() {
        return value;
    }

    public String toString() {
        return "[" + suit + "]-[" + face + "]-[" + value + "]";
    }

}

