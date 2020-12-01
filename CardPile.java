import java.util.*;


public class CardPile {


    private ArrayList<Card> pile;

    public CardPile(){
        pile = new ArrayList<Card>();
    }

    public void add(Card card) {
        pile.adds(card);
    }

    public Card remove(){ 
        return pile.remove(-1);
    }

}
