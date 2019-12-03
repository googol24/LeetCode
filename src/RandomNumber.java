import java.util.*;

public class RandomNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            int[] inputArray = new int[n];

            for (int i = 0; i < n; i++) {
                inputArray[i] = scanner.nextInt();
            }

            solve(inputArray);
        }


    }

    // 处理去重以及排序
    private static void solve(int[] inputArray) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        // 去重
        for (int i = 0; i < inputArray.length; i++) {
            int value = inputArray[i];
            if (!result.contains(value)) {
                result.add(value);
            }
        }

        // 排序
        Collections.sort(result);

        // 输出
        for (int number : result) {
            System.out.println(number);
        }
    }
}
