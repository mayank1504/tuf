package Arrays1109;

public class MaxProductSubArr {
    // Brute Force Approach
    // TC - O(N^2) SC - O(1)
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    // Optimal Approach
    // TC - O(N) SC - O(1)
    public static int maxProductOptimal(int[] nums) {
        int n = nums.length;
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);
            result = Math.max(result, maxProduct);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        System.out.println(maxProduct(arr));
        System.out.println(maxProductOptimal(arr));
    }

    // Another Optimal Approach
    // TC - O(N) SC - O(1)
    public int maxProductOptimal2(int[] nums) {
        int n = nums.length;
        int prefix=1,suffix=1;
        int res = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prefix==0)prefix=1;
            if(suffix==0)suffix=1;
            suffix = suffix*nums[n-i-1];
            prefix = prefix*nums[i];
            res = Math.max(res,Math.max(prefix,suffix));
        }
        return res;
    }
}
