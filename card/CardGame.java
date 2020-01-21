import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;




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
        return "["+suite+ ":"+ rank+"]";
    }
    
    

}

class CardDeck {

    List<Card> cards = new ArrayList<Card>();
    Random rand = new Random();

    public CardDeck() {

        /*for( Card.SUITE suite : Card.SUITE.values()) {
            for (Card.RANK rank : Card.RANK.values()) {
                Card  card = new Card(suite, rank);
                cards.add(card);
            }
        }*/
        
        Arrays.stream(Card.SUITE.values()).forEach(suite -> {
            Arrays.stream(Card.RANK.values()).forEach(rank ->{
                Card  card = new Card(suite, rank);
                cards.add(card);
            });
        });

    }

    public void print() {

        System.out.println("Printing Deck ------");
        cards.forEach(e -> System.out.print(e + "->"));
        System.out.println();
    }

    public void suffle() {
        
        IntStream.range(0, cards.size()).forEach(cardIndex -> {
            int randomIndex = rand.nextInt(cards.size());
            Collections.swap(cards, cardIndex, randomIndex);
        });
        


    }
}

public class CardGame {

    public static void main(String r[]) {

        CardDeck deck = new CardDeck();
        deck.print();
        deck.suffle();
        deck.print();

    }

}