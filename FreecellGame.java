
import java.util.*;


public class FreecellGame {



    public ArrayList free = new ArrayList<Cell>(4);

    public ArrayList home  = new ArrayList<Cell>(4);

    public ArrayList pile = new ArrayList<Cell>(8);

    public Deck deck;




	/**
	 * Deal out the cards
	 * 7 cards left 4 decks and 6 cards to right 4 decks
	 * @param a deck to deal out cards to initialize the game
	 */
	public void gameDeal() {
        free.clear();
        pile.clear();
        home.clear();
        Deck deck1 = new Deck();
		deck1.shuffle();

        for (int i = 1; i<9; i++){
            Pile p = new Pile();
            if (i < 5){
                for (int j = 1; j<8; j++){
                    p.forceadd(deck1.deal());
                }

            }else{
                for (int j = 1; j<7; j++){
                    p.forceadd(deck1.deal());
                }
            }
            pile.add(p);
        }

        for (int i = 1; i < 5; i++){
            HomePile h = new HomePile();
            home.add(h);
        }
        for (int i = 1; i < 5; i++){
            FreePile f = new FreePile();
            free.add(f);
        }
    }


	/**
	 * if Home piles all complete = win
	 * @return true if there is a winner (all home cells are filled) or false if else
	 */
	public boolean winner() {
        for (int i = 0; i< pile.size(); i++){
            Cell c = (Cell)pile.get(i);
            if (!(c.isEmpty())){

                return false;
            }
        }
        for (int i = 0; i< free.size(); i++){
            Cell c = (Cell)free.get(i);
            if (!(c.isEmpty())){

                return false;
            }
        }
        if (home.size() == 0){
            return false;
        }

        for (int i = 0; i< home.size(); i++){
            Cell c = (Cell)home.get(i);
            if (c.isEmpty()){

                return false;
            }
        }


        return true;


	}

	static boolean move(Cell here, Cell there) {

		if (here.size() > 0 && here.moveable()) {
			Card hereTop = here.getTop();
			if (there.acceptTop(hereTop)) {
				there.add(hereTop);
				here.remove();
				return true;
			}
		}

		return false; //if can not make any moves
	}


	public Cell getTableauPile(int i){
		return (Cell)pile.get(i);
	}

	public Cell getFreePile(int i){
		return (Cell)free.get(i);
	}

	public Cell getHomePile(int i){
		return (Cell)home.get(i);
	}






	/**
	 * utilizing Card.java toString method
	 * @return string implementation of freecell game
	 */
	public String toString() {


        String freeCells = "" + free.get(0)  + free.get(1) + free.get(2) + free.get(3);
        Cell h1 = (Cell)home.get(0);
        Card h1Top = h1.getTop();
        Cell h2 = (Cell)home.get(1);
        Card h2Top = h2.getTop();
        Cell h3 = (Cell)home.get(2);
        Card h3Top = h3.getTop();
        Cell h4 = (Cell)home.get(3);
        Card h4Top = h4.getTop();
        String homePiles = " | " + h1Top + " | " + h2Top + " | " + h3Top + " | " + h4Top + " | ";


        return "\n\nFree: "+ freeCells +"\n\nHome: "+ homePiles + "\n\nTableau 1: " + pile.get(0) + "\nTableau 2: " + pile.get(1)
        		+ "\nTableau 3: " + pile.get(2) + "\nTableau 4: " + pile.get(3)  + "\nTableau 5: " + pile.get(4) + "\nTableau 6: " + pile.get(5) + "\nTableau 7 : " + pile.get(6)
        		+ "\nTableau 8: " + pile.get(7);
	}

    public static void main(String[] args){

        FreecellGame game= new FreecellGame();
        game.gameDeal();

        System.out.println(game);

    }





}
