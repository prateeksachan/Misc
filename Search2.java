import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Search2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i=0;i<101;i++) {
            a[i]=0;
        }
        for (int i=0;i<n;i++) {
            ++a[in.nextInt()];
        }
        for (int i=0;i<100;i++) {
            if (a[i]==1) {
                System.out.println(i);
                break;
            }
        }
    }
}