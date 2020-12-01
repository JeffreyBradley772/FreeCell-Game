import java.util.*;
/*
 * Home pile
 * create a deck and clear to initialize
 */
public class HomePile extends Cell {
    //public Deck deck = new Deck();
    public List<Card> deck;

    public HomePile() {
    	super();
    }

    @Override
    public boolean acceptTop(Card card) {
        if ((this.size() == 0) && (card.getRank() == 1)) { return true;}
        if (this.size() > 0) {
            Card top = this.getTop();
            if ( top.getSuit() == card.getSuit()
                    && top.getRank() + 1 == card.getRank()){ return true;}
        }
        return false;
    }



    @Override
    public boolean moveable() { return false; }


}
