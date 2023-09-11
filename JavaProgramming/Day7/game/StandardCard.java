package game;

//standardCard implements card interface so we must define all the methods in the interface
public class StandardCard implements Card {
    private String suit;
    private String face;
    private Integer value;
    //method used to setValue of each card
    public void setStandardCard(String suit, String face, Integer value) {
        this.suit = suit;
        this.face = face;
        this.value = value;
    }
    //get Suit value of card
    public String getSuit() {
        return suit;
    }
    
    //get face value of card
    public String getFace() {
        return face;
    }
    
    //get value of card
    public Integer getValue() {
        return value;
    }
    
    //override the toString method to get String of suit face and value
    public String toString() {
        return "[" + suit + "]-[" + face + "]-[" + value + "]";
    }

}

