import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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
        findMedian(arr);
        
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

    // Selection Sort implementation
    public static int findMedian(List<Integer> arr) {
    // Write your code here
        int length = arr.size();
        for (int i = 0; i < length - 1; i++) {
            // Find the minimum element in the unsorted array
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr.get(j) < arr.get(minIndex)) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr.get(minIndex);
            arr.set(minIndex,arr.get(i));
            arr.set(i,temp);
        }

        if (length%2==0){
            return ((arr.get(length/2-1)+arr.get(length/2))/2);
        } else {
            return (arr.get(length/2));
        }
    }
}