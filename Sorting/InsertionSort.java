import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter array length: ");
            int n = scan.nextInt();
            System.out.println("Enter array element: ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = scan.nextInt();
            System.out.println("INSERTION SORT");
            sorting(arr, n);
            print(arr, n);
        }
    }

    public static void sorting(int arr[], int n) {
        int res, j;
        for (int i = 1; i < n; i++) {
            res = arr[i];
            j = i - 1;
            while (0 <= j && res <= arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = res;
        }
    }

    public static void print(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
