import java.io.*;
import java.util.*;
class Codechef1 {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader (System.in);
        Scanner inn = new Scanner (System.in);
        int T = in.readInt();
        int res[] = new int[T];
        for (int i=0;i<T;i++) {
            int r = in.readInt();
            String ar[] = new String[r];
            int c = in.readInt();
            for (int j=0;j<r;j++) {
                ar[j] = inn.nextLine();
            }
            if (r<5 || c<5) {
                res[i]=0;
            } else {
                res[i]=compute(r, c, ar);
            }
        }
        for (int i=0;i<T;i++) {
            System.out.println(res[i]);
        }
    }
    public static int compute (int r, int c, String ar[]) {
        int res=0;
        for (int i=2; i<r-2; i++) {
            for (int j=2; j<c-2;j++) {
                int p[]=new int[4];
                for (int k=i-1; k>=0;k--) {
                    if (ar[k].charAt(j)=='^') {
                        p[0]++;
                    } else break;
                }
                for (int k=i+1; k<r;k++) {
                    if (ar[k].charAt(j)=='^') {
                        p[1]++;
                    } else break;
                }
                for (int k=j-1; k>=0;k--) {
                    if (ar[i].charAt(k)=='^') {
                        p[2]++;
                    } else break;
                }
                for (int k=j+1; k<c;k++) {
                    if (ar[i].charAt(k)=='^') {
                        p[3]++;
                    } else break;
                }
                for (int k=0;k<4;k++) {
                    if (p[k]<2) {
                        break;
                    } else if (k==3) { 
                        res++;
                    }
                }
            }
        }
        return res;
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

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}
