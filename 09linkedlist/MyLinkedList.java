public class MyLinkedList{
  private LNode start;
  private int size;

  public MyLinkedList(){
    start = new LNode();
  }
  public class LNode{
    private int value;
    private LNode next;

    public LNode(){

    }

    public LNode(int val){
      value = val;
      next = null;
    }
    public LNode(int val, LNode nextNode){
      value = val;
      next = nextNode;
    }
  }


  public boolean add(int value){
    LNode current = start;
    LNode x = new LNode(value);
    if (size == 0) {
      start = x;
      size += 1;
    }
    else{
    for(int i = 0; i < size - 1; i++){
      //System.out.println(current.value);
      current = current.next;
    }
    current.next = x;
    size += 1;
  }
    return true;
  }



  public int get(int index){
    if(index < 0 || index >= size()){
      throw new IndexOutOfBoundsException();
    }
    LNode current = start;
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
    LNode current = start;
    for(int i = 0; i < index; i++) {
      current = current.next;
    }
    int old = current.value;
    current.value = newValue;
    return old;
  }

  public int indexOf(int value){
    LNode current = start;
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

  public int remove(int index) {
    if ( index < 0 || index >= size()){
      throw new IndexOutOfBoundsException();
    }
    LNode current = start;
    for(int i = 0; i < index - 1; i++) {
      current = current.next;
    }
    int old = current.next.value;
    LNode afterRemoval = current.next.next;
    current.next = afterRemoval;
    size -= 1;
    return old;
  }

  public void add(int index, int value){
    if(index < 0 || index > size()){
      throw new IndexOutOfBoundsException();
    }
    LNode current = start;
    LNode x = new LNode(value);
    for(int i = 0; i < index - 1; i++) {
      current = current.next;
    }
    LNode temp = current.next;
    current.next = x;
    current.next.next = temp;
    size += 1;
  }

  public String toString(){
    String retValue = "[ ";
    LNode current = start;
    retValue += current.value;
    current = current.next;
    for(int i = 1; i < size(); i++){
        retValue += ", " + current.value;
        current = current.next;
    }
    return retValue + "]";
  }

  public static void main(String[]args){
    MyLinkedList a = new MyLinkedList();
    a.add(0);
    a.add(1);
    a.add(2);
    a.add(3);
    a.add(5);
    a.add(6);
    a.add(7);
    System.out.println(a.toString());
    //System.out.println(a.get(2));
    //System.out.println(a.remove(3));
    System.out.println(a.toString());

  }
}
