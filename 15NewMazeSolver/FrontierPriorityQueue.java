public class FrontierPriorityQueue implements Frontier{
    private MyHeap qu = new MyHeap(); 
    
    public FrontierPriorityQueue(){
    }

    public void add(Location a){
	qu.add(a);
    }

    public Location next(){
	return qu.remove();
    }

}
