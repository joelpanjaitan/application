import java.util.Scanner;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class ManualSortMedianFinder {
    public static void main(List<Integer> arr) {
        // Scanner scanner = new Scanner(System.in);
        
        // System.out.print("Enter the number of elements: ");
        // int n = scanner.nextInt();
        // double[] numbers = new double[n];

        // System.out.println("Enter " + n + " numbers:");
        // for (int i = 0; i < n; i++) {
        //     numbers[i] = scanner.nextDouble();
        // }

        // Sort the array using Selection Sort
        //findMedian(arr);
        lonelyinteger(arr);
        // Find the median
        // double median;
        // if (n % 2 == 0) {
        //     // If even, average the two middle numbers
        //     median = (numbers[n / 2 - 1] + numbers[n / 2]) / 2.0;
        // } else {
        //     // If odd, take the middle number
        //     median = numbers[n / 2];
        // }

        // System.out.println("Sorted numbers: ");
        // for (double number : numbers) {
        //     System.out.print(number + " ");
        // }
        // System.out.println("\nMedian: " + median);
        
        // scanner.close();
    }

    public static int lonelyinteger(List<Integer> a) {
    // Write your code here
        Set<Integer> uniqueIntegers = new HashSet<>();
        Set<Integer> duplicateIntegers = new HashSet<>();
        
        // magazineCount ={}
        for (int b=0;b<a.size();b++ ){
            if (!uniqueIntegers.add(a.get(b))) {
                duplicateIntegers.add(a.get(b));
            }   
        }
        System.out.println(duplicateIntegers);
        return 0;
    }

    // Selection Sort implementation
    public static int findMedian(List<Integer> arr) {
    // Write your code here
        int length = arr.size();
        for (int k = 0; k < length - 1; k++) {
            // Find the minimum element in the unsorted array
            int minIndex = k;
            for (int j = k + 1; j < length; j++) {
                // if bigger change minindex to beside
                if (arr.get(j) < arr.get(minIndex)) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr.get(minIndex);
            // set the right index to larger 
            arr.set(minIndex,arr.get(k));
            // set the left index to smaller
            arr.set(k,temp);
        }

        if (length%2==0){
            return ((arr.get(length/2-1)+arr.get(length/2))/2);
        } else {
            return (arr.get(length/2));
        }
    }
}