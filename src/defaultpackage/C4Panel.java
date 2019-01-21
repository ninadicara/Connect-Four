package defaultpackage;

import java.awt.BorderLayout;
import javax.swing.JPanel;



public class C4Panel extends JPanel {
    
    Game game;
    C4ButtonPanel buttonPanel;
    C4GridPanel gridPanel;

    //creates panel which contains button panel and grid panel in a border layout
    public C4Panel() {
        game = new Game(6, 7, 2, 4);
        gridPanel = new C4GridPanel(game);
        buttonPanel = new C4ButtonPanel(game, gridPanel);
        setLayout(new BorderLayout());
        add(gridPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.NORTH); 
        
    }
        
    
}
