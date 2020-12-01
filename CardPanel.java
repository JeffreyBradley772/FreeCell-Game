/*
 *
 * File: CardPanel.java
 * project5
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BreezySwing.*;

/**
 * Represents the GUI component for painting an image of a playing card.
 *
 */
public class CardPanel extends GBPanel{

    private Card card;
    private int id;
    private char r;
    private MainView view;

    /**
     * Constructor for an empty panel, displays a wire frame.
     */
    public CardPanel(MainView view, int id, char r){
        this(null, view, id,r);
    }

    /**
     * Constructor to display a given card's image.
     * @param c the card to display.
     */
    public CardPanel(Card c, MainView view, int id, char r){ // id = pile number

        setBackground(Color.black);
        this.card = c;
        this.id = id;
        this.r = r;
        this.view = view;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (r == 'h'){
                    view.clickedHome(id);

                    //System.out.println("Clicked Home" + id + r);
                }else{
                    view.clickedFree(id);

                    //System.out.println("Clicked Free" + id + r);
                }

            }
        });
    }

    /**
     * Paints the card's face image if a card is present, otherwise, paints the back side image.
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Icon image;
        if (card == null){
            image = Card.getBack();
            g.setColor(Color.yellow);
            int x = (getWidth() - image.getIconWidth()) / 2;
            int y = (getHeight() - image.getIconHeight()) / 2;
            g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
        }
        else{
            image = card.getImage();
            int x = (getWidth() - image.getIconWidth()) / 2;
            int y = (getHeight() - image.getIconHeight()) / 2;
            image.paintIcon(this, g, x, y);
        }
    }

    /**
     * Resets the panel's card and refreshes the panel.
     * @param c the card to be displayed.
     */
    public void setCard(Card c){
        card = c;
        repaint();
    }

}
