import java.util.*;
public class MyHeap {
    private ArrayList<String> heap = new ArrayList<String>();
    private boolean isMax;

    public MyHeap(){
	heap.add("");
	isMax = true;
    }

    public MyHeap(boolean x){
	heap.add("");
	isMax = x;
    }

    public void add(String s){
	heap.add(s);
	pushUp(heap.size() - 1);
    }

    public void remove(){
      heap.set(1, heap.remove(heap.size() - 1));
      pushDown(1);
    }

    public String toString(){
	String ret = "[";
	for(int i = 1; i < heap.size(); i++){
	    if(i == heap.size() - 1){
		ret += heap.get(i);
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
	String firstval =  heap.get(ind1);
	String secondval = heap.get(ind2);
	heap.set(ind1, secondval);
	heap.set(ind2, firstval);
    }

    private void pushDown(int index){
      if (isMax == true){
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
      if (isMax == true) {
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

    public String peek(){
      return heap.get(1);
    }
    public static void main(String[]args){
	MyHeap a = new MyHeap(false);
  a.add("x");
	a.add("y");
	a.add("z");
  a.add("w");
  a.add("a");
  a.remove();
	System.out.println(a);
    }
}
