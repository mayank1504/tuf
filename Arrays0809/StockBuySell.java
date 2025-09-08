package Arrays0809;

public class StockBuySell {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        int maxPro = maxProfit2(arr);
        System.out.println("Max profit is: " + maxPro);
    }

    // Brute force 
    // O(n^2)
    private static int maxProfit(int[] arr) {
        int maxPro = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[i]){
                    maxPro=Math.max(maxPro, arr[j]-arr[i]);
                }
            }
        }
        return maxPro;
    }

    //Optimal Approach
    // O(n)

    private static int maxProfit2(int[] arr) {
        int maxPro = 0 ;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            minPrice = Math.min(minPrice, arr[i]);
            maxPro = Math.max(maxPro, arr[i]-minPrice);
        }
        return maxPro;
    }
}
