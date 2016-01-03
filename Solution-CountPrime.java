/**
 * Problem Statement: https://leetcode.com/problems/count-primes/
 * 
 * @author PawanMahalle
 *
 */
 
public class Solution {
    public int countPrimes(int n) {
        boolean composite[] = new boolean[n];
        if(n == 0)   return 0;
        if(n == 1)   return 0;
        if(n == 2)   return 0;
        
        int primeCount = n-2;
        for(int i = 2; i < (Math.sqrt(n)+1);i++){
            for(int k = i+i; k < n; k = k + i){
                if(composite[k] == false){
                    primeCount--;
                }
                composite[k] = true;
            }
        }
        return primeCount;
    }
}