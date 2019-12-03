import java.util.*;

public class PrimeFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            long number = scanner.nextLong();

            ArrayList<Integer> factors = getResult(number);

            for (int factor : factors) {
                System.out.print(factor + " ");
            }
        }
    }

    private static ArrayList<Integer> getResult(long number) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int factor = 2;

        while (factor <= number) {
            if (number % factor == 0) {
                result.add(factor);
                number = number / factor;
            } else {
                factor++;
            }
        }

        return result;
    }
}
