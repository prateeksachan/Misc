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

    public int getMatchingPrefix(String input)  {
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
   
// Testing class
public class stringsimilarity {
   public static void main(String[] args) {
        stringsimilarity obj = new stringsimilarity();
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String arr[] = new String[T];
        for (int i=0;i<T;i++) {
            arr[i] = in.next();
        }
        /*-----------------------------*/
        for (int i=0;i<T;i++) {
            int result=0;
            Trie dict = new Trie();
            dict.insert(arr[i]);
            int length = arr[i].length();
            for (int j=0;j<length;j++) {
                result+=dict.getMatchingPrefix(arr[i].substring(j,length));                
            }
            System.out.println(result);
        }
    }
}