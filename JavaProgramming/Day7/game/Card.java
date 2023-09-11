package game;

public interface Card {
    //get Suit value of card
    public String getSuit();
    //get face value of card
    public String getFace();
    //get value of card
    public Integer getValue();
    //override the toString method to get String of suit face and value
    public String toString();
}