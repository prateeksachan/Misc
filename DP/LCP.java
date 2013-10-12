import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LCP {
    
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        System.out.println(compute(s1, s2, s1.length()-1, s2.length()-1));
    }

    public static int compute(String s1, String s2, int m, int n) {
        if (m<0 || n<0)
            return 0;
        System.out.println(s1.substring(0, m+1)+"---"+s2.substring(0, n+1));
        if (s1.charAt(m) == s2.charAt(n))
            return 1+compute(s1, s2, m-1, n-1);
        else return max(compute(s1, s2, m, n-1), compute(s1, s2, m-1, n));
    }
    
    public static int max(int a, int b) {
        return (a>b) ? a : b;
    }
}
