import java.io.*;
import java.util.*;
import java.text.*;
class testnew {
	public static void main (String[] args) {
		long y= 572942897;
		long z= 431242628;
		double result=y+z;
		System.out.println(new DecimalFormat("#.#####").format(result/2)); 
	}
}