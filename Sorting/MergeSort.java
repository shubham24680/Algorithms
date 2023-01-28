import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter array length: ");
            int n = scan.nextInt();
            System.out.println("Enter array element: ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = scan.nextInt();
            System.out.println("MERGE SORT");
            sorting(arr, 0, n - 1);
            print(arr, n);
        }
    }

    public static void sorting(int arr[], int beg, int end) {
        if (beg < end) {
            int mid = beg + (end - beg) / 2;
            sorting(arr, beg, mid);
            sorting(arr, mid + 1, end);
            merge(arr, beg, mid, end);
        }
    }

    public static void merge(int arr[], int beg, int mid, int end) {
        // Length of the two array.
        int l1, l2;
        l1 = mid + 1 - beg;
        l2 = end - mid;

        // Array's
        int a1[] = new int[l1];
        int a2[] = new int[l2];
        for (int i = 0; i < l1; i++)
            a1[i] = arr[beg + i];
        for (int i = 0; i < l2; i++)
            a2[i] = arr[mid + 1 + i];

        // Merging
        int i = 0, j = 0, k = beg;
        while (i < l1 && j < l2) {
            if (a1[i] < a2[j]) {
                arr[k++] = a1[i++];
            } else {
                arr[k++] = a2[j++];
            }
        }

        while (i < l1) {
            arr[k++] = a1[i++];
        }
        while (j < l2) {
            arr[k++] = a2[j++];
        }
    }

    public static void print(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
