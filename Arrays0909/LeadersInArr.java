package Arrays0909;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArr {
    public ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> res= new ArrayList<>();
        int n=nums.length;
        int maxi = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(nums[i]>maxi){
                res.add(nums[i]);
                maxi=nums[i];
            }
        }
        Collections.reverse(res);
        return res;
    }

    // TC - O(n) SC - O(1) if we don't consider the output array
}
