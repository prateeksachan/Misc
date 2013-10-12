import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class hackAugust1 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int T = in.nextInt();
        int ar[][] = new int[T][2];
        String res[] = new String[T];
        for (int i=0;i<T;i++) {
            ar[i][0] = in.nextInt();
            ar[i][1] = in.nextInt();
            int arr[] = new int[ar[i][1]];
            for (int j=0;j<ar[i][1];j++) {
                arr[j] = in.nextInt();
            }
            res[i] = compute(ar[i][0], ar[i][1], arr);
        }
        for (int i=0;i<T;i++) {
            System.out.println(res[i]);
        }
    }

    public static String compute(int c, int l, int a[]) {
        HashMap<Integer, Integer> prices = new HashMap<Integer, Integer>();
        String s="";
        for (int i=0; i<l;i++) {
            if (prices.get(c-a[i]) !=null) {
                s+=prices.get(c-a[i])+" "+(i+1);        
                break;
            }
            if (prices.get(a[i])==null)
                prices.put(ar[i], i+1);
        }
        return s;
    }
}

