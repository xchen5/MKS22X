public class KnightBoard {
  private int[][]board;

  public KnightBoard(int startingRows, int startingCols){
    board = new int[startingRows][startingCols];
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        board[row][col] = 0;
      }
    }
  }

  private void addKnight(int row, int col, int number){
    board[row][col] = number;
  }

  private boolean isSafe(int row, int col) {
    if ( (row >= 0) &&
    (col >= 0) &&
    (row < board.length) &&
    (col < board[0].length)&&
    (board[row][col] == 0)){
      return true;
    }
    else
    {
      return false;
    }
  }

  private boolean solveH(int row, int col, int level){
    if (level > (board.length * board[0].length)) {
      return true;
    }
    if (isSafe(row, col)) {
      addKnight(row, col, level);
      if (solveH(row + 1, col + 2, level + 1) ||
      solveH(row + 1, col - 2, level + 1) ||
      solveH(row - 1, col + 2, level + 1) ||
      solveH(row - 1, col - 2, level + 1) ||
      solveH(row + 2, col + 1, level + 1) ||
      solveH(row + 2, col - 1, level + 1) ||
      solveH(row - 2, col - 1, level + 1) ||
      solveH(row - 2, col + 1, level + 1)) {
        return true;
      }
      board[row][col] = 0;
    }
    return false;
  }

  public void solve(){
    solveH(0, 0, 1);
  }

  public boolean doubleDigit() {
    boolean nah = false;
    for (int r = 0; r<board.length;r++){
      for(int c= 0; c<board[0].length; c++) {
        if (board[r][c] >= 10) {
          nah = true;
        }
      }
    }
    return nah;
  }

  public String toString( ){
    String temp = "";
    boolean doublee = doubleDigit();
    for (int r = 0; r < board.length; r++){
      if (r >= 1) {
        temp += "\n";}
        for (int c = 0; c < board[0].length; c++) {
          if (doublee) {
            if (board[r][c] < 10) {
              temp += " " + board[r][c] + " ";
            }
            else {
              temp += board[r][c] + " ";
            }
          }
          else {
            temp += board[r][c] + " ";
          }
        }
      }
      return temp;
    }

    /*public static void main(String[]args){
      KnightBoard a = new KnightBoard(7,7 );
      a.solve();
      System.out.println(a.toString());
    }*/

  }
