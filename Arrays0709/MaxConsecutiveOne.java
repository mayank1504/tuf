package Arrays0709;

public class MaxConsecutiveOne {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxi=0;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                cnt++;
                if(cnt>maxi)maxi=cnt;
            }
            else{
                cnt=0;
            }
        }
        return maxi;
    }
}
