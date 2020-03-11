package problems.math;

public class CountingPrimes {
	/**
	 * @problem LeetCode Counting Primes
	 * @param n
	 * @return
	 */
	// solution one
	private static int countingPrimes(int n) {
		int count = 0;
		boolean[] notPrime = new boolean[n];
		// set all the numbers from 2 to n to be prime numbers.
		for(int i=2; i<n; i++) {
			if(notPrime[i] == false) {
				count++;
				for(int j=2; j*i<n; j++) 
					notPrime[j*i] = true; 
				//problem: it repeatedly computes some values
			}
			
		}
		return count; 
	}
	// solution two
	public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for(int i=2; i<n; i++) isPrime[i] = true;
        
        for(int i=2; i*i<n; i++){ // i<sqrt(n)
            if(!isPrime[i]) continue;
            for(int j=i*i; j<n; j+=i){
                isPrime[j] = false;
            }
        }
        int count = 0;
        for(int i=2; i<n; i++){
            if(isPrime[i]) count++;
        }
        
        return count;
    }
	
	public static void main(String[] args) {
		int n = 499979;//4153
		int ans = countingPrimes(n);
		System.out.println(ans);
		System.out.println(countPrimes(n));
	}
}
