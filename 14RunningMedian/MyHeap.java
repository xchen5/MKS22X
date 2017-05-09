import java.util.*;
public class MyHeap {
    private ArrayList<Integer> heap = new ArrayList<Integer>();
    private boolean isMax;

    public MyHeap(){
	heap.add(0);
	isMax = true;
    }

    public MyHeap(boolean x){
	heap.add(0);
	isMax = x;
    }

    public void add(Integer s){
	heap.add(s);
	pushUp(heap.size() - 1);
    }

    public Integer remove(){
      Integer ret = heap.get(1);
      heap.set(1, heap.remove(heap.size() - 1));
      pushDown(1);
      return ret;
    }

    public String toString(){
	String ret = "[";
	for(int i = 1; i < heap.size(); i++){
	    if(i == heap.size() - 1){
		ret += heap.get(i) + "";
	    }
	    else{
		ret += heap.get(i) + ", ";
	    }
	}
	return ret + "]";
    }

    private boolean hasParent(int index){
	return (index / 2) > 0;
    }

    private boolean hasChildren(int index) {
      return (index * 2) < heap.size();
    }

    private void swap(int ind1, int ind2){
	Integer firstval =  heap.get(ind1);
	Integer secondval = heap.get(ind2);
	heap.set(ind1, secondval);
	heap.set(ind2, firstval);
    }

    private void pushDown(int index){
      if (isMax == false){
      while(hasChildren(index)){
        if(heap.get(index).compareTo(heap.get(index * 2)) >  0){
          swap( index, index * 2);
          pushUp(index * 2);
        }
        else{
          return;
        }
      }
    }
    else{
      while(hasChildren(index)){
        if(heap.get(index).compareTo(heap.get(index * 2)) <  0){
          swap( index, index * 2);
          pushUp(index * 2);
        }
        else{
          return;
        }
      }
    }
  }

    private void pushUp(int index){
      if (isMax == false) {
      while(hasParent(index)){
        if(heap.get(index).compareTo(heap.get(index / 2)) < 0){
          swap( index, index / 2);
          pushUp(index / 2);
        }
        else{
          return;
        }
      }
    }
    else {
      while(hasParent(index)){
        if(heap.get(index).compareTo(heap.get(index / 2)) > 0){
          swap( index, index / 2);
          pushUp(index / 2);
        }
        else{
          return;
        }
      }
    }
  }

    public Integer peek(){
      return heap.get(1);
    }

    public int getSize(){
      return heap.size() - 1;
    }
    public static void main(String[]args){
	MyHeap a = new MyHeap(false);
  a.add(1);
	a.add(2);
	a.add(3);
  a.add(4);
  a.add(4);
  a.remove();
	System.out.println(a);
    }
}
