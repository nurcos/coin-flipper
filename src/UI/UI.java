package UI;

import Game.Coin;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class UI implements Runnable{
    
    private JFrame frame;
    private Coin coin = new Coin();
    private JLabel headsAmount;
    private JLabel tailsAmount;
    private JPanel imagePanel  = new JPanel();
    
    
    public UI() throws IOException {
        coin = new Coin();
    }

    @Override
    public void run() {
        frame  = new JFrame("Coin Flipper");
        frame.setPreferredSize(new Dimension(400, 400));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(2,1);
        container.setLayout(layout);
        
        JPanel top = new JPanel();
        JPanel bottom = new JPanel(new GridLayout(2,1));
        container.add(top);
        container.add(bottom);
        
        top.add(createCoinPanel());
        bottom.add(createTotalPanel());
        bottom.add(createFlipPanel());
    }
    
    private JPanel createCoinPanel(){
        JLabel picLabel = new JLabel();
        
        imagePanel.add(picLabel);
        return imagePanel;
    }
    
    private JPanel createTotalPanel(){
        JPanel panel = new JPanel(new GridLayout(1,4));
        
        JLabel heads = new JLabel("Heads:");
        panel.add(heads);
        headsAmount = new JLabel("0");
        panel.add(headsAmount);
        
        JLabel tails = new JLabel("Tails:");
        panel.add(tails);
        tailsAmount = new JLabel("0");
        panel.add(tailsAmount);
        
        return panel;
    }
    
        private JPanel createFlipPanel(){
        JPanel panel = new JPanel(new GridLayout(1,3));
        
        JLabel enter = new JLabel("Enter amount to flip:");
        panel.add(enter);
        
        JTextField inputAmount = new JTextField();
        panel.add(inputAmount);
        
        JButton button = new JButton("Flip");
        panel.add(button);
        
        CoinListener listener = new CoinListener(coin, button, inputAmount, headsAmount, tailsAmount, imagePanel);
        button.addActionListener(listener);
        
        return panel;
    }

    
}
