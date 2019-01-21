package defaultpackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class C4GridPanel extends JPanel implements MouseListener {

	private Game game;
	private int drawSize = 50;

	public C4GridPanel(Game game) {
		this.game = game;
		addMouseListener(this);
	}
	//method responsible for painting the grid according to new game specifications 
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		int rows = game.getGrid().getRows();
		int columns = game.getGrid().getColumns();
		g.setColor(Color.blue);
		g.fillRect(10, 10, columns * (drawSize + 10), rows * (drawSize + 10));
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				switch (game.getGrid().getIndex(r, c)) {
				case 1:
					g.setColor(Color.red);
					break;
				case 2:
					g.setColor(Color.yellow);
					break;
				case 3:
					g.setColor(Color.green);
					break;
				case 4:
					g.setColor(Color.cyan);
					break;
				case 5:
					g.setColor(Color.magenta);
					break;
				case 6:
					g.setColor(Color.orange);
					break;
				default:
					g.setColor(Color.white);
					break;
				}
				g.drawOval(15 + (c * (drawSize + 10)),
						15 + (r * (drawSize + 10)), drawSize, drawSize);
				g.fillOval(15 + (c * (drawSize + 10)),
						15 + (r * (drawSize + 10)), drawSize, drawSize);
			}
		}
		repaint();
	}

	//method which calculates coordinates and therefore column of a mouse click
	//method also calls hasWon() and repaints grid if there is a winner
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int c = (x - 15) / (drawSize + 10);
		int r = (y - 15) / (drawSize + 10);

		if (y >= 15 + (game.getGrid().getRows() * (drawSize + 10))) {
			JOptionPane.showMessageDialog(this, "Please click on a column");
		} else {
			game.makeMove(c);
		}
		if (game.hasWon() == true) {
			int player = game.getCurrentPlayer();
				if (player == 0) {
				 player = game.getPlayers();
				}
			JOptionPane.showMessageDialog(this,
					"Player " + player + " has won!");
			game = new Game(6, 7, 2, 4);
		
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
