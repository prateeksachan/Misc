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

    public void process(String a) {
        System.out.println(a);
    }
}

class htmlAttributes {
    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        LinkList list = new LinkList();
        int N=Integer.parseInt(in.nextLine());
        int count = 0;
        String ar[]= new String[N];
        for (int i=0;i<N;i++) {
            ar[i]=in.nextLine()+" ";
        }
        for (int i=0;i<N;i++) {
            int start=0;
            int end=0;
            int flag=0;
            for (int j=0;j<ar[i].length();j++) {
                if (ar[i].charAt(j)=='<' && flag == 0) {
                    start = j;
                    flag=1;
                }
                if (ar[i].charAt(j)=='>') {
                    if (ar[i].charAt(j-2)!='/')
                        end = j;
                }    
                if (flag==1) {
                    System.out.println(end+"---"+start);
                    list.process(ar[i].substring(start,end));
                    end=start=flag=0;
                }
            }   
        }
    } 
}
