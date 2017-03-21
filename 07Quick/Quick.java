import java.util.*;
public class Quick {
    /* public static int part ( int [] data, int start, int end){
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
  } */

    public static int part(int[]data,int start, int end){
	int lt = start + 1;
	int gt = end;
	int i = start + 2;
	int pivot = (int) (Math.random() * end) ;
	int pivotValue = data[pivot];
	System.out.println(pivotValue);
	swap(data, pivot, 0);
	while (i<=gt) {
	    if (data[i] == pivotValue){
		i++;
	    }
	    else if(data[i] < pivotValue)
		{
		    swap(data, i, lt);
		    lt++;
		    i++;
		}
	    else {	
		swap(data, i, gt);
		gt--;
	    }
	}
	swap(data, 0, lt + 1);
	System.out.println(Arrays.toString(data));
	return lt + 1;
      
    }

    public static void swap(int[]data, int ind1, int ind2){
	int tempInd1 = data[ind2];
	int tempInd2 = data[ind1];
	data[ind1] = tempInd1;
	data[ind2] = tempInd2;
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
    System.out.println(part(ary,0,ary.length - 1));
  }

}
