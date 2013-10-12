import java.io.*;
import java.util.*;
import java.math.*;

class Encryption {
    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int size=s.length();
        System.out.println(size);
        double height = Math.ceil(Math.sqrt(size));
        double width = Math.floor(Math.sqrt(size));
        if (height*width<size)
            width++;
        int ar[][]=new int [(int)width][(int)height];
        int x,y;
        x=y=0;
        for (int i=0;i<size;i++) {
            ar[x][y]=s.charAt(i);
            y++;
            if ((y)%height==0) {
                x++;
                y=0;
            }
        }
        for (int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                System.out.print((char)ar[j][i]);
            }
            System.out.print(" ");
        }
        System.out.println();
	}
}