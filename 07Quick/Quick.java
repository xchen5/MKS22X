public class Quick {
    public static int part ( int [] data, int start, int end){
    //-Choose a random element to be a pivot, and partition the array around it. 
    //-Only partition the elements from start to end inclusive.
    //-When done returns the index of the final position of the pivot element.      
    //    (Should be from start to end inclusive)

	int pivot = Math.random * data.length;
	
	System.out.println(data[pivot]);

	if (start == end) {
	    return start;
	}

	for(int i = start; i < end; i++){
	    
	}
    }

    public static void main(String[]args){
	int[]ary={999,999,999,4,1,0,3,2,999,999,999}
	System.out.println(part(ary,0,ary.length));
    }

}
