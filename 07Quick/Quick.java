import java.util.*;
public class Quick {
  public static int part ( int [] data, int start, int end){
    //-Choose a random element to be a pivot, and partition the array around it.
    //-Only partition the elements from start to end inclusive.
    //-When done returns the index of the final position of the pivot element.
    //    (Should be from start to end inclusive)

    int pivot = (int) (Math.random() * end) ;
    int pivotValue = data[pivot];
    int endVal = data[end];
    System.out.println(data[pivot]);
    data[end] = pivotValue;
    data[pivot] = endVal;
    int startCounter = start;

    for(int i = 0; i < end; i++){
      if(data[i] < pivotValue) {
        startCounter += 1;
        int tempStart = data[startCounter];
        int tempI = data[i];
        data[startCounter] = tempI;
        data[i] = tempStart;
      }
    }

    for(int i = end - 1; i > startCounter; i--) {
      data[i + 1] = data[i];
    }

    data[startCounter + 1] = pivotValue;

    for(int i = 0; i < data.length; i++) {
      System.out.print(data[i] + " ");
    }
    System.out.print("\n");
    return (startCounter + 1);
  }

  public static int quickselect(int[]data, int k){
    int pivot = part(data, -1, data.length - 1);
    if (k == pivot) {
      return data[k];
    }
    return quickselect(data,k);
  }


  public static void main(String[]args){
    int[]ary={999,999,999,4,1,0,3,2,999,999,999};
    System.out.println("a");
  }

}
