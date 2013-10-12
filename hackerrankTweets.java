import java.io.*;
import java.util.*;
class Link {
    public String word;
    public Link nextLink;

    //Link constructor
    public Link(String w) {
	    word = w;
    }
}

class LinkList {
    private Link first;

    //LinkList constructor
    public LinkList() {
	    first = null;
    }

    //Inserts a new Link at the first of the list
    public void insert(String w) {
	    Link link = new Link(w);
	    link.nextLink = first;
	    first = link;
    }

    public int searchWord(Link current, String w, int count) {
        Link currentLink = current;
        while (currentLink !=null) {
            if (currentLink.word.equals(w))
                count++;
            currentLink = currentLink.nextLink;
        }
        if (currentLink==null) 
            return count;
        else return count;
    }

    public int search(String w) {
        return searchWord(first, w, 0);
    }
}  

class hackerrankTweets {
    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        int N=Integer.parseInt(in.nextLine());
        int count = 0;
        String ar[]= new String[N];
        for (int i=0;i<N;i++) {
            ar[i]=in.nextLine()+" ";
        }
        for (int i=0;i<N;i++) {
            LinkList list = new LinkList();
            String word="";
            for (int j=0;j<ar[i].length();j++) {
                if (ar[i].charAt(j)==' ') {
                    list.insert(word);
                    word="";   
                }
                else {
                    if ((int)ar[i].charAt(j)>=65 && (int)ar[i].charAt(j)<=90) 
                        word+=(char)(ar[i].charAt(j)+32);
                    else if ((int)ar[i].charAt(j)>=97 && (int)ar[i].charAt(j)<=122)
                        word+=(char)(ar[i].charAt(j));
                    else
                        word+="#";
                }
            }
            count+=list.search("hackerrank")+list.search("#hackerrank");
        }
        System.out.println(count);
    }
}
