package game;

import java.util.*;

//carddeck class is used to generae the deck of cards
public class CardDeck{
    //method used to addSpade card
    public StandardCard addSpade(String face, Integer value) {
        StandardCard s = new StandardCard();
        s.setStandardCard("Spade", face, value);
        return s;
    }
    //method used to addDiamond card
    public StandardCard addDiamond(String face, Integer value) {
        StandardCard s = new StandardCard();
        s.setStandardCard("Diamond", face, value);
        return s;
    }

    //method used to addClever card
    public StandardCard addClever(String face, Integer value) {
         StandardCard s = new StandardCard();
         s.setStandardCard("Clever", face, value);
        return s;

    }
    //method used to addHeart card
    public StandardCard addHeart(String face, Integer value) {
         StandardCard s = new StandardCard();
         s.setStandardCard("Heart", face, value);
        return s;
    }

    //method used to addAllFace cards
    private void addFaceCards(List<StandardCard> list) {
        list.add(addClever("Ace", 1));
        list.add(addDiamond("Ace", 1));
        list.add(addHeart("Ace", 1));
        list.add(addSpade("Ace", 1));
        list.add(addClever("King", 10));
        list.add(addDiamond("King", 10));
        list.add(addHeart("King", 10));
        list.add(addSpade("King", 10));
        list.add(addClever("Queen", 10));
        list.add(addDiamond("Queen", 10));
        list.add(addHeart("Queen", 10));
        list.add(addSpade("Queen", 10));
        list.add(addClever("Jack", 10));
        list.add(addDiamond("Jack", 10));
        list.add(addHeart("Jack", 10));
        list.add(addSpade("Jack", 10));
    }

    //method used to generate deck of cards
    public List<StandardCard> generatecards() {
        List<StandardCard> list = new ArrayList<>();

        for (int i = 2; i <= 10; i++) {
            list.add(addClever(String.valueOf(i), i));
            list.add(addDiamond(String.valueOf(i), i));
            list.add(addHeart(String.valueOf(i), i));
            list.add(addSpade(String.valueOf(i), i));
        }
        addFaceCards(list);
        return list;
    }
}






