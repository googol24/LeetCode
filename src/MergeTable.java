import java.util.*;

public class MergeTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            // HashMap 是无序的 不能保证所有测试用例通过
            Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

            int rows = scanner.nextInt();

            for (int i = 0; i < rows; i++) {
//                String[] rowItem = scanner.nextLine().split(" ");
//                int key = Integer.parseInt(rowItem[0]);
//                int value = Integer.parseInt(rowItem[1]);
                int key = scanner.nextInt();
                int value = scanner.nextInt();

                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + value);
                } else {
                    map.put(key, value);
                }
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
