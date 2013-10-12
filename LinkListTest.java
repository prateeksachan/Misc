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

    public String convertToUs(String w) {
        String r = "";
        for (int i=0;i<w.length();i++) {
            if (w.charAt(i)=='o' && w.charAt(i+1)=='u' && w.charAt(i+2)=='r')
                r=w.substring(0,i)+"or"+w.substring(i+3,w.length());
        }
        return r;
    }
}  

class LinkListTest {
    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        int N=Integer.parseInt(in.nextLine());
        String ar[]= new String[N];
        for (int i=0;i<N;i++) {
            ar[i]=in.nextLine()+" ";
        }
        int T=Integer.parseInt(in.nextLine());
        String query[]=new String[T];
        for (int i=0;i<T;i++) {
            query[i] = in.nextLine();
        }
        for (int k=0;k<T;k++) {
            int count =0;
            for (int i=0;i<N;i++) {
                LinkList list = new LinkList();
                String word="";
                for (int j=0;j<ar[i].length();j++) {
                    if (ar[i].charAt(j)==' ') {
                        list.insert(word);
                        word="";   
                    }
                    else word+=ar[i].charAt(j);
                }
                count+=list.search(query[k])+list.search(list.convertToUs(query[k]));
            }
            System.out.println(count);
        }    
	}
}