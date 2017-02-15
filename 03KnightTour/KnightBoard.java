public class KnightBoard {
    private int[][]board;
   
    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];

    }
    
    private boolean addKnight(int row, int col, int number){
	try {
	    if (board[row][col] == 0){
		board[row][col] = number;
		return true;
	    }
	    else {
		return false;
	    }
	}
	catch (IndexOutOfBoundsException e) {
	    return false;
	}
    }
     
     private void removeKnight(int row, int col){
	 

    }
   
    private boolean solveH(int row, int col, int level){
	if (level == (board.length * board(0).length)) {
	    return true;
	}
	else { 
	    if (addKnight(row, col, level)){
		return solveH(row + 1, col + 2, level++)||solveH(row + 1, col -2, level++) || solveH(row - 1, col + 2, level++) || solveH(row - 1, col -2, level++) || solveH(row + 2, col +1) || solveH (row + 2, col - 1 
	    }
	    else {
		removeKnight(row,col);
	    }
	}
	return false;
    }
    
    public void solve(){
	solveH(0, 0, 0);
    }

     public String toString(){

     }*/
}
