package defaultpackage;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class C4ButtonPanel extends JPanel implements ActionListener {

    private Game game;
    private C4GridPanel gridPanel;
    private JButton newGameButton = new JButton("Start New Game");

    public C4ButtonPanel(Game game, C4GridPanel gridPanel) {
        this.game = game;
        this.gridPanel = gridPanel;
        newGameButton.addActionListener(this);
        add(newGameButton);
    }
    
    //"Start New Game" Button which prompts input for the arguments of Game.
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == newGameButton) {

                int players;
                //making sure choice of players in continued until a valid selection is made
                do {
                    players = Integer.parseInt(JOptionPane.showInputDialog(
                            "Input number of players between 2 and 6:", 2));
                    if (players > 6 || players < 2) {
                        JOptionPane
                                .showMessageDialog(this,
                                        "Please enter an integer number between 2 and 6.");
                    }
                } while (players > 6 || players < 2);
                
                int rows = Integer.parseInt(JOptionPane.showInputDialog(
                        "Input number of rows:", 6));

                int columns = Integer.parseInt(JOptionPane.showInputDialog(
                        "Input number of columns:", 7));

                int winningNumber = Integer.parseInt(JOptionPane
                        .showInputDialog(
                                "Input winning number of tokens in a row:", 4));

                game.newGame(rows, columns, players, winningNumber);
                gridPanel.repaint();
            }
        //to deal with an exception if the character entered is not an integer
        } catch (NumberFormatException nFE) {
            JOptionPane.showMessageDialog(this,
                    "Please make sure you enter an integer.");
        }
    }

}