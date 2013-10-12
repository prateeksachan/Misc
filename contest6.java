import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class contest6 {
    private static int[] prime;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    	prime = generatePrimes(1458);
        int T = in.nextInt();
    	long a[] = new long[T];
    	long b[] = new long[T];
    	for (int i=0;i<T;i++) {
    		a[i] = in.nextLong();
    		b[i] = in.nextLong();
    	}
    	for (int i=0;i<T;i++) {
    		System.out.println(compute(a[i], b[i]));
    	}
    }
    private static int[] generatePrimes(int max) {
        int [] temp = new int [max];
        temp [0] = 2;
        int index = 1;
        int prime = 1;
        boolean isPrime = false;
        while((prime += 2) <= max) {
            isPrime = true;
            for(int i = 0; i < index; i++) {
                if(prime % temp [i] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                temp [index++] = prime;
            }
        }
        return Arrays.copyOfRange(temp, 0, index);
    }

    public static long compute(long a, long b) {
    	long count=0;
    	for (long i=a;i<=b;i++) {
    		if (isPrime(sumOf(i)) == true) {
    			if (isPrime(sumOfSq(i)) == true) {
    				count++;
    			}
    		}
    	}
    	return count;
    }

    public static int sumOf(long n) {
    	int sum=0;
        while (n>0) {
    		sum+=n%10;
    		n/=10;
    	}
    	sum+=n;
    	return sum;
    }

    public static int sumOfSq(long n) {
    	int sum = 0;
    	long nn=n;
    	while (n>0) {
    		sum+=(n%10)*(n%10);
    		n/=10;
    	}
    	sum+=(n*n);
    	return sum;
    }

    public static boolean isPrime(int n) {
    	if (n==1)
            return false;
        for (int i=0;i<prime.length && prime[i]<n;i++) {
            if (n%prime[i]==0)
                return false;
        }
        return true;
    }
}
