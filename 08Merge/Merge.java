import java.util.*;
public class Merge {
  public static void merge(int[]a,int[]b,int[]destination) {
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < a.length && j < b.length){
      if(a[i] <= b[j]) {
        destination[k] = a[i];
        i++;
        k++;
      }
      else {
        destination[k] = b[j];
        j++;
        k++;
      }
    }
    while (i < a.length) {
      destination[k] = a[i];
      i++;
      k++;
    }
    while (j < b.length){
      destination[k] = b[j];
      j++;
      k++;
    }
  }

  public static void mergesort(int[]ary) {
    if(ary.length < 2) {
      return;
    }
    else {
      int leftSide = ary.length / 2;
      int rightSide = ary.length - leftSide;
      int[]left = new int[leftSide];
      int[]right = new int[rightSide];
      //System.out.println(leftSide + " " + rightSide);
      for(int i = 0; i < leftSide; i++){
        left[i] = ary[i];
      }
      for(int i = 0; i < ary.length - leftSide; i++){
        right[i] = ary[i + leftSide];
      }
      mergesort(left);
      mergesort(right);
      merge(left, right, ary);
      //System.out.println(Arrays.toString(left));
      //System.out.println(Arrays.toString(right));
    }
  }
}
