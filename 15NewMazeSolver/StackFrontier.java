import java.util.*;
public class StackFrontier implements Frontier{
    Stack<Location> stacc = new Stack<Location>();

    public StackFrontier(){

    }

    public void add(Location a){
	stacc.add(a);
    }

    public Location next(){
	return stacc.pop();
    }
}
