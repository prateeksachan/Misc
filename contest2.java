import java.io.*;
import java.util.*;

public class contest2 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int T = Integer.parseInt(in.nextLine());
        long N[] = new long[T];
        int K[] = new int[T];
        for (int i=0;i<T;i++) {
            String s = in.nextLine();
            String[] token = s.split(" ");
            N[i] = Long.parseLong(token[0]);
            K[i] = Integer.parseInt(token[1]);
        }
        for (int i=0;i<T;i++) {
            long c[] = new long[K[i]];
            if (N[i]<=K[i]) {
                for (int j=1;j<=N[i];j++) {
                    ++c[(int)j%K[i]];
                }
            } else {
                long x = N[i]/K[i];
                long y = N[i]%K[i];
                for (int j=0;j<K[i];j++) {
                    c[j]=x;
                }
                for (int j=1;j<=y;j++) {
                    ++c[j];
                }
            }
            long count = 0; 
            if (K[i]%2==0)
                count = (c[0]*(c[0]-1) + c[K[i]/2]*(c[K[i]/2]-1))/2;
            else
                count = c[0]*(c[0]-1)/2;
            for (int j=1;j<(K[i]+1)/2;j++) {
                count+=c[j]*c[K[i]-j];
            }
            System.out.println(count);
        }
    }
}
