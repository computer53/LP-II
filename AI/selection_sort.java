import java.util.Scanner;

public class SelectionSort {
    // Selection Sort function to sort in ascending order and show every iteration
    public static void sel(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minPosition = i;  // Find the minimum value
            for (int j = i + 1; j < a.length; j++) {
                if (a[minPosition] > a[j]) {
                    minPosition = j;
                }
            }
            
            // Swap if minPosition is not the current index i
            int temp = a[minPosition];
            a[minPosition] = a[i];
            a[i] = temp;
            
            // Show the array after each iteration
            System.out.print("Iteration " + (i + 1) + ": ");
            for (int k = 0; k < a.length; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();  // For a newline after printing the array
        }
        
        // Print the sorted array
        System.out.println("Sorted Array:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();  // For a newline after printing the array
    }
    
    // Function to take input for array
    public static int[] Arr() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int size = sc.nextInt();
        int[] n = new int[size];
        
        for (int i = 0; i < n.length; i++) {
            System.out.println("Enter element at index " + i + ": ");
            n[i] = sc.nextInt();
        }
        
        // Print the unsorted array
        System.out.println("Unsorted Array:");
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }
        System.out.println();  // For a newline after printing the unsorted array
        return n;
    }

    public static void main(String[] args) {
        int[] a = Arr();  // Get the array from user input
        sel(a);            // Sort and display the array with iterations
    }
}
