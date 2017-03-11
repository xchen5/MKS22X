import java.io.*;
import java.util.*;
public class USACO {
  private int[][]bronzePasture;
  private int finalEleveation;

  public int bronze(String filename){
    try {
      Scanner sc = new Scanner (new File(filename));
      int row = Integer.parseInt(sc.next());
      int col = Integer.parseInt(sc.next());
      bronzePasture = new int[row][col];
      finalEleveation = Integer.parseInt(sc.next());
      int numInstructions = Integer.parseInt(sc.next());
      sc.nextLine();
      for (int r = 0; r<row; r++){
        for(int c = 0; c<col; c++){
          bronzePasture[r][c] = Integer.parseInt(sc.next());
        }
      }
      for(int i = 0; i < numInstructions; i++) {
        cowStomping(Integer.parseInt(sc.next()) - 1,Integer.parseInt(sc.next()) - 1,Integer.parseInt(sc.next()));
      }
      System.out.println(Arrays.deepToString(bronzePasture));
      // getting the final answer
      int sum = 0;
      for (int r = 0; r < row; r++){
        for (int c = 0; c< col; c++){
          bronzePasture[r][c] = 22 - bronzePasture[r][c];
          if (bronzePasture[r][c] > 0) {
            sum += bronzePasture[r][c];
          }
        }
      }
      System.out.println(Arrays.deepToString(bronzePasture));
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

  public static int silver(String filename){

  }

  public static void main(String[]args) {
    USACO x = new USACO();
    System.out.println(x.bronze("makelake.txt"));
  }
}
