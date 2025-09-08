package Arrays0809;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArray012 {
    public static void main(String[] args) {
        int n = 6;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] {0, 2, 1, 2, 0, 1}));
        sortArray(arr, n);
        System.out.println("After sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    private static void sortArray(ArrayList<Integer> arr, int n) {
        int cnt0=0, cnt1 =0, cnt2=0;
        for(int i=0;i<n;i++){
            if(arr.get(i)==0)cnt0++;
            else if(arr.get(i)==1)cnt1++;
            else cnt2++;
        }

        for(int i=0;i<cnt0;i++)arr.set(i, 0);
        for(int i=cnt0;i<cnt0+cnt1;i++)arr.set(i, 1);
        for(int i=cnt0+cnt1;i<n;i++)arr.set(i, 2);
    }

    // TC - O(n)
    // SC - O(1)
    // Dutch National Flag Algorithm

    public void sortZeroOneTwo(int[] arr) {
        int n=arr.length;
        int low=0,mid=0,high=n-1;
        while(mid<=high){
            if (arr[mid]==0) {
                int temp = arr[low];
                arr[low]= arr[mid];
                arr[mid]= temp;
                low++;
                mid++;
            }
            else if(arr[mid]==1)mid++;
            else{
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid]= temp;
                high--;
            }
        }
    }
}
