package Arrays0809;

public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        int maxSum = maxSubarraySum2(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);
    }

    // Brute Force 
    // O(n^3)

    private static int maxSubarraySum(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }

    // Better Approach
    // O(n^2)

    private static int maxSubarraySum2(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }

    // Optimal Approach- Kadane's Algo
    // O(n)

    private static long maxSubarraySum3(int[] arr, int n) {
        long maxi = Long.MIN_VALUE;
        long sum = 0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum>maxi)maxi=sum;
            if(sum<0)sum=0;
        }
        return maxi;
    }

    // Print the array

    private static long maxSubarraySum4(int[] arr, int n) {
        long maxi = Long.MIN_VALUE;
        long sum = 0;
        int start=0;
        int ansStart=-1,ansEnd=-1;
        for(int i=0;i<n;i++){
            if(sum==0)start=i;
            sum+=arr[i];
            if(sum>maxi){
                maxi=sum;
                ansStart=start;
                ansEnd=i;
            }
            if(sum<0)sum=0;
        }
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]n");
        return maxi;
    }
}
