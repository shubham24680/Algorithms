import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter array length: ");
            int n = scan.nextInt();
            System.out.println("Enter array element: ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = scan.nextInt();
            System.out.println("BUBBLE SORT");
            sorting(arr, n);
            print(arr, n);
        }
    }

    public static void sorting(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
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
