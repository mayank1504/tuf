package Arrays1109;

import java.util.ArrayList;

public class CountReversePairs {
    public static void main(String[] args) {
        int[] a = {4, 1, 2, 3, 1};
        int n = 5;
        int cnt = team2(a, n);
        System.out.println("The number of reverse pair is: " + cnt);
    }

    // Brute Force Approach
    // O(n^2)

    private static int team(int[] a, int n) {
        return countPairs(a,n);
    }

    private static int countPairs(int[] a, int n) {
        int cnt =0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(a[i] > 2*a[j])cnt++;
            }
        }
        return cnt;
    }

    // Optimal Approach
    // O(2nlogn)

    private static int team2(int[] a, int n) {
        return mergeSort(a,0,n-1);
    }

    private static int mergeSort(int[] a, int low, int high) {
        int cnt = 0;
        if(low >= high)return cnt;
        int mid = (low+high)/2;
        cnt += mergeSort(a, low, mid);
        cnt += mergeSort(a, mid+1, high);
        cnt += countPairs2(a,low,mid,high);
        merge(a,low,mid,high);
        return cnt;
    }

    private static void merge(int[] a, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left<=mid && right<=high){
            if(a[left]<=a[right]){
                temp.add(a[left]);
                left++;
            }
            else{
                temp.add(a[right]);
                right++;
            }
        }

        while(left<=mid){
            temp.add(a[left]);
            left++;
        }

        while (right<=high) {
            temp.add(a[right]);
            right++;
        }

        for(int i=low;i<=high;i++){
            a[i]=temp.get(i-low);
        }
    }

    private static int countPairs2(int[] a, int low, int mid, int high) {
        int right = mid+1;
        int cnt =0 ;
        for(int i=low;i<=mid;i++){
            while (right<=high && a[i]> 2*a[right]) {
                right++;
            }
            cnt+=(right-(mid+1));
        }
        return cnt;
    }
}
