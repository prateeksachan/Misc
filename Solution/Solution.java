import java.io.*;
import java.util.*;

class TrieNode {
    public TrieNode(char ch) {
        value = ch;
        children = new HashMap<>();
        isEnd = false;
    }

    public HashMap<Character,TrieNode> getChildren() {
       return children;
    }

    public char getValue() {
        return value;
    }

    public void setIsEnd(boolean val) {
       isEnd = val;
    }

    public boolean isEnd() {
       return isEnd;
    }

    private char value;

    private HashMap<Character,TrieNode> children;

    private boolean isEnd;
}

class Trie {
    public Trie() {
         root = new TrieNode((char)0);
    }
    private TrieNode root;

    public void insert(String word) {
        TrieNode crawl = root;
        for(int i = 0; i<word.length(); i++) {
            HashMap<Character,TrieNode> child = crawl.getChildren();
            char ch = word.charAt(i);

            if(child.containsKey(ch)) {
                crawl = child.get(ch);
            } else {
                TrieNode temp = new TrieNode(ch);
                child.put( ch, temp );
                crawl = temp;
            }
        }

        crawl.setIsEnd(true);
    }

    public int getMatchingSuffix(String input)  {
        TrieNode crawl = root;

        int prevMatch = 0;
        for(int i=0 ; i<input.length();i++ ) {
            char ch = input.charAt(i);

            HashMap<Character,TrieNode> child = crawl.getChildren();

            if(child.containsKey(ch)) {
                prevMatch++;
                crawl = child.get(ch);

                if(crawl.isEnd()) { 
                    prevMatch = i + 1;
                } 
            } else break;
        }
        return prevMatch;
    }

}

public class Solution {

    public static void main(String[] args) throws IOException {
        Solution obj = new Solution();
        InputReader in=new InputReader(System.in);
        int T = in.readInt();
        String arr[] = new String[T];
        int result[] = new int[T];
        for (int i=0;i<T;i++) {
            arr[i] = in.readString();
            Trie dict = new Trie();
            int length = arr[i].length();
            dict.insert(arr[i]);
            for (int j=0;j<length;j++) {
                result[i]+=dict.getMatchingSuffix(arr[i].substring(j,length));                
            }
        }
        /*-----------------------------*/
        for (int i=0;i<T;i++) {
            System.out.println(result[i]);
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
