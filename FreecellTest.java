import java.util.*;

/*
*Tester of free cell game
*
*
*/

public class FreecellTest {

	public static void main(String[] args) {
		FreecellGame game = new FreecellGame();
		game.gameDeal();


		while(!game.winner()) {
			System.out.println(game);
			System.out.println("What is your move? ");
			Scanner input = new Scanner(System.in);
			String move = input.nextLine();
			move.toLowerCase();

			if (move.charAt(0) == 'q') { break; }
			//t,h,f
			char ch1 = move.charAt(0);
			char ch2 = move.charAt(1);
			char ch3 = move.charAt(2);
			char ch4 = move.charAt(3);



			try {
				char source = ch1;
				int  srcpile = (int)ch2 - '1';
				char dest = ch3;
				int  destpile = (int)ch4 - '1';


				//doesn't seem to be working
				if (source == 't' && dest =='t') {
						if (!game.move((Cell)game.pile.get(srcpile),(Cell)game.pile.get(destpile))) {
							System.out.println("ILLEGAL MOVE");
						}
				}
				else if (source == 't' && dest == 'h'){
                    if (!game.move((Cell)game.pile.get(srcpile),(Cell)game.home.get(destpile))) {
                    	System.out.println("ILLEGAL MOVE");
                    }
                }
				else if (source == 't' && dest == 'f') {
                	if(!game.move((Cell)game.pile.get(srcpile), (Cell)game.free.get(destpile))) {
                		System.out.println("ILLEGAL MOVE");
                	}
                }
				else if (source == 'f' && dest == 't') {
                	if (! game.move((Cell)game.free.get(srcpile), (Cell)game.pile.get(destpile))) {
                		System.out.println("ILLEGAL MOVE");
                	}
                }
				else if (source == 'f' && dest == 'h') {
                	if (! game.move((Cell)game.free.get(srcpile), (Cell)game.home.get(destpile))) {
                		System.out.println("ILLEGAL MOVE");
                	}
                }
				else if (source == 'f' && dest == 'f') {
                	if (! game.move((Cell)game.free.get(srcpile), (Cell)game.free.get(destpile))) {
                		System.out.println("ILLEGAL MOVE");
                	}
                }

                else {
                	System.out.println("ILLEGAL MOVE");

                }


			}
			catch(NullPointerException e) {
				System.out.println("Error");}



		}
    }
}
