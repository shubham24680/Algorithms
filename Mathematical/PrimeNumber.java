import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
      new InputStreamReader(System.in)
    );
    System.out.print("Enter a number: ");
    int n = Integer.parseInt(reader.readLine());
    System.out.println(isPrime(n) ? "Prime number" : "Composite number");
  }

  public static boolean isPrime(int n) {
    if (n == 2 || n == 3) return true;
    if (n < 2 || n % 2 == 0 || n % 3 == 0) return false;

    for (int i = 5; i < Math.sqrt(n); i += 6) {
      if (n % i == 0 || n % (i + 2) == 0) return false;
    }

    return true;
  }
}
