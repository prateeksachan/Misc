import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class largestSumContiguous {
    
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int N = Integer.parseInt(in.nextLine());
        int ar[] = new int[N];
        for (int i=0;i<N;i++) {
            ar[i] = Integer.parseInt(in.next());
        }
        System.out.println(compute_switch(ar));
    }

    public static int compute_switch(int ar[]) {
        int max_sum = ar[0];
        int curr = ar[0];
        for (int i=1;i<ar.length;i++) {
            curr = max(ar[i], curr+ar[i]);
            max_sum = max(max_sum, curr);
        }
        return max_sum;
    }

    public static int max(int a, int b) {
        return (a>b) ? a :b;
    }
}

