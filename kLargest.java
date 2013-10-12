import java.io.*;
import java.util.*;
import java.math.*;

public class kLargest {
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
        else if (left==right) {
            return arr[left];
        }
        while (true) {
            int pivotIndex = randInt(left, right);
            pivotIndex = partition(arr, left, right, pivotIndex);
            int rank = pivotIndex-left+1;
            if (rank==k) {
                return arr[pivotIndex];
            }
            else if (k<rank) {
                return findK(arr, left, pivotIndex-1, k);
            }
            else return findK(arr, pivotIndex+1, right, k-rank);
        }
    }

    public static int partition(int arr[], int left, int right, int pivotIndex) {
        int temp = arr[right];
        arr[right] = arr[pivotIndex];
        arr[pivotIndex] = temp;
        int pivot = arr[right];
        int swapIndex = left;
        for (int i=left;i<=right;i++) {
            if (arr[i]<pivot) {
                temp = arr[i];
                arr[i] = arr[swapIndex];
                arr[swapIndex] = temp;
                swapIndex++;
            }
        }
        temp = arr[right];
        arr[right] = arr[swapIndex];
        arr[swapIndex] = temp;
        return swapIndex;
    }

    public static int randInt(int min, int max) {
        return (min + (int)(Math.random() * ((max - min) + 1)));
    }
}
