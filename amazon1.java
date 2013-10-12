import java.io.*;
import java.util.*;
class Node{
    public Node next;
    public int value;
    Node(int n, Node next) {
        this.value=n;
        this.next=next;
    }
}
class LinkedList{
    private Node start;
    LinkedList() {
        start=null;
    }
    public void add(int n) {
        Node cache = this.start;
        this.start=new Node(n,cache);
    }
    public void print() {
        Node cache = start; 
        Node current = null;
        while((current = cache) != null) {
            System.out.print(cache.value+"-->");
            cache = cache.next;
        }
    }
}

class amazon1 {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader (System.in);
        int T1 = in.readInt();
        int T2 = in.readInt();
        int T3 = in.readInt();
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        LinkedList list3 = new LinkedList();
        while (T1>10){
            list1.add(T1%10);
            T1/=10;
        }
        list1.add(T1);
        while (T2>10){
            list1.add(T2%10);
            T2/=10;
        }
        list1.add(T2);
        while (T3>10){
            list1.add(T3%10);
            T3/=10;
        }
        list1.add(T3);
        
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
