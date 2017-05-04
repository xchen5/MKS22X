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

    public static void main(String[]args){
	MyHeap a = new MyHeap();
	a.add("hi");
	a.add("x");
	System.out.println(a);
    }
}
