import java.util.*;

public class ApproximateInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            double number = scanner.nextDouble();
            System.out.println(Math.round(number));
        }
    }
}
