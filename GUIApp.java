import javax.swing.JFrame;

/**
 * Generic main method template for any GUI-based application.
 * Instantiates a model and passes it to a new view.
 *
 */
public class GUIApp {

    public static void main(String[] args){
        final FreecellGame game = new FreecellGame();
        final JFrame view = new MainView(game);
    }
}
