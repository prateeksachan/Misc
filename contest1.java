import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class contest1 {
	
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int T = Integer.parseInt(in.nextLine());
        int N[] = new int[T];
        for (int i=0;i<T;i++) {
            N[i] = Integer.parseInt(in.nextLine());
        }
        for (int i=0;i<T;i++) {
        	System.out.println(compute_switch(N[i]));
        }
    }

    public static String compute_switch(int n) {
    	switch(n) {
    		case 1: return "-1";
    		case 2: return "-1";
    		case 3: return "555";
    		case 4: return "-1";
    		case 5: return "33333";
    		case 7: return "-1";
    		case 10: return "3333333333";
    		default: return compute(n);
    	}
    }

    public static String compute(int n) {
    	String s="";
    	if (n==3) {
    		s = "555";
    	}
    	else if (n==5) {
    		s = "33333";
    	}
    	else if (n%3==0) {
    		s = new String(new char[n/3]).replace("\0", "555");
    	}
    	else if (n%3==1) {
    		s = new String(new char[(n-10)/3]).replace("\0", "555")+"3333333333";
    	}
    	else if (n%3==2) {
    		s = new String(new char[(n-5)/3]).replace("\0", "555")+"33333";
    	}
    	else s = "-1";
    	return s;
    }
}

