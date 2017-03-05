import java.util.*;
import java.io.*;

public class Maze{

  private char[][]maze;
  private boolean animate;
  private int startRow;
  private int startCol;
  private int endRow;
  private int endCol;

  /*Constructor loads a maze text file, and sets animate to false by default.
  1. The file contains a rectangular ascii maze, made with the following 4 characters:
  '#' - locations that cannot be moved onto
  ' ' - locations that can be moved onto
  'E' - the location of the goal (exactly 1 per file)
  'S' - the location of the start(exactly 1 per file)

  2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
  3. When the file is not found OR there is no E or S then: print an error and exit the program.
  */
  public Maze(String filename){
    try {
      Scanner sc = new Scanner(new File(filename));
      Scanner scan = new Scanner(new File(filename));
      int r = 0;
      int c = 0;

      boolean E = false;
      boolean S = false;

      while(sc.hasNextLine()){
        r += 1;
        c += sc.nextLine().length();
      }
      c = c/r;
      maze = new char[r][c];

      System.out.println("r:" + r +", c:" + c);
      System.out.println("# of chars: " + (maze.length * maze[1].length));
      //Putting the chars into the array
      int row = -1;
      while(scan.hasNextLine()){
        row += 1;
        // System.out.println(row);
        String txt = scan.nextLine();
        //System.out.println(txt);
        for(int col = 0;col < c; col++) {
          maze[row][col] = txt.charAt(col);
          if (maze[row][col] == 'E') {
            E = true;
            endRow = row;
            endCol = col;
          }
          if (maze[row][col] == 'S'){
            S = true;
            startRow = row;
            startCol = col;
          }
          /* System.out.println("row is: " + row + " col is: " + col + " char is:  " +  maze[row][col]);*/

        }
      }

      if (S == false || E == false) {
        System.out.println("There is no start (S) or end (E) in the text file");
        System.exit(0);
      }
      // System.out.println("S is: " + S);
      // System.out.println("E is: " + E);
      System.out.println("These are the starting coordinates: " + startRow + ", " + startCol + " test:  " +  maze[5][1]);
      System.out.println("These are the ending coordinates: " + endRow + ", " + endCol + " test: " +  maze[3][3] );
      System.out.println(Arrays.deepToString(maze));
    }
    catch(FileNotFoundException e) {
      System.out.println("File not found");
    }

  }

  private void wait(int millis){ //ADDED SORRY!
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  public void setAnimate(boolean b){
    animate = b;
  }

  public void clearTerminal(){
    //erase terminal, go to top left of screen.
    System.out.println("\033[2J\033[1;1H");
  }


  /*Wrapper Solve Function
  Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
  */
  public boolean solve(){
    int startx= startRow;
    int starty= startCol;
    //Initialize startx and starty with the location of the S.
    maze[startx][starty] = ' ';//erase the S, and start solving!
    return solve(startx,starty);
  }

  /*
  Recursive Solve function:

  A solved maze has a path marked with '@' from S to E.

  Returns true when the maze is solved,
  Returns false when the maze has no solution.

  Postcondition:
  The S is replaced with '@' but the 'E' is not.
  All visited spots that were not part of the solution are changed to '.'
  All visited spots that are part of the solution are changed to '@'
  */
  private boolean solve(int x, int y){
    if(animate){
      System.out.println("\033[2J\033[1;1H"+this);
      wait(20);
    }
    if (maze[x][y] == 'E'){
      return true;
    }
    if ((maze[x][y] == ' ')) {
      maze[x][y] = '@';
      if(solve(x+1, y))
      {
        return true;
      }
      else if(solve(x, y+1)){
        return true;
      }
      else if(solve(x-1,y)){
        return true;
      }
      else if(solve(x,y-1)){
        return true;
      }
      maze[x][y] = '.';
    }
    //COMPLETE SOLVE
    return false; //so it compiles
  }
  public String toString(){
    String temp = "";
    for (int r = 0; r<maze.length; r++){
      temp += "\n";
      for (int c = 0; c <maze[0].length; c++){
        temp += maze[r][c];
      }
    }
    return temp;
  }
  /*public static void main (String[]args) {
    Maze f;
    f = new Maze("test3.txt");
    f.setAnimate(true);
    System.out.println(f.solve());

  }*/

}

