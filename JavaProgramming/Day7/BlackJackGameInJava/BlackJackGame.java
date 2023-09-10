package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;



public class BlackJackGame {
    private List<StandardCard> listofCards = new ArrayList<>();
    private ArrayList<StandardCard> playerCardList = new ArrayList<>();
    private ArrayList<StandardCard> dealerCardList = new ArrayList<>();
    private Set<StandardCard> playerCardSet = new HashSet<>();
    private Set<StandardCard> dealerCardSet = new HashSet<>();
    private Integer playerSum;
    private Integer dealerSum;
    private CardDeck deck; 
    private Scanner sc = new Scanner(System.in);
    private Random r = new Random();
    private boolean skipped;
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
            playerCardList.clear();
            playerCardSet.clear();
            dealerCardList.clear();
            dealerCardSet.clear();
            deck = new CardDeck();
            listofCards = deck.generatecards();
            Collections.shuffle(listofCards);
            initiatePlayer();
            initiateDealer();
            
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
    private void initiateDealer() {
        
        getDealerTurn();
        getDealerTurn();
    }
    private void initiatePlayer() {
       
        getPlayerTurn();
        getPlayerTurn();
    }
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
    private boolean getIsNotDealerCard(Integer draw) {
        StandardCard temp = listofCards.get(draw);
        if(dealerCardSet.contains(temp))
        {
            return false;
        }
        return true;
    }
    private boolean getIsNotPlayerCard(Integer draw) {
        StandardCard temp = listofCards.get(draw);
        if(playerCardSet.contains(temp))
        {
            return false;
        }
        return true;
    }
    private Integer randomDraw() {
        return r.nextInt(listofCards.size());
    }
}
