/*
 * @(#)CharRecogn.java 1.0 30/10/2016.
 */
package index;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import views.MainView;

/**
 * Clase principal del proyecto CharRecogn.
 *
 * @author Alfredo de la Garza
 * @version 1.0 30/10/2016
 * @since 1.0
 */
public class CharRecogn {

    /**
     * @param args argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CharRecogn.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MainView mainView = new MainView();
            mainView.setVisible(true);
        }
    }

}
