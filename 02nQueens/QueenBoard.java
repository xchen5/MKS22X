import java.util.Arrays;
public class QueenBoard{
    private int[][]board;
    private int solutionCount;

    public QueenBoard(int size){
	     board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition:
     *if false: board is still filled with 0's
     *if true: board is filled with the
     *final configuration of the board after adding
     *all n queens. Uses solveH
     */
/*    public boolean solve()
    {
	return solveH(0);
    }

    private boolean solveH(int col){
	return false;
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.
     */
  /*  public int getSolutionCount(){
    	return -1;
    }
    /**toString
     *and all nunbers that represent queens are replaced with 'Q'
     *all others are displayed as underscores '_'
     */
  /*  public String toString(){
    	return "";  */

    private void addQueen(int r,int c) {
      //up down
      for (int i = r; i <board.length; i++) {
        board[i][c] += 1;
      }
      for (int i = r; i >= 0; i--) {
        board[i][c] += 1;
      }
      //left right
      for (int i = c; i <board[r].length; i++) {
        board[r][i] += 1;
      }
      for (int i = c; i >= 0; i--) {
        board[r][i] += 1;
      }
      //diaganol
      for( int i = r ; i < board.length; i++) {
        int ci = c;
        if (ci < board.length) {
        board[i][ci] +=1;
        ci++;
      }

    }
      board[r][c] = -1;


    }
  /*  private void removeQueen(int r, int c)

} */

  public static void main(String[] args) {
      QueenBoard a = new QueenBoard(5);
      a.addQueen(2,2);
      System.out.println(Arrays.deepToString(a.board).replace("], ", "]\n"));
  }
}
