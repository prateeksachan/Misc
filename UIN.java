import java.io.*;
import java.util.*;
class UIN {
    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        UIN obj = new UIN();
        int N=Integer.parseInt(in.nextLine());
        String ar[]= new String[N];
        int result[]= new int[N];
        for (int i=0;i<N;i++) {
            ar[i]=in.nextLine();
            result[i]=0;
        }
        for (int i=0;i<N;i++) {
            if (ar[i].length()>5) {
                int c1[] = obj.check1(ar[i].substring(0,3));
                if (c1[0]==1) {
                    String w = ar[i].substring(c1[1],ar[i].length());
                    int c2[] = obj.check2(w);
                    if (c2[0]==1) {
                        int c3 = obj.check3(w.substring(c2[1],w.length()));
                        if (c3==1)
                            result[i]=1;
                    }
                }
            }
        }
        for (int i=0;i<N;i++) {
            if (result[i]==1)
                System.out.println("VALID");
            else System.out.println("INVALID");
        }
	}
    public int[] check1 (String word) {
        int result[]=new int[2];
        initialize(result);
        int flag=0;
        for (int i=0;i<3;i++) {
            if (((int)word.charAt(i)<97 || (int)word.charAt(i)>122) && ((int)word.charAt(i)<48 || (int)word.charAt(i)>57)) {
                flag=1;
                if (result[1]==0)
                    return result;
                else break;
            }
            else if ((int)word.charAt(i)>=48 && (int)word.charAt(i)<=57) {
                result[0]=1;
                result[1]=i;
                return result;
            }
            else if ((int)word.charAt(i)>=97 && (int)word.charAt(i)<=122) {
                result[1]++;
            }
        }
        if (result[1]==3)
            result[0]=1;
        else if (flag==1) {
            if (result[1]>=0 && result[1]<4)
                result[0]=1;
        }
        return result;
    }
    
    public void initialize(int[] result) {
        for (int i=0;i<2;i++)
            result[i]=0;
    }
    public int[] check2 (String word) {
        int result[]=new int[2];
        initialize(result);
        int flag=0;
        int size = word.length();
        if (size>=8)
            size=8;
        for (int i=0;i<size;i++) {
            if ((int)word.charAt(i)<48 || (int)word.charAt(i)>57) {
                flag=1;
                break;
            }
            else result[1]++;
        }
        if (flag==1) {
            if (result[1]>=2 && result[1]<=8)
                result[0]=1;
            else result[0]=0;
        }
        result[0]=1;
        return result;
    }

    public static int check3 (String word) {
        int result=0;
        for (int i=0;i<word.length();i++) {
            if ((int)word.charAt(i)>=65 && (int)word.charAt(i)<=90)
                result++;
            else break;
        }
        if (result>=3)
            return 1;
        else return 0;
    }
}
