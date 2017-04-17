import java.util.*;
public class MyLinkedList implements Iterable<Integer>{
  private LNode head;
  private LNode tail;
  private int size;


  public MyLinkedList(){
    head = new LNode();
  }

  public Iterator<Integer> iterator(){
    return new MLLI(this);
  }

  public class MLLI implements Iterator<Integer>{
    private MyLinkedList MLL;
    private int element;

    public MLLI(MyLinkedList mll) {
      MLL = mll;
      element = 0;
    }
    public boolean hasNext(){
      return MLL.size > element;
    }

    public Integer next(){
      if (hasNext()){
        element += 1;
        return MLL.get(element - 1);
      }
      else {
        throw new NoSuchElementException();
      }
    }

    public void remove(){
      throw new UnsupportedOperationException();
    }
  }
  public class LNode{
    private LNode prev;
    private int value;
    private LNode next;

    public LNode(){

    }

    public LNode(int val){
      prev = null;
      value = val;
      next = null;
    }
    public LNode(int val, LNode prevNode, LNode nextNode){
      prev = prevNode;
      value = val;
      next = nextNode;
    }
    /*public String toString(){
    if (prev.value == null) {
    return "null " + value + " " +  next.value;
  }
  else if (next.value == null) {
  return "" + prev.value + " " + value + " null";
}
else{
return "" + (prev.value) + " "+ (value) + " " + (next.value);
}
}*/
}


public boolean add(int value){
  LNode x = new LNode(value);
  if (size == 0) {
    head = x;
    tail = x;
    size += 1;
  }
  else{
    x.prev = tail;
    tail.next = x;
    tail = x;
    size += 1;
  }
  return true;
}



public int get(int index){
  if(index < 0 || index >= size()){
    throw new IndexOutOfBoundsException();
  }
  LNode current = head;
  for(int i = 0; i < index; i++){
    current = current.next;
  }
  return current.value;
}

public int size(){
  return size;
}

public int set(int index, int newValue){
  if (index < 0 || index >= size()){
    throw new IndexOutOfBoundsException();
  }
  LNode current = head;
  for(int i = 0; i < index; i++) {
    current = current.next;
  }
  int old = current.value;
  current.value = newValue;
  return old;
}

public int indexOf(int value){
  LNode current = head;
  int i = 0;
  while((i < size - 1) && !(current.value == value) ){
    current = current.next;
    i += 1;
  }
  if (current.value == value){
    return i;
  }
  else {
    return -1;
  }
}

/*public int remove(int index) {
if ( index < 0 || index >= size()){
throw new IndexOutOfBoundsException();
}
LNode current = head;
for(int i = 0; i < index - 1; i++) {
current = current.next;
}
int old = current.next.value;
LNode afterRemoval = current.next.next;
current.next = afterRemoval;
size -= 1;
return old;
}*/

private void remove(LNode x){
  if( x.next == null && x.prev == null){
    x = null;
    head = null;
    tail = null;
  }
  else if( x.prev == null){
    x.next.prev = null;
    head = x.next;
  }
  else if(x.next == null){
    x.prev.next = null;
    tail = x.prev;
  }
  else{
    x.prev.next = x.next;
    x.next.prev = x.prev;

  }
  size -= 1;
}

public int remove(int index){
  if (index < 0 || index >= size()){
    throw new IndexOutOfBoundsException();
  }
  int ret = get(index);
  LNode x = getNode(index);
  remove(x);
  return ret;
}

/*public void add(int index, int value){
if(index < 0 || index > size()){
throw new IndexOutOfBoundsException();
}
LNode current = head;
LNode x = new LNode(value);
for(int i = 0; i < index - 1; i++) {
current = current.next;
}
LNode temp = current.next;
current.next = x;
current.next.next = temp;
size += 1;
}*/

private LNode getNode(int index){
  LNode current = head;
  int i = 0;
  while(i < index ){
    current = current.next;
    i += 1;
  }
  return current;
}


/*private void insertAfter(LNode toBeAdded, LNode location){
  toBeAdded.next = location.next;
  location.next.prev = toBeAdded;
  toBeAdded.prev = location;
  location.next=toBeAdded;
}*/

private void insertBefore(LNode toBeAdded, LNode location){
  toBeAdded.next = location;
  location.prev.next = toBeAdded;
  toBeAdded.prev = location.prev;
  location.prev = toBeAdded;
}

private void add(int index, int value){
  if(index < 0 || index > size()){
    throw new IndexOutOfBoundsException();
  }
  if (index == size()){
    add(value);
  }
  else if(index == 0){
    LNode x= new LNode(value);
    head.prev = x;
    x.next = head;
    head = x;
    size += 1;
  }
  else{
    LNode x = new LNode(value);
    LNode location = getNode(index);
    insertBefore(x, location);
    size +=1;
  }
}

public String toString(){
  if (size == 0) {
    return "[]";
  }
  else {
    String retValue = "[ ";
    LNode current = head;
    retValue += current.value;
    current = current.next;
    for(int i = 1; i < size(); i++){
      retValue += ", " + current.value;
      current = current.next;
    }
    return retValue + "]"; //+ "\nthe head value is " + head.value + " and the tail value is " + tail.value;
  }
}

public static void main(String[]args){
  MyLinkedList a = new MyLinkedList();
  a.add(0, 20);
  a.add(1);
  a.add(2);
  a.add(3);
  a.add(4);
  a.add(5);
  a.add(6);
  a.add(7);
  //a.remove(a.size() - 1);
  //System.out.println(a.getNode(0));
  //System.out.println(x);
  //System.out.println(a.toString());
  //System.out.println(a.get(2));
  //System.out.println(a.remove(3));
  System.out.println("this is the size " + a.size());
  System.out.println(a.toString());
  Iterator x = a.iterator();
  while(x.hasNext()) {
    System.out.println(x.next());
  }
}
}
