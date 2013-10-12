import java.math.*;
import java.text.*;
import java.io.*;
import java.util.*;
class Median {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<N; i++){
            String op = in.next();
            int number = in.nextInt();
            compute(op, number, list);
        }
    }

    private static void compute(String op, int number, List<Integer> list) {
        DecimalFormat ps = new DecimalFormat("#.#####"); 
        int index = Collections.binarySearch(list, number);
        System.out.println(index);
        if(op.equalsIgnoreCase("r")){
            if(index < 0){
                System.out.println("Wrong!");
                return;
            }else{
                list.remove(index);
            }
        }else{
            if(index < 0){
                list.add(-index-1, number);
            }else{
                list.add(index, number);
            }
        }
        if(list.size() == 0){
            System.out.println("Wrong!");
        }else if(list.size()%2 == 0){
            long x1= list.get(list.size()/2);
            long x2= list.get(list.size()/2 - 1);
            double x3= x1+x2;
            if (x3%2==0)
                System.out.println(x3/2);
            else {
                System.out.println(ps.format(x3/2));
                }
        }else{
            System.out.println(list.get((list.size()-1)/2));
        }
    }
}