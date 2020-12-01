/*
 * File: CardPanel.java
 * project5
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BreezySwing.*;

/**
 * Represents the GUI component for painting an image of a playing card.
 * @author lambertk
 *
 */
public class TableauxPanel extends GBPanel{

    private Card card;
    private int id;
    private char r;
    private Cell pile;
    private MainView view;

    /**
     * Constructor for an empty panel, displays a wire frame.
     */
    public TableauxPanel(MainView view,int id, char r){
        this(null,view, id,r);
    }

    /**
     * Constructor to display a given card's image.
     * @param c the card to display.
     */
    public TableauxPanel(Cell pile, MainView view,int id, char r){ // id = pile number

        setBackground(Color.black);
        this.pile = pile;
        this.id = id;
        this.r = r;
        this.view = view;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if (!(pile == null)){
                    ;
                }else{
                    view.clickedTableaux(id);
                }

                //System.out.println("Clicked tableaux " + id + r);
            }
        });
    }

    /**
     * Paints the card's face image if a card is present, otherwise, paints the back side image.
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Icon image;
        if (pile == null){
            image = Card.getBack();
            g.setColor(Color.yellow);
            int x = (getWidth() - image.getIconWidth()) / 2;
            int y = (getHeight() - image.getIconHeight()) / 2;
            g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
        }
        else{

            for (int i = 0; i < pile.size();i++){
                Card c = pile.get(i);
                if (!c.isFaceUp()){
                    c.turn();
                }
                image = c.getImage();
                int x = (getWidth() - image.getIconWidth()) / 2;
                int y = (getHeight() - image.getIconHeight()) / 2 + (i*20) - 100;
                image.paintIcon(this, g, x, y);
            }

        }
    }

    /**
     * Resets the panel's card and refreshes the panel.
     * @param c the card to be displayed.
     */
    public void setCard(Cell p){
        pile = p;
        repaint();
    }

}
