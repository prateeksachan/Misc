import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class sept1 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt();
        int e = in.nextInt();
        int ar[][] = new int[e][3];
        int count=0;
        for (int i=0;i<e;i++) {
            ar[i][0] = in.nextInt();
            if (ar[i][0]==1)
                count++;
            ar[i][1] = in.nextInt();
            ar[i][2] = in.nextInt();
        }
        long ans[]=new long[count];
        for (int i=0;i<count;i++) {
            ans[i] = compute(1, ar, n, e, 0);
        }
        for (int i=0;i<count;i++) {
            System.out.println(ans[i]);
        }//else System.out.println(a);
    }

    public static long compute(int curr, int ar[][], int m, int e, long max) {
        if (curr==m)
            return max;
        for (int i=0; i<e;i++) {
            if (ar[i][0]==curr) {
                if (curr==1) {
                    ar[i][0] = 0;
                    return compute(ar[i][1], ar, m, e, ar[i][2]);
                }
                else {
                    long temp = ar[i][2]-max;
                    if (temp>=0)
                        return compute(ar[i][1], ar, m, e, max+temp);
                    else return compute(ar[i][1], ar, m, e, max);
                }
            }
        }
        return 0;
    }

    public static long min(long a[]) {
        long min = a[0];
        for (int i=1; i<a.length;i++) {
            if (min>a[i])
                min=a[i];
        }
        return min;
    }
}
