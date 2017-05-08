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
	pushUp();
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

    private void swap(int ind1, int ind2){
	String firstval =  heap.get(ind1);
	String secondval = heap.get(ind2);
	heap.set(ind1, secondval);
	heap.set(ind2, firstval);
    }

    private void pushUp(){
	if(heap.get(heap.size()-1).compareTo(heap.get((heap.size()-1) / 2)) < 0 ){
	    swap( heap.size()-1 , (heap.size()-1)/2);
	}
    }
    public static void main(String[]args){
	MyHeap a = new MyHeap();
	a.add("x");
	a.add("hi");
	a.add("bye");
	System.out.println(a);
    }
}
