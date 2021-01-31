public class Factorial {
	public static int factorial(int number) {		
		if(number == 1)  // base case
			return 1;		
		return number * factorial(number-1);
	}
}
