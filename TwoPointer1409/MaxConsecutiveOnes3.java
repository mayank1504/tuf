package TwoPointer1409;

public class MaxConsecutiveOnes3 {
    // Driver Code
    public static void main(String[] args) {
        MaxConsecutiveOnes3 mco3 = new MaxConsecutiveOnes3();
        int[] nums = {1,1,1,0,0,0,1,1,1,1};
        int k = 2;
        System.out.println(mco3.longestOnes(nums,k));   
    }

    //Brute Force Approach
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int longestOnes_BruteForce(int[] nums, int k) {
        int maxLen = 0;
        for(int i=0;i<nums.length;i++){
            int zeroCount = 0;
            for(int j=i;j<nums.length;j++){
                if(nums[j]==0){
                    zeroCount++;    
                }
                if(zeroCount>k){
                    break;
                } else {
                    maxLen = Math.max(maxLen,j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // Longest Subarray with at most K 0's
    // Time Complexity: O(2n)
    // Space Complexity: O(1)
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0,maxlen=0,zeroCount=0;
        while(r<nums.length){
            if(nums[r]==0){
                zeroCount++;
            }
            while(zeroCount>k){
                if(nums[l]==0){
                    zeroCount--;
                }
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }

    // Optimal Approach 
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int longestOnesOptimal(int[] nums, int k) {
        int n = nums.length;
        int l=0,r=0,maxlen=0;
        int zeroCount=0;
        while(r<n){
            if(nums[r]==0)zeroCount++;
            if(zeroCount>k){
                if(nums[l]==0){
                    zeroCount--;
                }
                l++;
            }
            if(zeroCount<=k){
                maxlen = Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}
