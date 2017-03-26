import java.io.*;
import java.util.*;
public class USACO {
  private int[][]bronzePasture;
  private int[][]silverPasture;
  private int seconds;
  private int solutionCount;
  private int secTrack;

  public int bronze(String filename){
    try {
      Scanner sc = new Scanner (new File(filename));
      int row = Integer.parseInt(sc.next());
      int col = Integer.parseInt(sc.next());
      bronzePasture = new int[row][col];
      int finalElevation = Integer.parseInt(sc.next());
      int numInstructions = Integer.parseInt(sc.next());
      //sc.nextLine();
      for (int r = 0; r<row; r++){
        for(int c = 0; c<col; c++){
          bronzePasture[r][c] = Integer.parseInt(sc.next());
        }
      }
      for(int i = 0; i < numInstructions; i++) {
        cowStomping(Integer.parseInt(sc.next()) - 1,Integer.parseInt(sc.next()) - 1,Integer.parseInt(sc.next()));
      }
      //System.out.println(Arrays.deepToString(bronzePasture));
      // getting the final answer
      int sum = 0;
      for (int r = 0; r < row; r++){
        for (int c = 0; c< col; c++){
          bronzePasture[r][c] = finalElevation - bronzePasture[r][c];
          if (bronzePasture[r][c] > 0) {
            sum += bronzePasture[r][c];
          }
        }
      }
      //System.out.println(Arrays.deepToString(bronzePasture));
      return sum * 72 * 72;
    }

    catch (FileNotFoundException e) {
      System.out.println("File not found");
      return 0;
    }
  }

  private void cowStomping(int row, int column, int depth){
    int largest = 0;
    for (int r = row; r < row + 3; r++) {
      for (int c = column; c < column + 3; c++) {
        if (bronzePasture[r][c] > largest) {
          largest = bronzePasture[r][c];
        }
      }
    }
    int newLarge = largest - depth;
    for (int r = row; r < row + 3; r++) {
      for (int c = column; c < column + 3; c++) {
        if (bronzePasture[r][c] > newLarge) {
          bronzePasture[r][c] = newLarge;
        }
      }
    }
  }

  public int silver(String filename){
    try {
      solutionCount = 0;
      Scanner sc  = new Scanner (new File(filename));
      int row = Integer.parseInt(sc.next());
      int col = Integer.parseInt(sc.next());
      silverPasture = new int[row][col];
      seconds = Integer.parseInt(sc.next());
      sc.nextLine();
      for(int r = 0; r < row; r++){
        String txt = sc.nextLine();
        //System.out.println(txt);
        for (int c = 0; c< col; c++) {
            if(txt.charAt(c) == '.'){
              silverPasture[r][c] = 0;
            }
            else if(txt.charAt(c) == '*'){
              silverPasture[r][c] = -1;
            }
        }
      }
      int row1 = Integer.parseInt(sc.next()) - 1;
      int col1 = Integer.parseInt(sc.next()) - 1;
      int row2 = Integer.parseInt(sc.next()) - 1;
      int col2 = Integer.parseInt(sc.next()) - 1;
      startAdjacent(row1,col1);
      for(int i = 1; i < seconds; i++){
        addAdjacent();
      }
      return silverPasture[row2][col2];
      /*String out = "";
      for (int r = 0; r< row; r++) {
        out += "\n";
        for(int c = 0; c< col; c++) {
          out += silverPasture[r][c] + " ";
        }
      }
      System.out.println(out);*/
    }
    catch (FileNotFoundException e) {
      System.out.println("File not found");
      return -1;
    }
  }

  private boolean onBoard(int r, int c) {
    return (r >= 0 && r < silverPasture.length) && (c >= 0 && c < silverPasture[0].length);
  }

  private void addAdjacent() {
    int[][]secondSilverPasture = new int[silverPasture.length][silverPasture[0].length];
    for(int r = 0; r < silverPasture.length; r++){
      for (int c = 0;c < silverPasture[0].length;c++ ) {
        if(onBoard(r + 1, c)  && (isNotTree(r + 1, c))) {
          secondSilverPasture[r][c] += silverPasture[r + 1][c];
        }
        if(onBoard(r - 1, c)  && (isNotTree(r - 1, c))) {
          secondSilverPasture[r][c] += silverPasture[r - 1][c];
        }
        if(onBoard(r, c + 1)  && (isNotTree(r, c + 1))) {
          secondSilverPasture[r][c] += silverPasture[r][c + 1];
        }
        if(onBoard(r, c - 1)  && (isNotTree(r, c - 1))) {
          secondSilverPasture[r][c] += silverPasture[r][c - 1];
        }
        if(silverPasture[r][c] == -1){
          secondSilverPasture[r][c] = -1;
        }
      }
    }
    silverPasture = secondSilverPasture;
  }

  private void startAdjacent(int r, int c){
    if(onBoard(r+1, c) && (isNotTree(r+1, c))){
      silverPasture[r+1][c] = 1;
    }
    if(onBoard(r-1, c) && (isNotTree(r-1, c))){
      silverPasture[r-1][c] = 1;
    }
    if(onBoard(r, c + 1) && (isNotTree(r, c + 1))){
      silverPasture[r][c + 1] = 1;
    }
    if(onBoard(r, c - 1) && (isNotTree(r, c - 1))){
      silverPasture[r][c - 1] = 1;
    }
  }
  private boolean isNotTree(int r, int c) {
    return !(silverPasture[r][c] == -1);
  }
  public static void main(String[]args) {
    USACO x = new USACO();
    System.out.println(x.silver("travel.txt"));
  }
}
