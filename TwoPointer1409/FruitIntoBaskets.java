package TwoPointer1409;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    // Driver Code
    public static void main(String[] args) {
        FruitIntoBaskets fitb = new FruitIntoBaskets();
        int[] fruits = {1, 2, 3, 1, 3};
        System.out.println(fitb.totalFruit(fruits));   
    }

    //Brute Force Approach
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int totalFruit_BruteForce(int[] fruits) {
        int maxLen = 0;
        for(int i=0;i<fruits.length;i++){
            int countA = 0;
            int countB = 0;
            for(int j=i;j<fruits.length;j++){
                if(fruits[j]==fruits[i]){
                    countA++;
                } else if(countB==0){
                    countB++;
                } else if(fruits[j]!=fruits[i] && countB>0 && fruits[j]!=fruits[j-1]){
                    break;
                } else if(fruits[j]==fruits[j-1]){
                    countB++;
                }
                maxLen = Math.max(maxLen,j - i + 1);
            }
        }
        return maxLen;
    }

    // Longest Subarray with at most K distinct characters
    // Time Complexity: O(2n)
    // Space Complexity: O(n)
    public int totalFruit(int[] fruits) {
        int l = 0, r = 0, maxlen = 0;
        Map<Integer, Integer> fruitCountMap = new HashMap<>();
        while (r < fruits.length) {
            fruitCountMap.put(fruits[r], fruitCountMap.getOrDefault(fruits[r], 0) + 1);
            while (fruitCountMap.size() > 2) {
                int leftFruit = fruits[l];
                fruitCountMap.put(leftFruit, fruitCountMap.get(leftFruit) - 1);
                if (fruitCountMap.get(leftFruit) == 0) {
                    fruitCountMap.remove(leftFruit);
                }
                l++;
            }
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }

    // Optimal Approach
    // Time Complexity: O(2n)
    // Space Complexity: O(n)
    public int totalFruits(int[] fruits) {
        int l=0,r=0,maxlen=0;
        int n = fruits.length;
        int[] hash = new int[n+1];
        int distinctCount = 0;
        while(r<n){
            int ch = fruits[r];
            if(hash[ch]==0){
                distinctCount++;
            }
            hash[ch]++;
            while(distinctCount>2){
                int leftele = fruits[l];
                hash[leftele]--;
                if(hash[leftele]==0){
                    distinctCount--;
                }
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }

    // Optimal Approach 2
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int totalFruits2(int[] fruits) {
        int l=0,r=0,maxlen=0;
        int n = fruits.length;
        int[] hash = new int[n+1];
        int distinctCount = 0;
        while(r<n){
            int ch = fruits[r];
            if(hash[ch]==0){
                distinctCount++;
            }
            hash[ch]++;
            if(distinctCount>2){
                int leftele = fruits[l];
                hash[leftele]--;
                if(hash[leftele]==0){
                    distinctCount--;
                }
                l++;
            }
            if(distinctCount<=2)maxlen = Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}
