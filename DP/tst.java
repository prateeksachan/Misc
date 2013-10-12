import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class tst {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int ans[] = {34, 56, 23, 67, 18, 89};
        int a = min(ans);
        if (a==0)
            System.out.println("NO PATH EXISTS");
        else System.out.println(a);
    }

    public static int min(int a[]) {
        int min = a[0];
        for (int i=1; i<a.length;i++) {
            if (min>a[i])
                min=a[i];
        }
        return min;
    }
}
