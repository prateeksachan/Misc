import java.io.*;
import java.util.*;

public class findHackerrank {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int N = Integer.parseInt(in.nextLine());
        String ar[]=new String[N];
        for (int i=0;i<N;i++) {
            ar[i]=in.nextLine();
        }
        for (int i=0;i<N;i++) {
            int size = ar[i].length();
            int count =0;
            if ((ar[i].substring(0,10)).equals("hackerrank")) {
                count=1;
                if (ar[i].substring(size-10,size).equals("hackerrank"))
                    count =0;
            }
            else if (ar[i].substring(size-10,size).equals("hackerrank"))
                count =2;
            else count =-1;
            System.out.println(count);
        }
    }
}
