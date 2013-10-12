import java.io.*;
import java.util.*;
import java.math.*;

public class twitter {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a[] = new int[n];
        int b[] = new int[m];
        int c[] = new int[n];
        int x=Math.ceil(m/n);
        int y=0;
        int z=0;
        int d=0;
        for (int i=0;i<n;i++) {
            d=0;
            if (x+y+z>=n)
                break;
            for (int j=y;j<x+y+z;j++) {
                if (a[i]>=a[j]) {
                    d++;
                    ++c[i];
                    if (d==x) {
                        y=j+1;
                        break;
                    }
                }
                else {
                    y=j;
                    z=x-d;
                }
            }
        }
    }
}