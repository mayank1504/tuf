package Arrays0809;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

public class MajorityElement3times {
    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        List<Integer> ans = majorityElement2(arr);
        System.out.print("The majority elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

    //Brute Force Approach
    // O(n^2)

    private static List<Integer> majorityElement(int[] arr) {
        int n = arr.length;
        List<Integer> ls = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(ls.size()==0 || ls.get(0)!=arr[i]){
                int cnt=0;
                for(int j=0;j<n;j++){
                    if(arr[j]==arr[i])cnt++;
                }
                if(cnt > n/3)ls.add(arr[i]);
            }
            if(ls.size()==2)break;
        }
        return ls;
    }

    //Better Approach
    // O(nlogn). logn for insertion

    private static List<Integer> majorityElement2(int[] arr) {
        int n = arr.length;
        List<Integer> ls = new ArrayList<>();

        HashMap<Integer,Integer> map = new HashMap<>();

        int mini = (int)(n/3)+1;

        for(int i=0;i<n;i++){
            int val = map.getOrDefault(arr[i], 0);
            map.put(arr[i], val+1);
            if(map.get(arr[i])==mini){
                ls.add(arr[i]);
            }
            if(ls.size()==2)break;
        }
        return ls;
    }

    /*Optimal Approach
    
    Initialize 4 variables:
        cnt1 & cnt2 –  for tracking the counts of elements
        el1 & el2 – for storing the majority of elements.
    Traverse through the given array.
        If cnt1 is 0 and the current element is not el2 then store the current element of the array as el1 along with increasing the cnt1 value by 1.
        If cnt2 is 0 and the current element is not el1 then store the current element of the array as el2 along with increasing the cnt2 value by 1.
        If the current element and el1 are the same increase the cnt1 by 1.
        If the current element and el2 are the same increase the cnt2 by 1.
        Other than all the above cases: decrease cnt1 and cnt2 by 1.
    The integers present in el1 & el2 should be the result we are expecting. So, using another loop, we will manually check their counts if they are greater than the floor(N/3).

    O(2*n). */

    private static List<Integer> majorityElement3(int[] arr) {
        int n = arr.length;
        int cnt1=0,cnt2=0;
        int el1=Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        List<Integer> ls = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(cnt1==0 && el2!=arr[i]){
                el1=arr[i];
                cnt1=1;
            }
            else if(cnt2==0 && el1!=arr[i]){
                cnt2=1;
                el2=arr[i];
            }
            else if(arr[i]==el1)cnt1++;
            else if(arr[i]==el2)cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1=0;
        cnt2=0;
        for(int i=0;i<n;i++){
            if(arr[i]==el1)cnt1++;
            if (arr[i]==el2) {
                cnt2++;
            }
        }

        int mini = (int)(n/3)+1;
        if(cnt1 >= mini)ls.add(el1);
        if(cnt2 >= mini)ls.add(el2);
        return ls;
    }

}
