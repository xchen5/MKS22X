import java.util.Arrays;
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
	 try {
	     board[row][col] = 0;
	 }
	 catch (IndexOutOfBoundsException e){
	     return;
	 }
    }
   
    private boolean solveH(int row, int col, int level){
	if (level > (board.length * board[0].length)) {
	    return true;
	}
	else {    
	    if (solveH(row + 1, col + 2, level++) && addKnight(row + 1, col + 2, level++)) {
		return true;
	    }
	    else if (solveH(row + 1, col -2, level++) && addKnight(row + 1, col - 2, level++)) {
		return true;
	    }
	    else if (solveH(row - 1, col + 2, level++) && addKnight(row - 1, col + 2, level++)){
		return true;
	    }
	    else if (solveH(row - 1, col -2, level++) && addKnight(row - 1, col - 2, level++)){
		return true;
	    }
	    else if (solveH(row + 2, col +1,level++) && addKnight(row + 2, col + 1, level++)){
		return true;
	    }
	    else if (solveH (row + 2, col - 1, level++) && addKnight(row + 2, col -1, level++)){
		return true;
	    }
	    else if (solveH(row - 2, col -1, level++) && addKnight(row - 2, col - 1, level++)){
		return true;
	    } 
	    else if (solveH(row - 2, col +1,level ++) && addKnight (row - 2, col + 1, level ++)){
		return true;
	    }
	    removeKnight(row,col);
	}
	return false;
    }
    
    public void solve(){
	solveH(0, 0, 1);
    }

     public String toString( ){
	 return Arrays.deepToString(board).replace("], ", "]\n");
     }

    public static void main(String[]args){
	KnightBoard a = new KnightBoard(5,7);
	a.solveH(0,0,35);
	System.out.println(a.toString());
    }

}
