public class GameStrategy {
	private boolean placedQueens[][] = new boolean[8][8];
	private int numQueens = 0;

	private int getColumn(int cellId) {
		return cellId%8;		
	}
	
	private int getRow(int cellId) {
		return cellId/8;
	}

	public boolean isValidPosition(int cellId) {
		boolean isValid = true;

		if(numQueens == 8) throw new GameOverException();	// just return out of the method

		// the game is still on, so let us continue...
		
		int col = getColumn(cellId);
		
		int row = getRow(cellId);
		
		if(placedQueens[row][col])
			return false;
		numQueens++;
		
		for(int i=0;i<8;i++)
		{
			placedQueens[row][i]=true;
			placedQueens[i][col]=true;
			if(row+1+i<8 && col+i+1<8)
				placedQueens[row+i+1][col+i+1]=true;
			if(row+1+i<8 && col-i-1>=0)
				placedQueens[row+i+1][col-i-1]=true;
			if(row-1-i>=0 && col+i+1<8)
				placedQueens[row-i-1][col+i+1]=true;
			if(row-1-i>=0 && col-i-1>=0)
				placedQueens[row-i-1][col-i-1]=true;
		}
		return isValid;
	}
}














