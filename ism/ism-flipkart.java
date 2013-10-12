import java.io.*;
import java.util.*;
import java.math.*;

public class ism {

    public static void main(String[] args) throws IOException {
        ism obj = new ism();
        InputReader in=new InputReader(System.in);
        int a[] = new int[100];
        int c=0;
    }
    
    public String changeBase(int num, int base, String result) {
        if (num/base<1) {
            return result=(num%base)+result;
        }
        else {
            return changeBase(num/base, base, result=(num%base)+result);
        }
    }

    public boolean fnum (int n) {
        while (true) {
            if (getSum(n,0) == 1 ) {
                return true;
            }
            else if (getSum(n,0) < 10) {
                return false;
            }
            else return fnum(getSum(n,0));
        }
    }

    public int getSum(int n, int sum) {
        if (n==0) {
            return sum;
        }
        else {
            return getSum(n/10, sum+=(n%10)*(n%10));
        }
    }
}

class InputReader {

	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;

	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public String readString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuffer res = new StringBuffer();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}

	private boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
}
