import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class longestSubstring {
    
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        String s = in.nextLine();
        System.out.println(compute_switch(s));
    }

    public static int compute_switch(String s) {
        boolean temp[] = new boolean[26];
        for (int i=0;i<26;i++) {
            temp[i] = false;
        }
        int max_till = 0;
        int len = 0;
        for (int i=0;i<s.length();i++) {
            if (temp[(int)s.charAt(i) - 65] == false) {
                temp[(int)s.charAt(i) - 65] = true;
                len++;
            } else {
                max_till = max(max_till, len); 
            }
        }
        return max_till;
    }

    public static int max(int a, int b) {
        return (a>b) ? a :b;
    }
}
