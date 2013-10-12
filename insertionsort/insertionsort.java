import java.io.*;
import java.util.*;
class Node {
    private Node leftchild;
    private Node rightchild;
    private int value;
    public Node(int value) {
        this.leftchild = null;
        this.rightchild = null;
        this.value = value;
    }
}
class Tree {
    private Node root;
    public Tree() {
        root = null;
    }
    public insert(int value) {
        if (value <= root.value) {
            if (root.left != null) {
                insert(root.left, value);
            } else {
                root.left = new Node(value);
            }
        } else if (value > root.value) {
            if (root.right != null) {
                insert(root.right, value);
            } else {
                root.right = new Node(value);
            }
        }
    }    
}

public class insertionsort {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader (System.in);
        int T = in.readInt();
        int result[] = new int[T];
        for (int i=0;i<T;i++) {
            int n = in.readInt();
            int[] ar = new int[n];
            for(int j=0;j<n;j++){
                ar[j]=in.readInt(); 
            }
            result[i] = compute(ar);
        }

        for (int i=0;i<T;i++) {
            System.out.println(result[i]);
        }    
    }

    public static int compute (int[] ar) {
        int t=0;
        for (int i=1; i<ar.length; i++) {
            for (int k=i; k>=1 && ar[k]<ar[k-1]; k--) {
                ar[k] -= ar[k-1];
                ar[k-1] += ar[k];
                ar[k] = (ar[k-1] - ar[k]);
                t++;
            }
        }
        return t;
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
