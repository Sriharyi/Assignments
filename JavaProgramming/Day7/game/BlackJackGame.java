package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;



public class BlackJackGame {
    //here he have listofcards and playercardlist and dealercardlist to store their cards
    private List<StandardCard> listofCards = new ArrayList<>();
    private ArrayList<StandardCard> playerCardList = new ArrayList<>();
    private ArrayList<StandardCard> dealerCardList = new ArrayList<>();
    //here we have playercardset and dealercardset to store their cards in a set to check contains cards in order of (1) time.
    private Set<StandardCard> playerCardSet = new HashSet<>();
    private Set<StandardCard> dealerCardSet = new HashSet<>();
    //playersum and dealersum to store the value of total sum
    private Integer playerSum;
    private Integer dealerSum;
    //deck is used to create a deck of cards
    private CardDeck deck; 
    //scanner is used to get input from user
    private Scanner sc = new Scanner(System.in);
    //random is used to generate value
    private Random r = new Random();
    //track if the player and dealer is anyone busted
    private boolean skipped;

    //method is used to initiate the game
    public void startGame() {
        System.out.println("\nWelcome to Sriharyi's blackjack program!\n");
        System.out.println("would you like to start the game yes/no?");
        String input1 = sc.next();
        while(input1.equals("yes"))
        {
            if(skipped){
                System.out.println("would you like to start the game again yes/no? ");
                input1  = sc.next();
                System.out.println("you choose "+input1);
            }
            if(input1.equals("no")) break;

            skipped = false;
            playerSum = 0;
            dealerSum = 0;
            //clear the cards list for both everytime we play again
            playerCardList.clear();
            playerCardSet.clear();
            dealerCardList.clear();
            dealerCardSet.clear();
            deck = new CardDeck();
            listofCards = deck.generatecards();

            //here we shuffle the deck
            Collections.shuffle(listofCards);

            //start the game here
            initiatePlayer();
            initiateDealer();

            //variable used to store the first and second value of player and dealer
            String firstCard  = playerCardList.get(0).toString();
            String secondCard = playerCardList.get(1).toString();
            
            System.out.println("You get a " + firstCard + " and a " + secondCard + ".");
            System.out.println("Your total is " + playerSum + ".");


            firstCard = dealerCardList.get(0).toString();
            secondCard = dealerCardList.get(1).toString();

            System.out.println(" The dealer has a " + firstCard + " showing, and a hidden card.");
            System.out.println("His total is hidden, too.");
            
            getPlayerChoose();
            if(skipped)
            {
                continue;
            }

            System.out.println("Okay, dealer's turn.");
            System.out.println("His hidden card was a " + secondCard + ".");
            System.out.println("His total is " + dealerSum + ".");
            System.out.println();
            getDealerchoose();
            if(skipped)
            {
                continue;
            }
            System.out.println("Dealer total is " + dealerSum + ".");
            System.out.println("Your total is " + playerSum + ".");
            if (playerSum > dealerSum) {
                System.out.println("You Win!");
            } else {
                System.out.println("Dealer Win!");
            }
            skipped = false;
            System.out.println();
            System.out.println();
            System.out.println();
            
            System.out.println("would you like to start the game again yes/no? ");
            input1  = sc.next();
        }   
    }

    //player turn to hit OR Stay
    private void getPlayerChoose() {
        String input2;
        do {
            if(skipped)
            { 
                break;
            }
            System.out.println("Would you like to \"hit\" or \"stay\"?");
            input2 = sc.next();
            if (input2.equals("hit")) {
                getPlayerTurn();
                if (playerSum > 21) {
                    System.out.println("Your are busted");
                    skipped = true;
                    String temp = playerCardList.get(playerCardList.size()-1).toString();
                    System.out.println("You drew a " + temp + ".");
                    System.out.println("Your total is " + playerSum + ".");
                    continue;
                }

                String temp = playerCardList.get(playerCardList.size()-1).toString();
                System.out.println("You drew a " + temp + ".");
                System.out.println("Your total is " + playerSum + ".");
                System.out.println();
            }
            System.out.println();

        } while (!input2.equals("stay"));
    }

    //dealer turn to hit or stay
    private void getDealerchoose() {
        String dealerchoose;
        do {
            if(skipped)
            { 
                break;
            }
            dealerchoose ="stay";
            if(dealerSum<=16)
            {
                dealerchoose = "hit";
            }
            if (dealerchoose.equals("hit")) {
                getDealerTurn();
                if (dealerSum > 21) {
                    System.out.println("dealer is busted");
                    skipped = true;
                    String temp = dealerCardList.get(dealerCardList.size()-1).toString();
                    System.out.println("He drew a " + temp + ".");
                    System.out.println("His total is " + dealerSum + ".");
                    continue;
                }
                String temp = dealerCardList.get(dealerCardList.size()-1).toString();
                System.out.println("He drew a " + temp + ".");
                System.out.println("His total is " + dealerSum + ".");
            }
            System.out.println();
        } while (!dealerchoose.equals("stay"));
    }
    //initiate the dealer
    private void initiateDealer() {
        getDealerTurn();
        getDealerTurn();
    }
    //initiate the player 
    private void initiatePlayer() {
       
        getPlayerTurn();
        getPlayerTurn();
    }
    //method used to draw a random card from the listofcards for player turn
    private void getPlayerTurn() {
        boolean flag = true;
        do{
        Integer draw = randomDraw();
        boolean isNotPlayer = getIsNotPlayerCard(draw);
        boolean isNotDealer = getIsNotDealerCard(draw);
            if(isNotPlayer && isNotDealer){
                playerCardList.add(listofCards.get(draw));
                playerCardSet.add(listofCards.get(draw));
                playerSum+=listofCards.get(draw).getValue();
                flag=false;
            }
        }while(flag);
    }
    //method used to draw a random card from the listofcards for dealer turn
    private void getDealerTurn() {
        boolean flag = true;
        do{  
            Integer draw = randomDraw();
            boolean isNotPlayer = getIsNotPlayerCard(draw);
            boolean isNotDealer = getIsNotDealerCard(draw);
            if(isNotPlayer && isNotDealer){
                dealerCardList.add(listofCards.get(draw));
                dealerCardSet.add(listofCards.get(draw));
                dealerSum+=listofCards.get(draw).getValue();
                flag = false;
            }
        }while(flag);
    }

    //method used to check the random card is already in dealers cards
    private boolean getIsNotDealerCard(Integer draw) {
        StandardCard temp = listofCards.get(draw);
        if(dealerCardSet.contains(temp))
        {
            return false;
        }
        return true;
    }
    // method used to check the random card is already in players cards
    private boolean getIsNotPlayerCard(Integer draw) {
        StandardCard temp = listofCards.get(draw);
        if(playerCardSet.contains(temp))
        {
            return false;
        }
        return true;
    }
    //method used to return random Integer with in the deckofcards
    private Integer randomDraw() {
        return r.nextInt(listofCards.size());
    }
}
