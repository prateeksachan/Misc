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
}
