package Arrays0809;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement2times {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityElement(arr);
        System.out.println("The majority element is: " + ans);
    }

    // Brute Force Approach
    // O(n^2)

    private static int majorityElement(int[] arr) {
        int n = arr.length;

        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(arr[i]==arr[j])cnt++;
            }
            if(cnt > n/2)return arr[i];
        }
        return -1;
    }

    // Better Approach
    // O(n*logm + n)

    private static int majorityElement2(int[] arr) {
        int n = arr.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int val = map.getOrDefault(arr[i], 0);
            map.put(arr[i], val+1);
        }

        for(Map.Entry<Integer,Integer> it: map.entrySet()){
            if(it.getValue() > n/2)return it.getKey();
        }
        return -1;
    }

    // Optimal Approach
    // O(n + n)

    private static int majorityElement3(int[] arr) {
        int n = arr.length;
        int cnt=0,ele=0;
        for(int i=0;i<n;i++){
            if(cnt==0){
                cnt=1;
                ele=arr[i];
            }
            else if(ele == arr[i])cnt++;
            else cnt--;
        }

        int cnt1=0;
        for(int i=0;i<n;i++){
            if(ele==arr[i])cnt1++;
        }
        if(cnt1 > n/2)return ele;
        return -1;
    }
}
