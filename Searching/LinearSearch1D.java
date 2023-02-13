import java.util.Scanner;

class LinearSearch1D {
    static Scanner scan = new Scanner(System.in);

    static void search(int arr[], int e, int x, int n) {
        if (x == n) {
            System.out.println("Element not found.");
            return;
        }

        if (arr[x] == e) {
            System.out.println("Element is found at " + (x+1));
            return;
        }
        search(arr, e, x + 1, n);
    }

    public static void main(String[] args) {
        System.out.print("Enter the length: ");
        int n = scan.nextInt();

        System.out.println("Enter the array elements: ");
        int i, arr[] = new int[n];
        for (i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        System.out.print("Enter element you want to search: ");
        int e = scan.nextInt();

        System.out.println("Searching........");
        search(arr, e, 0, n);
    }
}