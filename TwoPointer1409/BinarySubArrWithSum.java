package TwoPointer1409;

public class BinarySubArrWithSum {
    // Driver method to test the function
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1};
        int targetSum = 2;
        System.out.println("Number of subarrays with sum " + targetSum + ": " + numSubarraysWithSum(arr, targetSum));
    }

    // Brute Force Approach (Commented Out)
    // TC O(n^2)
    // SC O(1)
    public static String numSubarraysWithSumBrute(int[] arr, int targetSum) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += arr[j];
                if (currentSum == targetSum) {
                    count++;
                }
            }
        }
        return String.valueOf(count);
    }
    

    // Function to count the number of subarrays with a given sum
    // using the two-pointer technique
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static String numSubarraysWithSum(int[] nums, int goal) {
        return String.valueOf(helper(nums,goal)-helper(nums,goal-1));
    }

    private static int helper(int[] nums,int goal){
        if(goal<0)return 0;
        int l=0,r=0,n=nums.length,cnt=0,sum=0;

        while(r<n){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
        return cnt;
    }
}
