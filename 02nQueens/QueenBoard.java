import java.util.Arrays;
public class QueenBoard{
  private int[][]board;
  private int solutionCount;

  public QueenBoard(int size){
    board = new int[size][size];
    solutionCount = -1;
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
  public void solve()
  {
    solveH(0);
  }

  public void countSolutions(){
   solveC(0);
   solutionCount += 1;
  }

private void solveC(int col){
  if (col == board.length){
    solutionCount += 1;
    return;
  }
  for(int row = 0; row < board.length; row++){
    if (board[row][col] == 0) {
      addQueen(row, col);
      solveC(col + 1);
      removeQueen(row, col);
    }
  }
  return ;
}

private boolean solveH(int col){
  if (col == board.length){
    return true;
  }
  for(int row = 0; row < board.length; row++){
    if (board[row][col] == 0) {
      addQueen(row, col);
      if (solveH(col + 1)){
        return true;
      };
      removeQueen(row, col);
    }
  }
  return false;
   }

/**
*@return the number of solutions found, or -1 if the board was never solved.
*The board should be reset after this is run.
*/
public int getSolutionCount(){
  if (solutionCount == -1 ){
    return -1;
  }
  else {
    for (int r = 0; r < board.length; r++) {
      for (int c= 0; c<board.length; c++) {
        board[r][c] = 0;
      }
    }
    return solutionCount;

  }
}
/**toString
*and all nunbers that represent queens are replaced with 'Q'
*all others are displayed as underscores '_'
*/
 public String toString(){
   String temp = Arrays.deepToString(board).replace("], ", "]\n");
   temp = temp.substring(1,temp.length() - 1);
   temp = temp.replace(",", " ");
   temp = temp.replace("[" , "");
   temp = temp.replace("]" , "");
   temp = temp.replace("-1", "Q");
   temp = temp.replaceAll("[0-9]+", "_");
   return temp;
}
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
  //diagonal
  for( int i = 0 ;(r + i < board.length)&&(c + i < board.length); i++) {
    board[r+i][c+i]+=1;
  }
  for( int i = 0 ;(r + i >= 0)&&(c + i >= 0); i--) {
    board[r+i][c+i]+=1;
  }
  for( int i = 0 ;(r + i < board.length)&&(c - i >= 0); i++) {
    board[r+i][c-i]+=1;
  }
  for( int i = 0 ;(r-i >= 0)&&(c + i <board.length); i++) {
    board[r-i][c+i]+=1;
  }
  board[r][c] = -1;
}
private void removeQueen(int r, int c) {
  //up down
  for (int i = r; i <board.length; i++) {
    board[i][c] -= 1;
  }
  for (int i = r; i >= 0; i--) {
    board[i][c] -= 1;
  }
  //left right
  for (int i = c; i <board[r].length; i++) {
    board[r][i] -= 1;
  }
  for (int i = c; i >= 0; i--) {
    board[r][i] -= 1;
  }
  //diagonal
  for( int i = 0 ;(r + i < board.length)&&(c + i < board.length); i++) {
    board[r+i][c+i]-=1;
  }
  for( int i = 0 ;(r + i >= 0)&&(c + i >= 0); i--) {
    board[r+i][c+i]-=1;
  }
  for( int i = 0 ;(r + i < board.length)&&(c - i >= 0); i++) {
    board[r+i][c-i]-=1;
  }
  for( int i = 0 ;(r-i >= 0)&&(c + i <board.length); i++) {
    board[r-i][c+i]-=1;
  }
  board[r][c] = 0;
}

  public static void main(String[] args) {
      QueenBoard a = new QueenBoard(2);
      a.countSolutions();
      System.out.println(a.getSolutionCount());
  }
}
