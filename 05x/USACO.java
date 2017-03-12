import java.io.*;
import java.util.*;
public class USACO {
  private int[][]bronzePasture;
  private char[][]silverPasture;
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

  public void silver(String filename){
    try {
      solutionCount = 0;
      Scanner sc  = new Scanner (new File(filename));
      int row = Integer.parseInt(sc.next());
      int col = Integer.parseInt(sc.next());
      silverPasture = new char[row][col];
      seconds = Integer.parseInt(sc.next());
      sc.nextLine();
      for(int r = 0; r < row; r++){
        String txt = sc.nextLine();
        //System.out.println(txt);
        for (int c = 0; c< col; c++) {
            silverPasture[r][c] = txt.charAt(c);
        }
      }

      String out = "";
      for (int r = 0; r< row; r++) {
        out += "\n";
        for(int c = 0; c< col; c++) {
          out += silverPasture[r][c];
        }
      }
      System.out.println(out);
      int row1 = Integer.parseInt(sc.next()) - 1;
      int col1 = Integer.parseInt(sc.next()) - 1;
      int row2 = Integer.parseInt(sc.next()) - 1;
      int col2 = Integer.parseInt(sc.next()) - 1;
      silverPasture[row2][col2] = 'E';
      System.out.println(cowTravel(row1, col1));
    }
    catch (FileNotFoundException e) {
      System.out.println("File not found");
      System.exit(0);
    }
  }

  private boolean cowTravel(int r1, int c1) {
    if((r1 < silverPasture.length) && (r1 >= 0) && (c1 < silverPasture[0].length) && (c1 >= 0) ){
    if (silverPasture[r1][c1] == 'E' && (secTrack == seconds)) {
      secTrack = 0;
      return true;
    }
      if((silverPasture[r1][c1] == '.')) {
        silverPasture[r1][c1] = '@';
        if (cowTravel(r1 + 1, c1)) {
            secTrack += 1;
            return true;
        }
        if (cowTravel(r1 - 1, c1)) {
            secTrack += 1;
            return true;
        }
        if (cowTravel(r1, c1 + 1)){
            secTrack +=1;
            return true;
        }
        if (cowTravel(r1, c1 - 1)) {
            secTrack += 1;
            return true;
        }
        secTrack -= 1;
        silverPasture[r1][c1] = '#';
      }
    }
    return false;
  }

  public static void main(String[]args) {
    USACO x = new USACO();
    x.silver("travel.txt");

  }
}
