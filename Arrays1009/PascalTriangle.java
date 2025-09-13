package Arrays1009;

public class PascalTriangle {
    public static void main(String[] args) {
        int r = 5; // row number
        int c = 3; // col number
        int element = pascalTriangle(r, c);
        System.out.println("The element at position (r,c) is: " + element);
    }

    // Function to calculate nCr (combinatorial number)
    private static long nCr(int n,int r){
        long res=1;
        for(int i=0;i<r;i++){
            res = res * (n-i);
            res = res/(i+1);
        }
        return res;
    }

    // Function to get the element at row r and column c in Pascal's Triangle
    // Tc: O(r)
    // Sc: O(1)
    private static int pascalTriangle(int r, int c) {
        int ele = (int) nCr(r-1,c-1);
        return ele;
    }

    // Print any given row of Pascal's Triangle
    // Tc: O(r^2)
    // Sc: O(1)
    private static void printRow(int r) {
        for (int i = 0; i < r; i++) {
            System.out.print(nCr(r - 1, i) + " ");
        }
    }   

    // Optimal approach to print nth row of Pascal's Triangle
    // Tc: O(r)
    // Sc: O(1)
    private static void printRowOptimal(int r) {
        long ele = 1;
        System.out.print(ele + " ");
        for (int i = 1; i < r; i++) {
            ele = ele * (r - i);
            ele = ele / i;
            System.out.print(ele + " ");    
        }
    }

    // Optimal approach to Print first n rows of Pascal's Triangle
    // Tc: O(n^2)
    // Sc: O(1)
    private static void printPascalTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            printRowOptimal(i);
            System.out.println();           
        }
    }
}
