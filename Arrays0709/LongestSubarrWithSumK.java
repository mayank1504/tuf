package Arrays0709;

public class LongestSubarrWithSumK {
    public int longestSubarray(int[] nums, int k) {
       int left=0,right=0,n=nums.length;
       int maxLen=0,sum=nums[0];
       while(right<n){
        while(left<=right && sum>k){
            sum-=nums[left++];
        }
        if(sum==k){
            maxLen=Math.max(maxLen,right-left+1);
        }
        right++;
        if(right<n)sum+=nums[right];
       }
       return maxLen;
    }
}
