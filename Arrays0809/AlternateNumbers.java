package Arrays0809;

import java.util.ArrayList;
import java.util.List;

public class AlternateNumbers {
    public static int[] rearrangeArray(int[] nums){
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]>0)pos.add(nums[i]);
            neg.add(nums[i]);
        }

        int i=0,pIndex=0,nIndex=0;
        int[] res = new int[n];

        while(pIndex<pos.size() && nIndex<neg.size()){
            res[i++]=pos.get(pIndex++);
            res[i++]=neg.get(nIndex++);
        }

        while(pIndex<pos.size()){
            res[i++]=pos.get(pIndex++);
        }
        while (nIndex<neg.size()) {
            res[i++]=neg.get(nIndex++);
        }

        return res;
    }

    // TC - O(2n)
    // SC - O(n)
}
