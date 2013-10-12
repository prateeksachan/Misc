import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class stringsPermutations {
    
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        String s1 = in.nextLine();
        System.out.println(compute(s1));
    }

    public static int compute(String s) {
        List<String> list = new ArrayList<String>();
        for (int i=0; i<s.length();i++) {
            list.add(s.substring(i));
        }
        Collections.sort(list);
        int count = (list.get(0)).length();
        for (int i=0; i<s.length()-1;i++) {
            int l1=(list.get(i)).length()-1;
            int l2=(list.get(i+1)).length()-1;
            int temp = LCP(list.get(i), list.get(i+1), 0, 0);
            count+=(list.get(i+1)).length() - temp;
        }
        return count;
    }

    public static int LCP(String s1, String s2, int m, int n) {
        if (m>=s1.length() || n>=s2.length())
            return 0;
        //System.out.println(s1.substring(0, m+1)+"---"+s2.substring(0, n+1));
        else if (s1.charAt(m) == s2.charAt(n))
            return 1+LCP(s1, s2, m+1, n+1);
        else return 0;
    }
    
    public static int max(int a, int b) {
        return (a>b) ? a : b;
    }
}

