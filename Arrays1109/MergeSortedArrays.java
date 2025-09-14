package Arrays1109;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        long[] arr1 = {1, 4, 8, 10};
        long[] arr2 = {2, 3, 9};
        int n = 4, m = 3;
        merge2(arr1, arr2, n, m);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }

    // Brute Force Approach
    // O(2*(n+m))

    private static void merge(long[] arr1, long[] arr2, int n, int m) {
        long[] arr = new long[n+m];
        int left=0;
        int right=0;
        int ind=0;

        while(left<n && right<m){
            if(arr1[left]<=arr2[right]){
                arr[ind++]=arr1[left++];
            }
            else{
                arr[ind++]=arr2[right++];
            }
        }

        while (left<n) {
            arr[ind++]=arr1[left++];
        }

        while (right<m) {
            arr[ind++]=arr2[right++];
        }

        for(int i=0;i<n+m;i++){
            if(i<n){
                arr1[i]=arr[i];
            }
            else arr2[i-n]=arr[i];
        }
    }

    // Better Approach
    // O(min(n, m)) + O(n*logn) + O(m*logm)

    private static void merge2(long[] arr1, long[] arr2, int n, int m) {
        int left=n-1;
        int right=0;
        
        while(left>=0 && right<m){
            if(arr1[left]>arr2[right]){
                long temp = arr2[right];
                arr2[right] = arr1[left];
                arr1[left] = temp;
                right++;
                left--;
            }
            else break;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    // Gap Method
    // O((n+m) log(n+m)) SC - O(1)
    private static void merge3(long[] arr1, long[] arr2, int n, int m) {
        int gap = (int) Math.ceil((n + m) / 2.0);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < (n + m)) {
                // Both pointers in arr1
                if (left < n && right < n) {
                    if (arr1[left] > arr1[right]) {
                        long temp = arr1[left];
                        arr1[left] = arr1[right];
                        arr1[right] = temp;
                    }
                }
                // left pointer in arr1 and right pointer in arr2
                else if (left < n && right >= n) {
                    if (arr1[left] > arr2[right - n]) {
                        long temp = arr1[left];
                        arr1[left] = arr2[right - n];
                        arr2[right - n] = temp;
                    }
                }
                // Both pointers in arr2
                else {
                    if (arr2[left - n] > arr2[right - n]) {
                        long temp = arr2[left - n];
                        arr2[left - n] = arr2[right - n];
                        arr2[right - n] = temp;
                    }
                }
                left++;
                right++;
            }

            if (gap == 1) {
                gap = 0;
            } else {
                gap = (int) Math.ceil(gap / 2.0);
            }
        }
    }
}
