import java.util.*;
/*
 * Freecell pile
 * create a deck and clear to initialize
 */
public class FreePile extends Cell{
    //public Deck deck = new Deck();
    public List<Card> deck;

    public FreePile() {
        super();
    }

    @Override
    public boolean acceptTop(Card card) {
        return this.size() == 0; //acceptTop when pile is empty

    }

    

}
