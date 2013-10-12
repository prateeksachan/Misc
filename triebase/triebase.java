import java.util.HashMap;

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

    public String getMatchingPrefix(String input)  {
        String result = "";
        TrieNode crawl = root;

        int prevMatch = 0;
        for(int i=0 ; i<input.length();i++ ) {
            char ch = input.charAt(i);

            HashMap<Character,TrieNode> child = crawl.getChildren();

            if(child.containsKey(ch)) {
                result += ch;
                crawl = child.get(ch);

                if(crawl.isEnd()) { 
                    prevMatch = i + 1;
                } 
            } else break;
        }

        if( !crawl.isEnd()) {
            return result.substring(0, prevMatch);
        } else return result;
    }

    private TrieNode root;      
}
   
// Testing class
public class triebase {
   public static void main(String[] args) {
        Trie dict = new Trie();        
        dict.insert("are");
        dict.insert("area");
        dict.insert("base");
        dict.insert("cat");
        dict.insert("cater");        
        dict.insert("basement");
         
        String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));              
 
        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));                      
         
        input = "are";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));              
 
        input = "area";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));              
 
        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));                      
         
        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));                      
    }
}