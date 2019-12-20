import java.util.*;

public class Inversions {

 private static int mergeAndCount(int[] arr, int l, int m, int r) 
    { 
        int[] left = Arrays.copyOfRange(arr, l, m + 1); 
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 
        int i = 0, j = 0, k = l, swaps = 0; 
        while (i < left.length && j < right.length) { 
            if (left[i] <= right[j]) 
                arr[k++] = left[i++]; 
            else { 
                arr[k++] = right[j++]; 
                swaps += (m + 1) - (l + i); 
            } 
        } 
        while (i < left.length) 
            arr[k++] = left[i++]; 
        while (j < right.length) 
            arr[k++] = right[j++]; 
  
        return swaps; 
    } 
    private static int mergeSortAndCount(int[] arr, int l, int r) 
    { 
        int count = 0; 
        if (l < r) { 
            int m = (l + r) / 2; 
            count += mergeSortAndCount(arr, l, m); 
            count += mergeSortAndCount(arr, m + 1, r); 
            count += mergeAndCount(arr, l, m, r); 
        } 
        return count; 
    } 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(mergeSortAndCount(a, 0, a.length - 1)); 
    }
}

