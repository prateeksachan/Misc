import java.io.*;
import java.util.*;
class Node {
    public Node leftchild;
    public Node rightchild;
    public int value;
    public int count;
    public Node(int keyvalue) {
        leftchild = null;
        rightchild = null;
        value = keyvalue;
        count = 1;
    }
}
class Tree {
    private Node root;
    public Tree() {
        root = new Node(0);
    }
    public void insertNode(Node root, int value) {
        if (value <= root.value) {
            if (root.leftchild != null) {
                root.count++;
                insertNode(root.leftchild, value);
            } else {
                root.leftchild = new Node(value);
                root.count++;
            }
        } else if (value > root.value) {
            if (root.rightchild != null) {
                root.count++;
                insertNode(root.rightchild, value);
            } else {
                root.rightchild = new Node(value);
                root.count++;
            }
        }
    }

    public int getRank(Node root, int value) {
        if (root == null)
            return 0;
        else if (value > root.value)
            return getRank(root.rightchild, value);
        else if (value == root.value) {
            if (root.rightchild != null)
                return root.rightchild.count;
            else
                return 0;
        }
        else if (value < root.value) {
            if (root.rightchild != null)
                return root.rightchild.count + 1 + getRank(root.leftchild, value);
            else
                return 1 + getRank(root.leftchild, value);
        }
        else return 0;
    }

    public int rank(int value) {
        return getRank(root, value);        
    }

    public void insert(int value) {
        insertNode(root, value);
    }    
}
class TreeTest {
    public static void main(String[] args) {
        InputReader in = new InputReader (System.in);
        int T = in.readInt();
        int result[] = new int[T];
        for (int i=0;i<T;i++) {
            int n = in.readInt();
            Tree ps = new Tree();
            int count=0;
            int[] ar = new int[n];
            for(int j=0;j<n;j++){
                ar[j]=in.readInt();
                ps.insert(ar[j]);
                if (j!=0)
                    count+=ps.rank(ar[j]); 
            }
            System.out.println(count);
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

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}
