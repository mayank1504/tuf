package Arrays0709;

public class FindMissingNumber {
public int missingNumber(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int expected_sum=(n*(n+1))/2;
        return expected_sum-sum;
    }
}
