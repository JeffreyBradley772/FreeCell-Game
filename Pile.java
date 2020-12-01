import java.util.*;
/*
 * normal pile
 * 8 normal piles in total
 */
public class Pile extends Cell{
    //public Deck deck = new Deck();

    public Pile() {
        super();

    }

    @Override
    public boolean acceptTop(Card card) {
        Card top = this.getTop();
        if ((this.size() == 0 || (top.getRank() -1 == card.getRank())
                && top.getColor() != card.getColor())) {
            return true;
        }
        else { return false;}
        }




}
