import java.io.*;
import java.util.*;
import java.math.*;

class simpleText {
    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int size=s.length();
        double height = Math.ceil(Math.sqrt(size));
        double width = Math.floor(Math.sqrt(size));
        int ar[][]=new int [(int)width][(int)height];
        System.out.println(height+"---"+width);
        int x,y;
        x=y=0;
        int c=0;
        for (int i=0;i<width;i++) {
            for (int j=0;j<height;j++) {
                System.out.print(c+"  ");
                c++;
            } 
            System.out.println();
        }
	}
}