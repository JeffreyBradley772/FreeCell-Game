import java.awt.*;
import javax.swing.*;
import BreezySwing.*;

/**
 * The main window for the FreeCell game.
 * 
 *
 */
public class MainView extends GBFrame {

    private FreecellGame game;

    private Color background = new Color(0, 150, 50);

    private CardPanel [] homeCardPanels = new CardPanel[4];
    private CardPanel [] freeCardPanels = new CardPanel[4];
    private TableauxPanel [] tCardPanels = new TableauxPanel[8];

    // We only need three big panels: free, home, and tableaux
    GBPanel freePanel = addPanel(new GBPanel(), 2,1,1,1);

    GBPanel homePanel = addPanel(new GBPanel(), 2,2,1,1);

    GBPanel tableauxPanel = addPanel(new GBPanel(), 3,1,2,2);
    JButton newGame = addButton("New Game", 5,1,2,2);
    public int clickCount;
    char source;
    int  srcpile;
    char dest;
    int  destpile;
    private int test;


    public MainView(FreecellGame game) {
        this.test = test;
        this.clickCount = 0;
        this.game = game;
        // Basics
        this.setTitle("The Game of Free Cell");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 850);

        // Set the colors of our three panels
        freePanel.setBackground(background);
        homePanel.setBackground(background);
        tableauxPanel.setBackground(background);

        // Create the home-card panels
        for (int k=0; k<4; ++k) {
            homeCardPanels[k] = new CardPanel(this,k,'h');
            homeCardPanels[k].setBackground(background);
            homePanel.addPanel(homeCardPanels[k], 1, k+1, 1, 1);
        }

        for (int k=0; k<4; ++k) {
            freeCardPanels[k] = new CardPanel(this,k,'f');
            freeCardPanels[k].setBackground(background);
            freePanel.addPanel(freeCardPanels[k], 1, k+1, 1, 1);
        }

        for (int k=0; k<8; ++k) {
            tCardPanels[k] = new TableauxPanel(this,k,'t');
            tCardPanels[k].setBackground(background);
            tableauxPanel.addPanel(tCardPanels[k], 1, k+1, 1, 1);
        }







        // Store the game for the event listeners
        this.game = game;
        // Must do this to see the GUI!
        this.setVisible(true);
        newGame.doClick();

