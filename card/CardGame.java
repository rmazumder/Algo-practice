import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


class Card {

    public static enum SUITE {
        Diamonds, Clubs, Hearts, Spades;
    }

    public static enum RANK {
        King, Queen, Jack, Ten, Nine, Eight, Seven, Six, Five, Four, Three, Deuce, Ace;
    }
    
    SUITE suite;
    RANK rank;
    
    public Card(SUITE suite, RANK rank) {
        this.suite = suite;
        this.rank = rank;
                
    }

    @Override
    public String toString() {
        return suite+ ":"+ rank;
    }
    
    

}

class CardDeck {

    List<Card> cards = new ArrayList<Card>();
    Random rand = new Random();

    public CardDeck() {

        /*for (int i = 0; i < 54; i++) {
            cards[i] = i;
        }*/
        
        for( Card.SUITE suite : Card.SUITE.values()) {
            for (Card.RANK rank : Card.RANK.values()) {
                Card  card = new Card(suite, rank);
                cards.add(card);
            }
        }

    }

    public void print() {

        System.out.println("Deck ------");
        for (Card card : cards) {
            System.out.print(card + " ->");
        }
        System.out.println("Deck ------");

    }

    public void suffle() {
        System.out.println("suffle started" + cards.size());
        for (int i = 0; i < cards.size(); i++) {
            //System.out.println(cards.size());
            int randomIndex = rand.nextInt(cards.size());
            //System.out.println("random "+ randomIndex);
            Collections.swap(cards, i, randomIndex);
            

        }
        
        System.out.println("suffle done");

    }
}

public class CardGame {

    public static void main(String r[]) {

        CardDeck deck = new CardDeck();
        System.out.println(deck.cards.size());
        deck.print();
        deck.suffle();
        deck.print();

    }

}