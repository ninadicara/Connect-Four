package defaultpackage;

public class Game {

	private Grid grid;
	private int players;
	private int currentPlayer;
	private int winningNumber;

	public Game(int rows, int columns, int players, int winningNumber) {
		grid = new Grid(rows, columns);
		this.players = players;
		this.winningNumber = winningNumber;
	}

	// detects whether a player has won the game
	public boolean hasWon() {
		int lastRow = grid.getLastPlayed()[0];
		int lastColumn = grid.getLastPlayed()[1];
		int rows = grid.getRows();  
		int columns = grid.getColumns();
		int counter1 = 1;
		int counter2 = 1;
		int counter3 = 1;
		int counter4 = 1;
	
		//horizontal checks
		for (int c = lastColumn; c < columns - 1; c++ ) {
			if (counter1 == winningNumber) {
				return true;
			}
			int value = grid.getIndex(lastRow, c);
			int nextValue = grid.getIndex(lastRow, c + 1);
			if (value == nextValue && value != 0) {
				counter1++;
			} else {
				break;
			}
		}
		
		for (int c = lastColumn; c >= 1; c--) {
			if (counter1 == winningNumber) {
				return true;
			}
			int value = grid.getIndex(lastRow, c);
			int nextValue = grid.getIndex(lastRow, c - 1);
			if (value == nextValue && value != 0) {
				counter1++;
			} else {
				break;
			}
		}
			 
		//vertical checks
		for (int r = lastRow; r < rows - 1 ; r++) {
			if (counter2 == winningNumber - 1) {
				return true;
			}
			int value = grid.getIndex(r, lastColumn);
			int nextValue = grid.getIndex(r + 1, lastColumn);
			if (value == nextValue && value != 0) {
				counter2++;
			} else {
				break;
			}
		}
		
		
		
		//diagonal checks \
		{
		int c = lastColumn;
        int r = lastRow;
        //increase rows and columns
        while (c < columns - 1 && r < rows - 1) {
            if (counter3 == winningNumber - 1) {
                return true;
            }
            int value = grid.getIndex(r, c);
            int nextValue = grid.getIndex(r + 1, c + 1);
            if (value == nextValue && value != 0) {
                counter3++;
            } 
            c++;
            r++;
        }
		}
		
        {
        int c = lastColumn;
        int r = lastRow;
        //decrease rows and columns
        while (c >= 1 && r < 1) {
            if (counter3 == winningNumber - 1) {
                return true;
            }
            int value = grid.getIndex(r, c);
            int nextValue = grid.getIndex(r - 1, c - 1);
            if (value == nextValue && value != 0) {
                counter3++;
            } 
            c--;
            r--;
        }
		}
		
		//diagonal checks /
    	{
    		int c = lastColumn;
            int r = lastRow;
            //increase columns decrease rows
            while (c < columns - 1 && r < 1) {
                if (counter4 == winningNumber) {
                    return true;
                }
                int value = grid.getIndex(r, c);
                int nextValue = grid.getIndex(r - 1, c + 1);
                if (value == nextValue && value != 0) {
                    counter4++;
                } 
                c++;
                r--;
            }
    		}
    	
    	{
    		int c = lastColumn;
            int r = lastRow;
            //increase rows decrease columns
            while (c >= 1 && r < rows - 1) {
                if (counter4 == winningNumber + 1) {
                    return true;
                }
                int value = grid.getIndex(r, c);
                int nextValue = grid.getIndex(r + 1, c - 1);
                if (value == nextValue && value != 0) {
                    counter4++;
                } 
                c--;
                r++;
            }
    		}
		return false;
	}

	// method called by GUI to drop a piece into this grid
	// also moves player number up by 1 each time
	public void makeMove(int column) {
		grid.dropPiece(column, currentPlayer + 1);
		currentPlayer++;
		currentPlayer %= players;

	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public Grid getGrid() {
		return grid;
	}
	
	public int getPlayers() {
		return players;
	}

	// enables a new game to be made
	public void newGame(int rows, int columns, int players, int winningNumber) {
		grid = new Grid(rows, columns);
		this.players = players;
		this.winningNumber = winningNumber;
		currentPlayer = 0;
	}

}
