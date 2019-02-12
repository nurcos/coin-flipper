package UI;

import Game.Coin;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CoinListener implements ActionListener{
    private Coin coin;
    private JButton button;
    private JTextField enter;
    private JLabel heads;
    private JLabel tails;
    private JPanel imagePanel;
    
    public CoinListener(Coin coin, JButton button, JTextField enter, JLabel heads, JLabel tails, JPanel imagePanel) {
        this.coin = coin;
        this.button = button;
        this.enter = enter;
        this.heads = heads;
        this.tails = tails;
        this.imagePanel = imagePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            coin.flip(Integer.parseInt(enter.getText()));
        }
        catch(Exception f){
            
        }
        
        String headsText = "";
        headsText += coin.getHeads();
        
        String tailsText = "";
        tailsText += coin.getTails();
        
        this.heads.setText(headsText);
        this.tails.setText(tailsText);
        
        
        imagePanel.removeAll();
        Image image = null;
        
        try{
            if(coin.getHeads() >= coin.getTails()){
                image = ImageIO.read(new File("src/Resources/heads.jpg"));
            }
            else{
                image = ImageIO.read(new File("src/Resources/tails.jpg"));
            }
        }
        catch (IOException x){
                
        }

        JLabel picLabel = new JLabel(new ImageIcon(image));
        imagePanel.add(picLabel);
        
    }

}
