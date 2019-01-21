package defaultpackage;

//Class to control interaction with the 2D array representing the playing grid

public class Grid {
	
	private int[][] currentGrid;
	private int lastPlay[] = new int[2];
	
			
	//constructor
	public Grid(int rows, int columns) {
		currentGrid = new int[rows][columns];
	}
	
	//gets the integer at a certain place in the array
	public int getIndex(int row, int column) {
		return currentGrid[row][column];
	}
	
	//gets the number of rows in the grid
	public int getRows() {
		return currentGrid.length;
	}
	
	//gets the number of columns in the grid
	public int getColumns() {
		return currentGrid[0].length;
	}
	
	//places a 'piece' in the array
	public boolean dropPiece(int column, int currentPlayer) {
		try{
		for(int i=getRows()-1; i>=0;) {
			
			if(getIndex(i,column)==0){
				currentGrid[i][column] = currentPlayer;
				lastPlay[0] = i;  //resets lastPlay to the piece most recently placed
				lastPlay[1] = column;
				return true;
			}
			else{ 
				i--;
			}
		}}
		catch(IndexOutOfBoundsException e){
			throw new IllegalArgumentException("This column is full. Please try again.");
		}
		return false; 
	}

	//gets the place of the last piece played
		public int[] getLastPlayed() {
			return lastPlay;
			
		}

}