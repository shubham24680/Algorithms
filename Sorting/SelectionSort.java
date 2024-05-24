import java.util.Scanner;

// Time complexity: O(n^2)
public class SelectionSort {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter the array length: ");
            int n = scan.nextInt();
            System.out.println("Enter array elements: ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = scan.nextInt();
            System.out.println("SELECTION SORT");
            sorting(arr, n);
            print(arr, n);
        }
    }

    public static void sorting(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    int swap = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swap;
                }
            }
        }
    }

    public static void print(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
