package Arrays1009;

import java.util.HashMap;

public class CountSubArrSumEqualK {
    // Brute Force Approach
    // O(n^2)
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int k = 2;
        int ans = countSubArrSumEqualK(arr, k);
        System.out.println("The count of subarrays with sum equal to " + k + " is: " + ans);
    }

    private static int countSubArrSumEqualK(int[] arr, int k) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }      
    
    // Better Approach
    // O(n)
    // Using HashMap
    private static int countSubArrSumEqualK2(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with sum 0 occurring once  
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
