import java.awt.*;
import javax.swing.*;

public class SiteScanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pokemon Scanner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new PokeScannerPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
