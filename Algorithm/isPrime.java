/*
Check an integer to see whether it's a prime number
*/

public class isPrime{
	public static void main(String[] args){
        int n = 3;
        System.out.println(isPrime(n));
	}

    //rule out even number first, then check up to the square root
	public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        int sqrt = (int)Math.sqrt(n);
        for (int i = 3; i <= sqrt + 1; i = i + 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}