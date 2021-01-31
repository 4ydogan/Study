
public class Fibonacci {
	public static int fib(int index) {
		if(index == 1 || index == 2)
			return 1;
		return fib(index-1) + fib(index-2);
	}
	
	public static void main(String[] args) {
		System.out.println(fib(10));
	}
}
