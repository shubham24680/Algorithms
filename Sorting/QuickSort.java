import java.util.Scanner;

// Time complexity : O(n*log(n))
public class QuickSort {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter array length: ");
            int n = scan.nextInt();
            System.out.println("Enter array element: ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = scan.nextInt();
            System.out.println("QUICK SORT");
            sorting(arr, 0, n - 1);
            print(arr, n);
        }
    }

    public static void sorting(int arr[], int beg, int end) {
        if (beg < end) {
            int p = pivot(arr, beg, end);
            sorting(arr, beg, p - 1);
            sorting(arr, p + 1, end);
        }
    }

    public static int pivot(int arr[], int beg, int end) {
        int p, i = beg - 1, swap;
        p = arr[end];
        for (int j = beg; j < end; j++) {
            if (arr[j] < p) {
                i++;
                swap = arr[j];
                arr[j] = arr[i];
                arr[i] = swap;
            }
        }
        swap = arr[end];
        arr[end] = arr[i + 1];
        arr[i + 1] = swap;
        return (i + 1);
    }

    public static void print(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
