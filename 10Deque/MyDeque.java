import java.util.*;

public class MyDeque{
  private String[] deque;
  private int front;
  private int back;
  private int size;

  public MyDeque(){
    size = 0;
    back = 0;
    front = 0;
    deque = new String[10];
  }

  public void addLast(String s){
    if(s.equals(null)) {
      throw new NullPointerException();
    }
    if(isFull()){
      resize();
    }
    if(size == 0){
    }
    else if (back == deque.length - 1){
      back = 0;
    }
    else{
      back += 1;
    }
    deque[back] = s;
    size +=1;
  }

  public void addFirst(String s){
    if(s.equals(null)) {
      throw new NullPointerException();
    }
    if (isFull()) {
      resize();
    }
    if(size == 0){
    }
    else if (front == 0){
      front = deque.length - 1;
    }
    else{
      front -= 1;
    }
    deque[front] = s;
    size += 1;
  }

  private boolean isFull(){
    return (size == deque.length);
  }

  private void resize(){
    String[] temp = new String[deque.length * 2];
    for (int i = 0; i < size; i++){
        if (front == size){
        front = 0;
        }
        temp[i] = deque[front];
        front += 1;
    }
    front = 0;
    back = size - 1;
    deque = temp;
  }

  public String removeFirst(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    String retValue = deque[front];
    deque[front] = null;
    if (front == deque.length - 1) {
      front = 0;
    }
    else if(size == 1){
      front = 0;
    }
    else{
      front++;
    }
    size--;
    return retValue;
  }

  public String removeLast(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    String retValue = deque[back];
    deque[back] = null;
    if( back == 0) {
      back = deque.length - 1;
    }
    else if(size == 1){
      back = 0;
    }
    else{
      back --;
    }
    size --;
    return retValue;
  }

  public String getFirst(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return deque[front];
  }

  public String getLast(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return deque[back];
  }

  public static void main(String[]args){
    MyDeque a = new MyDeque();
    a.addLast("sadx");
    System.out.println(a.getLast());
    System.out.println(a.getFirst());
    System.out.println(Arrays.toString(a.deque));
    System.out.println(a.size);
    System.out.println("This is the front " + a.front + " " + a.deque[a.front]);
    System.out.println("This is the back " + a.back + " " + a.deque[a.back]);
  }

}