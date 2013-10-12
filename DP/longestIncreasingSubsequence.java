import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class longestIncreasingSubsequence {
    
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
        int tail[] = new int[ar.length];
        tail[0] = ar[0];
        int len = 1;
        for (int i=1;i<ar.length;i++) {
            if (ar[i]<tail[0])
                tail[0] = ar[i];
            else if (ar[i]>tail[len-1])
                tail[len++] = ar[i];
            else
                tail[ceil(tail, -1, len-1, ar[i])] = ar[i];
        }
        return len;
    }

    public static int ceil(int ar[], int l, int r, int k) {
        while (r-l>1) {
            int m = l + (r-l)/2;
            if (ar[m]>=k)
                r=m;
            else l=m;
            //((ar[m]>=k) ? r : l) = m;
        }
        return r;
    } 
}
