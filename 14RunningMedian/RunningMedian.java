public class RunningMedian{
  MyHeap minHeap;
  MyHeap maxHeap;

  public RunningMedian(){
    minHeap = new MyHeap(false);
    maxHeap = new MyHeap(true);
  }

  public void add(int x){
    if(maxHeap.getSize() == 0 && minHeap.getSize() == 0){
      maxHeap.add(x);
    }
    else if(x < maxHeap.peek()){
      maxHeap.add(x);
      adjustHeap();
    }
    else {
      minHeap.add(x);
      adjustHeap();
    }
  }

  private void adjustHeap() {
    if(maxHeap.getSize() > minHeap.getSize() + 1 ){
      minHeap.add(maxHeap.remove());
    }
    else if (minHeap.getSize() > maxHeap.getSize() + 1) {
      maxHeap.add(minHeap.remove());
    }
    else{
      return;
    }
  }

  public double getMedian(){
    if(maxHeap.getSize() == minHeap.getSize()) {
      return ((maxHeap.peek() + minHeap.peek()) / 2.0);
    }
    else if(maxHeap.getSize() > minHeap.getSize()) {
      return maxHeap.peek();
    }
    else{
      return minHeap.peek();
    }
  }

    public static void main(String[] args) {
    RunningMedian a = new RunningMedian();
    a.add(1);
    a.add(2);
    a.add(3);
    a.add(4);
    a.add(5);
    //a.add(6);
    System.out.println(a.getMedian());
    }
}