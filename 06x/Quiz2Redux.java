import java.util.*;
public class Quiz2Redux{
  /*Returns an ArrayList<String> that contains all subsets of the
   *characters of String s. Assume s has no duplicate characters.
   *the characters should appear in the same order that they occur
   *in the original string.
   */
  public static ArrayList<String> combinations(String s){
      ArrayList<String>words = new ArrayList<String>();
      help( words , s, 0, "");
      Collections.sort(words);
      return words;
  }

  private static void help( ArrayList<String> words, String s, int counter, String addition)
/*fill this in with more arguments*/
  {
    if (s.length() <= counter ) {
      words.add(addition);
    }
    else {
    //used groupsum as reference, continued adding the index by 1 and either add the character or not
    help(words,s, counter + 1, addition + s.charAt(counter));
    help(words,s, counter + 1, addition);
    }

       /*METHOD TO BE WRITTEN BY YOU.*/
  }

  public static void main(String[]args) {
    System.out.println(combinations("abcd"));
  }
}
