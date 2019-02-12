
import Game.Coin;
import UI.UI;
import java.io.IOException;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) throws IOException {
        UI ui = new UI();
        SwingUtilities.invokeLater(ui);
    }
    
}
