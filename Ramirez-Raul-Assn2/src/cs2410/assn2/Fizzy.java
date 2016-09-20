package cs2410.assn2;

/**
 * @author Raul Ramirez
 * @version 1.0
 *
 */

/**
 *
 */
public class Fizzy {

	/**
	 *
	 * @param val boolean takes a val to check if it is divisible by 3.
	 * @return true if it is divisible by 3, false if it is not.
	 */
    private static boolean isFizz(int val){
	if(val%3 == 0){
	    return true;
	}
	return false;
    }

	/**
	 *
	 * @param val boolean takes a val to check if it is divisible by 5.
	 * @return true if it is divisible by 5, false if it is not.
	 */
	private static boolean isBuzz(int val){
	if(val%5 == 0){
	    return true;
	}
	return false;
    }

	/**
	 * an integer counter to count from 1 to 100
	 */
	private static int counter;

    public static void main(String[] args){

		/**
		 * For loop to iterate counter from 1 to 100.
		 */
		for(counter = 1; counter <= 100; ++counter) {
			/**
			 * an if else nested block, will check if counter is divisble by 3, 5, and 3 and 5. Will print out the rest of the numbers if it does not see the numbers are divisible.
			 */
			if (isFizz(counter) == true && isBuzz(counter) == true) {
				System.out.println("FizzBuzz");
			} else if (isFizz(counter) == true) {
				System.out.println("Fizz");
			} else if (isBuzz(counter) == true) {
				System.out.println("Buzz");
			} else {
				System.out.println(counter);
			}
		}
    }
    
}
