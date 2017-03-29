public class MyLinkedList{
    private LNode start;
    private int size;

    public class LNode{
	private int value;
	private LNode next;

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
	start = LNode(value, start);
	size += 1;
	return true;
    }
    
    public String toString(){
	String retValue = "";
	for(int i = 0; i < size; i++){
	    
	}
    }

}
