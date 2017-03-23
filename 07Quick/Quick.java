import java.util.*;
public class Quick {
  //-Choose a random element to be a pivot, and partition the array around it.
  //-Only partition the elements from start to end inclusive.
  //-When done returns the index of the final position of the pivot element.
  //    (Should be from start to end inclusive)

public static int part(int[]data,int start, int end){
  int lt = start;
  int gt = end;
  int i = start;
  int pivot = (int) (Math.random() * (end - start)) + start ;
  int pivotValue = data[pivot];
  //System.out.println(Arrays.toString(data));
  //System.out.println(pivotValue);
  swap(data, pivot, start);
  //System.out.println(Arrays.toString(data));
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
  //System.out.println(Arrays.toString(data));
  return lt;

}

public static void swap(int[]data, int ind1, int ind2){
  int tempInd1 = data[ind2];
  int tempInd2 = data[ind1];
  data[ind1] = tempInd1;
  data[ind2] = tempInd2;
}

public static int quickselect(int[]data, int k){
  return quickSelectHelper(data,k,0,data.length-1);
}

public static int quickSelectHelper(int[]data, int k, int start, int end){
  int pivot = part(data,start,end);
  if(pivot > k){
    return quickSelectHelper(data,k,start, pivot);
  }
  if(pivot < k) {
    return quickSelectHelper(data,k, pivot, end);
  }
  return data[pivot];
}

public static void quickSortHelper(int[]data, int start, int end){
  if (start < end) {
    int pivot = part(data,start,end);
    quickSortHelper(data, pivot + 1, end);
    quickSortHelper(data, start, pivot - 1);
  }
}

public static void quicksort(int[]data) {
  quickSortHelper(data,0,data.length-1);
  //System.out.println(Arrays.toString(data));
}
public static void main(String[]args){
  //int[]ary={4,3,2,1,5,0,2,4,5,7};
  //quicksort(ary);
}

}
