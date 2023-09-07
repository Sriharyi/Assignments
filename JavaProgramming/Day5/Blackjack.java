import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Blackjack {

    private static Integer nextDraw() {
        Random r = new Random();
        return 2 + r.nextInt(10);
    }

    private static List<Integer> initialDraw() {
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        list.add(2 + r.nextInt(10));
        list.add(2 + r.nextInt(10));
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Sriharyi's blackjack program!");
        List<Integer> listofvalues = new ArrayList<>();
        listofvalues = initialDraw();
        Integer playersum = listofvalues.get(0) + listofvalues.get(1);
        System.out.println("You get a " + listofvalues.get(0) + " and a " + listofvalues.get(1) + ".");
            System.out.println("Your total is " + playersum + ".");
            System.out.println();
        listofvalues = initialDraw();
        Integer dealersum = listofvalues.get(0) + listofvalues.get(1);
        System.out.println(" The dealer has a " + listofvalues.get(0) + " showing, and a hidden card.");
        System.out.println("His total is hidden, too.");
        String input;
        do {
            System.out.println("Would you like to \"hit\" or \"stay\"?");
            input = sc.next();
            if (input.equals("hit")) {
                if (playersum > 21) {
                    System.out.println("Your are busted");
                    return;
                }
                Integer newdraw = nextDraw();
                playersum += newdraw;
                System.out.println("You drew a " + newdraw + ".");
                System.out.println("Your total is " + playersum + ".");
                System.out.println();
            }
            System.out.println();
        } while (!input.equals("stay"));
        System.out.println("Okay, dealer's turn.");
        System.out.println("His hidden card was a " + listofvalues.get(1) + ".");
        System.out.println("His total is " + dealersum + ".");
        System.out.println();
        List<String> dealerschoice = new ArrayList<>();
        dealerschoice.add("hit");
        dealerschoice.add("stay");
        int i = 0;
        do {
            System.out.println("Dealer chooses to " + dealerschoice.get(i) + ".");
            input = dealerschoice.get(i);
            i++;
            if (input.equals("hit")) {
                if (dealersum > 16) {
                    System.out.println("dealer is busted");
                    return;
                }
                Integer newdraw = nextDraw();
                dealersum += newdraw;
                System.out.println("He drew a " + newdraw + ".");
                System.out.println("His total is " + dealersum + ".");
            }
            System.out.println();
        } while (!input.equals("stay"));
        System.out.println("Dealer total is " + dealersum + ".");
        System.out.println("Your total is " + playersum + ".");
        if (playersum > dealersum) {
            System.out.println("You Win!");
        } else {
            System.out.println("Dealer Win!");
        }
        sc.close();
    }

}

