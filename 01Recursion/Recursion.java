public class Recursion{
 public static String name(){
   return "Chen, Xavier";
 };
 public static double sqrt(double n){
    if (n == 0) return 0;
    else return sqrtHelper(n, 50);
   }

 private static boolean isClose(double x, double y) {
   return (Math.abs(x - y) < Math.pow(10.0, -12));
 }
 private static double sqrtHelper(double n, double guess) {
   if (n < 0) {
     throw new IllegalArgumentException();
   }
    if (isClose(guess * guess, n) == true) {
      return guess;
    }
    else {
      return sqrtHelper(n, ((n/guess + guess) / 2));
    }
 }
 public static void main(String[] args) {
    System.out.println(sqrt(0));
 }
}