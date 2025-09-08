package Arrays0809;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        int[] ans = twoSum(n, arr, target);
        System.out.println("This is the answer for variant 2: [" + ans[0] + ", "
                           + ans[1] + "]");
    }

    // Brute Force Approach
    // O(n^2)

    private static int[] twoSum(int n, int[] arr, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }
            }
        }
        return ans;
    }

    // Better Hashing Approach
    // O(n)

    private static int[] twoSum2(int n, int[] arr, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int num = arr[i];
            int rem = target - num;
            if(map.containsKey(rem)){
                ans[0]=map.get(rem);
                ans[1]=i;
                return ans;
            }
            map.put(arr[i], i);
        }
        return ans;
    }

    // Optimal Approach
    // O(n + nlogn)

    private static int[] twoSum3(int n, int[] arr, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        Arrays.sort(arr);
        int left=0,right=n-1;
        while(left<=right){
            if(arr[left]+arr[right]==target){
                ans[0]=left;
                ans[1]=right;
                return ans;
            }
            else if(arr[left]+arr[right] < target)left++;
            else right--;
        }
        return ans;
    }
}
