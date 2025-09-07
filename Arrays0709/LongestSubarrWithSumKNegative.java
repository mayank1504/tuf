package Arrays0709;

import java.util.HashMap;

public class LongestSubarrWithSumKNegative {
    public int longestSubarray(int[] nums, int k) {
       int n=nums.length;
       HashMap<Integer,Integer> preSumMap = new HashMap<>();
       int sum=0;
       int maxLen=0;
       for(int i=0;i<n;i++){
        sum+=nums[i];
        if(sum==k){
            maxLen=Math.max(maxLen,i+1);
        }
        int rem = sum-k;
        if(preSumMap.containsKey(rem)){
            int len = i-preSumMap.get(rem);
            maxLen=Math.max(maxLen,len);
        }
        if(!preSumMap.containsKey(sum)){
            preSumMap.put(sum,i);
        }
       }
       return maxLen;
    }
}
