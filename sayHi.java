import java.io.*;
import java.util.*;
class Link {
    public char word;
    public Link nextLink;

    //Link constructor
    public Link(char w) {
        word = w;
    }
    public void printLink() {
        System.out.print("{" + word +"} ");
    }
}

class LinkList {
    private Link first;

    //LinkList constructor
    public LinkList() {
        first = null;
    }

    //Inserts a new Link at the first of the list
    public void insert(char w) {
        Link link = new Link(w);
        link.nextLink = first;
        first = link;
    }


    public int checkIfValid(Link current, int count) {
        Link currentLink = current;
        while (currentLink !=null) {
            if (count>0 && count <5) {
                if ((int)currentLink.word <48 || (int)currentLink.word >57) return -1;
            }
            else if (count>4 || count == 0)
                if ((int)currentLink.word <65 || (int)currentLink.word >90) return -1;
            currentLink = currentLink.nextLink;
            count++;
        }
        if (count==10) 
            return 1;
        else return 1;
    }

    public void printList() {
        Link currentLink = first;
        System.out.print("List: ");
        while(currentLink != null) {
            currentLink.printLink();
            currentLink = currentLink.nextLink;
        }
        System.out.println("");
    }

    public int check() {
        return checkIfValid(first, 0);
    }

}  

class PAN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=Integer.parseInt(in.nextLine());
        String ar[]= new String[N];
        int result[]= new int[N];
        for (int i=0;i<N;i++) {
            ar[i]=in.nextLine();
            result[i]=0;
        }
        for (int i=0;i<N;i++) {
            int count =0;
            if (ar[i].length()==10) {
                LinkList list = new LinkList();
                for (int j=0;j<10;j++) {
                    list.insert(ar[i].charAt(j));
                }
                result[i]=list.check();
            }
            else result[i]=-1;
        }
        for (int i=0;i<N;i++) {
            if (result[i]==1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