        while (!(game.winner())){
            System.out.print("Running \n");
            if (clickCount > 1){

                if (source == 't' && dest =='t') {
                        if (game.move((Cell)game.pile.get(srcpile),(Cell)game.pile.get(destpile))) {
                            tCardPanels[srcpile].setCard((Cell)game.pile.get(srcpile));
                            tCardPanels[destpile].setCard((Cell)game.pile.get(destpile));

                            clickCount = 0;
                        }else{
                            JOptionPane.showMessageDialog(MainView.this,
                                          "Illegal Move",
                                          "Illegal Action",
                                          JOptionPane.ERROR_MESSAGE);
                            clickCount = 0;
                        }
                }
                else if (source == 't' && dest == 'h'){
                    if (game.move((Cell)game.pile.get(srcpile),(Cell)game.home.get(destpile))) {
                        tCardPanels[srcpile].setCard((Cell)game.pile.get(srcpile));

                        Cell f2 = (Cell)game.home.get(destpile);
                        Card c2 = f2.getTop();
                        homeCardPanels[destpile].setCard(c2);

                        clickCount = 0;
                    }else{
                        JOptionPane.showMessageDialog(MainView.this,
                                      "Illegal Move",
                                      "Illegal Action",
                                      JOptionPane.ERROR_MESSAGE);
                        clickCount = 0;
                    }

                }
                else if (source == 't' && dest == 'f') {
                    if(game.move((Cell)game.pile.get(srcpile), (Cell)game.free.get(destpile))) {
                        tCardPanels[srcpile].setCard((Cell)game.pile.get(srcpile));

                        Cell f1 = (Cell)game.free.get(destpile);
                        Card c1 = f1.getTop();
                        freeCardPanels[destpile].setCard(c1);

                        clickCount = 0;
                    }else{
                        JOptionPane.showMessageDialog(MainView.this,
                                      "Illegel Move",
                                      "Illegal Action",
                                      JOptionPane.ERROR_MESSAGE);
                        clickCount = 0;
                    }

                }
                else if (source == 'f' && dest == 't') {
                    if (game.move((Cell)game.free.get(srcpile), (Cell)game.pile.get(destpile))) {

                        Cell f1 = (Cell)game.free.get(srcpile);
                        Card c1 = f1.getTop();
                        freeCardPanels[srcpile].setCard(c1);

                        tCardPanels[destpile].setCard((Cell)game.pile.get(destpile));
                        clickCount = 0;
                    }else{
                        JOptionPane.showMessageDialog(MainView.this,
                                      "Illegal Move",
                                      "Illegal Action",
                                      JOptionPane.ERROR_MESSAGE);
                        clickCount = 0;
                    }
                }
                else if (source == 'f' && dest == 'h') {
                    if (game.move((Cell)game.free.get(srcpile), (Cell)game.home.get(destpile))) {
                        Cell f1 = (Cell)game.free.get(srcpile);
                        Card c1 = f1.getTop();
                        freeCardPanels[srcpile].setCard(c1);

                        Cell f2 = (Cell)game.home.get(destpile);
                        Card c2 = f2.getTop();
                        homeCardPanels[destpile].setCard(c2);

                        clickCount = 0;
                    }else{
                        JOptionPane.showMessageDialog(MainView.this,
                                      "Illegal Move",
                                      "Illegal Action",
                                      JOptionPane.ERROR_MESSAGE);
                        clickCount = 0;
                    }
                }
                else if (source == 'f' && dest == 'f') {
                    if (! game.move((Cell)game.free.get(srcpile), (Cell)game.free.get(destpile))) {
                        Cell f1 = (Cell)game.free.get(srcpile);
                        Card c1 = f1.getTop();
                        freeCardPanels[srcpile].setCard(c1);

                        Cell f2 = (Cell)game.free.get(destpile);
                        Card c2 = f2.getTop();
                        freeCardPanels[destpile].setCard(c2);

                        clickCount = 0;
                    }else{
                        JOptionPane.showMessageDialog(MainView.this,
                                      "Too many clicks. Try again.",
                                      "Error",
                                      JOptionPane.ERROR_MESSAGE);
                        clickCount = 0;
                    }
                }

                else {
                    JOptionPane.showMessageDialog(MainView.this,
                                  "Illegal Move",
                                  "Illegal Action",
                                  JOptionPane.ERROR_MESSAGE);
                    clickCount = 0;
                }

            }
            if (clickCount ==1 && test < 1){
                JOptionPane.showMessageDialog(MainView.this,
                              "Start a New Game",
                              "Start a New Game",
                              JOptionPane.INFORMATION_MESSAGE);
                clickCount = 0;
            }
        }
    }
    public void clickedHome(int id){
        //System.out.println(clickCount);
        if (clickCount == 0){
            source = 'h';
            srcpile = id;
            clickCount++;
        }
        else if (clickCount == 1){
            dest = 'h';
            destpile = id;
            clickCount++;
        }



    }

    public void clickedFree(int id){
        //System.out.println(clickCount);
        if (clickCount == 0){
            source = 'f';
            srcpile = id;
            clickCount++;
        }
        else if (clickCount == 1){
            dest = 'f';
            destpile = id;
            clickCount++;
        }



    }

    public void clickedTableaux(int id){
        //System.out.println(clickCount);
        if (clickCount == 0){
            source = 't';
            srcpile = id;
            clickCount++;
        }
        else if (clickCount == 1){
            dest = 't';
            destpile = id;
            clickCount++;
        }



    }



    public void buttonClicked(JButton buttonObj){
        if (buttonObj == newGame){
            test = 1;
            game.gameDeal();

            Cell t1 = (Cell)game.pile.get(0);
            Cell t2 = (Cell)game.pile.get(1);
            Cell t3 = (Cell)game.pile.get(2);
            Cell t4 = (Cell)game.pile.get(3);
            Cell t5 = (Cell)game.pile.get(4);
            Cell t6 = (Cell)game.pile.get(5);
            Cell t7 = (Cell)game.pile.get(6);
            Cell t8 = (Cell)game.pile.get(7);

            Cell f1 = (Cell)game.free.get(0);
            Cell f2 = (Cell)game.free.get(1);
            Cell f3 = (Cell)game.free.get(2);
            Cell f4 = (Cell)game.free.get(3);
            Cell h1 = (Cell)game.home.get(0);
            Cell h2 = (Cell)game.home.get(1);
            Cell h3 = (Cell)game.home.get(2);
            Cell h4 = (Cell)game.home.get(3);

            TableauxPanel t = tCardPanels[0];
            t.setCard(t1);
            t = tCardPanels[1];
            t.setCard(t2);
            t = tCardPanels[2];
            t.setCard(t3);
            t = tCardPanels[3];
            t.setCard(t4);
            t = tCardPanels[4];
            t.setCard(t5);
            t = tCardPanels[5];
            t.setCard(t6);
            t = tCardPanels[6];
            t.setCard(t7);
            t = tCardPanels[7];
            t.setCard(t8);

            CardPanel hc = homeCardPanels[0];
            hc.setCard(h1.getTop());
            hc = homeCardPanels[1];
            hc.setCard(h2.getTop());
            hc = homeCardPanels[2];
            hc.setCard(h3.getTop());
            hc = homeCardPanels[3];
            hc.setCard(h4.getTop());


            CardPanel fc = freeCardPanels[0];
            fc.setCard(f1.getTop());
            fc = freeCardPanels[1];
            fc.setCard(f2.getTop());
            fc = freeCardPanels[2];
            fc.setCard(f3.getTop());
            fc = freeCardPanels[3];
            fc.setCard(f4.getTop());

        }


    }
}
