import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        int[] ratings = new int[]{
                1, 4, 2, 5, 5, 1, 4, 4, 1, 5
//                4, 8, 3, 2, 5, 4, 2, 5, 1, 7
        };

        System.out.println("至少需要分 " + candy(ratings) + " 颗糖果");
    }

    private static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int length = ratings.length;
        int[] count = new int[length];
        int result = 0;

        // 每个孩 子至少一颗糖
        Arrays.fill(count, 1);

        // 正向比较
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }

        // 反向比较
        for (int i = length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1] && count[i] >= count[i - 1]) {
                count[i - 1] = count[i] + 1;
            }
        }

        for (int c : count) {
            result += c;
        }

        return result;
    }
}
