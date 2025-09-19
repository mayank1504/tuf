package TwoPointer1409;

public class CountNiceSubArr {
    // Function to count the number of nice subarrays
    // A nice subarray is defined as a subarray with exactly k odd numbers
    // using the two-pointer technique
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int numberOfOddSubarrays(int[] nums, int k) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]=nums[i]%2;
        }
        return numSubarraysWithSum(nums,k);
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums,goal)-helper(nums,goal-1);
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

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println("Number of nice subarrays: " + String.valueOf(numberOfOddSubarrays(nums, k)));
    }
}
