package Arrays1109;

import java.util.ArrayList;

public class CountInversions {
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        int n = 5;
        int cnt = numberOfInversions2(a, n);
        System.out.println("The number of inversions is: " + cnt);
    }

    // Brute Force 
    // TC - O(n^2)
    // SC - O(1)

    private static int numberOfInversions(int[] a, int n) {
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(a[i]>a[j])cnt++;
            }
        }
        return cnt;
    }

    // Optimal Approach
    // TC - O(nlogn)
    // SC - O(n)

    private static int numberOfInversions2(int[] a, int n) {
        return mergeSort(a,0,n-1);
    }

    private static int mergeSort(int[] a, int low, int high) {
        int cnt=0;
        if(low>=high)return cnt;
        int mid = (high+low)/2;
        cnt+=mergeSort(a, low, mid);
        cnt+=mergeSort(a, mid+1, high);
        cnt+=merge(a,low,mid,high);
        return cnt;
    }

    private static int merge(int[] a, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        int cnt=0;
        while(left<=mid && right<=high){
            if(a[left]<=a[right]){
                temp.add(a[left]);
                left++;
            }
            else{
                temp.add(a[right]);
                cnt+=(mid-left+1);
                right++;
            }
        }
        while(left<=mid){
            temp.add(a[left++]);
        }
        while (right<=high) {
            temp.add(a[right++]);
        }
        for(int i=low;i<=high;i++){
            a[i]=temp.get(i-low);
        }
        return cnt;
    }
}
