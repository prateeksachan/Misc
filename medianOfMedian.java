import java.io.*;
import java.util.*;
import java.math.*;

public class medianOfMedian {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=in.nextInt();
        }
        System.out.println("Ans: "+findK(arr, 0, n-1, k));
    }

    public static int findK(int arr[], int left, int right, int k) {
        if (k<1 || k>arr.length) {
            return 0;
        }
        else if (arr.length<=5) {
            sort(arr);
            return arr[k-1];
        }
        int numMedians = arr.length/5;
        int medians = new int[numMedians];
        for (int i=0;i<numMedians;i++) {
            medians[i] = findK(arr, left+5*i, left+5*(i+1)-1, 3);
        }
        int pivot = findK(medians, 0 , medians.length-1, medians.length/2+1);
        int pivotIndex=partition(arr, left, right, pivot); 
        int rank=pivotIndex-left+1;
        if (k<=rank) {
            return findK(arr, left, pivotIndex, k);
        } else {
            return findK(arr, pivotIndex+1, right, k-rank);
        }

    }

    public static int partition(int arr[], int left, int right, int pivotIndex) {
        int temp = 0;
        int swapIndex = left;
        for (int i=left;i<=right;i++) {
            if (arr[i]<pivot) {
                temp = arr[i];
                arr[i] = arr[swapIndex];
                arr[swapIndex] = temp;
                swapIndex++;
            }
        }
        return swapIndex-1;
    }

    public void sort(int a[]) {
        for (int i=0;i<a.length;i++) {
            
        }
    }
}
