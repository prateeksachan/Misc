import java.io.*;
import java.util.*;
import java.math.*;

public class contest3 {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        String s = in.nextLine();
        String[] token = s.split(" ");
        long dum=0;
        int n = Integer.parseInt(token[0]);
        int m = Integer.parseInt(token[1]);
        int k = Integer.parseInt(token[2]);
        long c = 0;
        long c1 = comb(n+1, k); 
        long c2 = comb(m+1, k); 
        c+=(c1 + c2)*2;
        c+=(n-1)*(c2 - comb(m-1,k)) + (m-1)*(c1 - comb(n-1,k));
        //System.out.println(c);
        if (n>m)
            c+=(c2-comb(m-1,k))*(n-m+1)*2;
        else c+=(c1-comb(n-1,k))*(m-n+1)*2;
        if (n>m) {
            for (int i=k;i<m+1;i++) {
                c+=(comb(i, k) - comb(i-2, k))*4;
            }
        }
        else {
            for (int i=k;i<n+1;i++) {
                c+=(comb(i, k) - comb(i-2, k))*4;
            }
        }
        int cc=1;
        int j=2;
        while ((k-1)*j<=m) {
            for (int x=1;x<n;x++) {
                if (n%j==0)
                    c+=(comb(1+n/j, k) - comb(n/j-1, k))*2;
                if (x+n/j < m)
                    c+=(comb(1+n/j, k) - comb(n/j, k))*4;
                else if (x+n/j > m)
                    c+=(comb(1+n/j-cc, k) - comb(n/j-cc, k))*4;
                cc++;
            }
            j++;
        }
        //dum = c;
        //System.out.println(c);
        cc=1;
        j=2;
        while ((k-1)*j<=n) {
            for (int x=1;x<=m;x++) {
                if (m%j==0)
                    c+=(comb(1+m/j, k) - comb(m/j-1, k))*2;
                if (x+m/j < n)
                    c+=(comb(1+m/j, k) - comb(m/j, k))*4;
                else if (x+m/j > n)
                    c+=(comb(1+m/j-cc, k) - comb(m/j-cc, k))*4;
                cc++;
            }
            j++;
        }
        System.out.println(c);
        //horizontal & vertical borders
        
    }

    public static long comb(int n, int k) {
        if (n<k)
            return 0;
        else if (n==k)
            return 1;
        if (k>n/2)
            k=n-k;
        int i=1;
        long c=1;
        while (i<=k) {
            c*=n;
            c/=i;
            i++;
            n--;
        }
        return c;
    }
}
