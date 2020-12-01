import java.util.*;


abstract class Cell{

	public ArrayList<Card> deck;


	public Cell() {
		 deck = new ArrayList<Card>();
	}

	/**
	 * determine if deck can accept card to top
	 * @param card to be added to deck
	 * @return true if can accept card to top. false if cannot.
	 */
	public abstract boolean acceptTop(Card card); //had to define as abstract

	/**
	 * determine if card can be moved
	 * @return true if card in deck is moveable. false if else.
	 */
	public boolean moveable() { return true; }

	/**
	 * adds card to top of deck
	 * @param card to be added
	 */
    public void add(Card card) {
    	if(this.acceptTop(card)) {
    		deck.add(card);
    	}
    }

    /**
     * Tests the deck for emptiness.
     * @return true if the deck is empty
     */
    public boolean isEmpty(){
    	return deck.size() == 0;
    }


	/**
	 * force add card to top of deck
	 * @param card to be added
	 */
    public void forceadd(Card card) {

    	deck.add(card);

    }





    public void remove() {
    	this.deck.remove(deck.size() - 1);
    }


    /**
     * getting the size
     * @return size of the deck
     */
    public int size() {
        return deck.size();
    }

    /**
     * getting the top card
     * @return the top card of the deck
     * Jeff- added a check here to make sure the deck wasn't empty. Do we need it?
     * Thought it should return something if its empy when using it in the toString method in the model.
     */

    public Card getTop() {
        if (deck.size() > 0){
            return deck.get(deck.size() - 1);
        }else{
            return null;
        }

    }
    /**
     * gets a card at position i
     * @param position of desired card
     * @return desired card
     */

    public Card get(int i) {
    	return deck.get(i);
    }

    public String getStringTop(){
        System.out.println("ugh");
        if (deck.size() > 0){
            System.out.println("ugh1");
            return deck.get(deck.size() - 1).toString();
        }else{
            System.out.println("ugh2");
            return "None";
        }
    }

    /**
     * clear the deck
     */
    public void clear() {
    	deck.clear();
    }

    public String toString(){
        String c = " | ";

        for (Card card : deck){
            c = c + card + " | ";
        }
        return c;
    }

}
