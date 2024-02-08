public class Search {

    public static void main(String[] args) {
      int a[] = { 1, 4, 6, 8, 9, 34, 56, 78, 100 };
      FibonacciSearch search = new FibonacciSearch();
      System.out.println(search.iterative(a, 0, a.length, 100));
    }
  }
