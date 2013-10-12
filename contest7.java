import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class contest7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
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
    public static long compute(long a, long b) {
        long count=0;
        int ar[][] = new int [162][3];
        for (int i=0;i<162 ;i++) {
            ar[i][0] = 0;
        }
        for (long i=a;i<=b;i++) {
            int x = sumOf(i);
            if (ar[x-1][0]==1) {
                if (ar[x-1][2]==1) {
                    //System.out.println(i);
                    count++;
                }
            }
            else if (ar[x-1][0]==0) {
                if (isPrime(x)) {
                    System.out.println(i);
                    ar[x-1][0] = 1;
                    ar[x-1][1] = sumOfSq(i);
                    if (isPrime(ar[x-1][1])) {
                        ar[x-1][2] = 1;
                        System.out.println(i);
                        count++;
                    }
                    else ar[x-1][2] = -1;
                }
                else ar[x-1][0] = -1;
            }
        }
        return count;
    }

    public static int sumOf(long n) {
        int sum = 0;
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
        if (n==2 || n==3 || n==5 || n==7 || n==11)
            return true;
        if (n==1 || n%2==0 || n%3==0 || n%5==0 || n%7==0 || n%11==0)
            return false;
        List<Integer> list = new ArrayList<Integer>();
        list.add(0,2);
        for (int i=0; i<=n/2;i++) {
            if (n%list.get(i)==0)
                return false;
            else {
                list.add(list.size(),list.get(i)+1);
            }
        }
        return true;
    }
}
