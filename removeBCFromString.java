import java.io.*;
import java.util.*;
import java.math.*;

public class removeBCFromString {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        String ss = in.next();
        StringBuilder s = new StringBuilder(ss);
        int size = s.length();
        for (int i=0;i<size;i++) {
            if (s.charAt(i)=='b') {
                s.setCharAt(i, '\0');
                //size--;
            }
            else if (s.charAt(i)=='a' && i+1<size && s.charAt(i+1)=='c' ) {
                s.setCharAt(i, '\0');
                s.setCharAt(i+1, '\0');
                //size=size-2;
            }
        }
        System.out.println(s);
    }
}
