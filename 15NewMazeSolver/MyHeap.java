import java.util.*;
public class MyHeap {
  private ArrayList<Location> heap = new ArrayList<Location>();
  private boolean isMax;

  public MyHeap(){
    Location a = new Location();
    heap.add(a);
    isMax = true;
  }

  public MyHeap(boolean x){
      Location a = new Location();
      heap.add(a);
    isMax = x;
  }

  public void add(Location s){
    heap.add(s);
    pushUp(heap.size() - 1);
  }

  public Location remove(){
    Location ret = heap.get(1);
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

  private boolean hasTwoChildren(int index){
    return (index * 2) + 1< heap.size();
  }

  private Location getRight(int index){
    return heap.get((index * 2) + 1);
  }

  private Location getLeft(int index){
    return heap.get(index * 2);
  }

  private void swap(int ind1, int ind2){
    Location firstval =  heap.get(ind1);
    Location secondval = heap.get(ind2);
    heap.set(ind1, secondval);
    heap.set(ind2, firstval);
  }

  private void pushDown(int index){
    if (!isMax){
      if(hasTwoChildren(index)){
        if((heap.get(index).compareTo(getLeft(index)) > 0) && (heap.get(index).compareTo(getRight(index)) > 0)){
          if(getLeft(index).compareTo(getRight(index)) < 0){
            swap(index, index * 2);
            pushDown(index * 2);
          }
          else {
            swap(index, (index * 2) + 1);
            pushDown((index * 2) + 1);
          }
        }
        else if(heap.get(index).compareTo(getLeft(index)) > 0){
          swap(index, (index * 2));
          pushDown(index * 2);
        }
        else if(heap.get(index).compareTo(getRight(index)) > 0){
          swap(index, (index * 2) + 1);
          pushDown((index * 2) + 1);
        }
      }
      else if (hasChildren(index)){
        if(heap.get(index).compareTo(getLeft(index)) > 0){
          swap(index, index * 2);
          pushDown(index * 2);
        }
      }
    }
    else{
      if(hasTwoChildren(index)){
        if((heap.get(index).compareTo(getLeft(index)) < 0) && (heap.get(index).compareTo(getRight(index)) < 0)){
          if(getLeft(index).compareTo(getRight(index)) > 0){
            swap(index, index * 2);
            pushDown(index * 2);
          }
          else {
            swap(index, (index * 2) + 1);
            pushDown((index * 2) + 1);
          }
        }
        else if(heap.get(index).compareTo(getLeft(index)) < 0){
          swap(index, (index * 2));
          pushDown(index * 2);
        }
        else if(heap.get(index).compareTo(getRight(index)) < 0){
          swap(index, (index * 2) + 1);
          pushDown((index * 2) + 1);
        }
      }
      else if (hasChildren(index)){
        if(heap.get(index).compareTo(getLeft(index)) < 0){
          swap(index, index * 2);
          pushDown(index * 2);
        }
      }
    }
  }

  private void pushUp(int index){
    if (!isMax) {
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

  public Location peek(){
    return heap.get(1);
  }

  public int getSize(){
    return heap.size() - 1;
  }
}
