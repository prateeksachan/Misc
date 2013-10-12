import java.io.*;
import java.text.*;
import java.util.*;
class Link {
    public int data;
    public Link nextLink;
    public Link prevLink;

    public Link(int w) {
        data = w;
        prevLink =null;
        nextLink =null;
    }
    public Link() {
        prevLink =null;
        nextLink =null;
    }
    
}               

class LinkList {
    private Link head;
    private Link tail;
    private Link current;
    private int count;
    
    public LinkList() {
        head = new Link();
        tail = new Link();
        current = null;
        count = 0;
    }

    public String insertLink(int w, Link front) {
        if (count==0) {
            Link link = new Link(w);
            link.nextLink = head;
            link.prevLink = tail;
            head.prevLink = link;
            tail.nextLink = link;
            count++;
            return computeMedian();
        }
        while (front.prevLink!=null && front.prevLink!=tail) {
            Link temp = front.prevLink;
            if (w>=temp.data) {
                Link link = new Link(w);
                link.nextLink = front;
                link.prevLink = temp;
                temp.nextLink = link;
                front.prevLink = link;
                count++;
                return computeMedian();
            }
            else return insertLink(w, front.prevLink);
        }
        Link link = new Link(w);
        link.nextLink = front;
        link.prevLink = tail;
        front.prevLink = link;
        tail.nextLink = link;
        count++;
        return computeMedian();
    }

    public String insert(int w) {
        return insertLink(w, head);
    }

    public String deleteLink(int w, Link front) {
        if (isEmpty() == true || dataNotFound(w)==true)
            return "0.0";
        else {
            while (front!=null) {
                if (front.data==w) {
                    Link temp1 = front.prevLink;
                    Link temp2 = front.nextLink;
                    temp1.nextLink = temp2;
                    temp2.prevLink = temp1;
                    count--;
                    return computeMedian();
                }
                else return deleteLink(w, front.prevLink);
            }
        }
        return "0.0";
    }

    public String delete(int w) {
        return deleteLink(w, head);
    }

    public boolean dataNotFound(int w) {
        boolean flag = true;
        Link temp = head.prevLink;
        while (temp !=null && temp!=tail) {
            if (temp.data==w) {
                flag=false;
                break;
            }
            else temp=temp.prevLink;
        }
        return flag;
    }

    public boolean isEmpty() {
        if (count==0) {
            return true;
        }
        else return false;
    }

    public String computeMedian() {
        int size = computeSize();
        if (size!=0) {
            if (size%2==0)
                return findElement(size/2,2);
            else return findElement(size/2+1,1);
        }
        else return "0.0";
    }

    public int computeSize() {
        return count;
    }

    public String findElement(int x, int y) {
        Link temp = head.prevLink;
        int c=1;
        double r =0.0;
        DecimalFormat ps = new DecimalFormat("#.#####"); 
        if (isEmpty() == false) {
            while (temp!=tail) {
                if (x==c && y==2) {
                    long x1 = temp.data;
                    long x2 = (temp.prevLink).data;
                    r=(x1+x2);
                    return ""+ps.format(r/2)+"\n";
                }
                else if (x==c && y==1)
                    return ""+temp.data+"\n";
                else {
                    temp=temp.prevLink;
                    c++;
                }
            }
        }
        return "0.0";
    }
}  

class Median1 {
    public static void main( String args[] ) {
        Scanner in = new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        Median1 obj = new Median1();
        LinkList list = new LinkList();
        int N = in.nextInt();
        String s[] = new String[N];
        int x[] = new int[N];
        for(int i=0; i<N; i++){
            s[i] = in.next();
            x[i] = in.nextInt();
        }
        for (int i=0;i<N;i++) {
            if (s[i].equals("a")) {
                String result = list.insert(x[i]);
                if (result.equals("0.0"))
                    System.out.print("Wrong!\n");
                else System.out.print(result);
            }
            else if (s[i].equals("r")) {
                String result = list.delete(x[i]);
                if (result.equals("0.0"))
                    System.out.print("Wrong!\n");
                else System.out.print(result);
            }
        }
        out.close();
    }
}
