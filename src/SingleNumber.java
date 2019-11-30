public class SingleNumber {
    public static void main(String[] args) {
        int[] A = new int[]{
                25, 18, 37, 42, 25, 42, 18
        };

        int singleNumber = singleNumber(A);

        System.out.println("single number of A is: " + singleNumber);

        // -----------------------------------------

        int[] B = new int[]{
                1, 4, 2, 5, 5, 1, 4, 4, 1, 5
        };

        int singleNumber2 = singleNumber2(B);

        System.out.println("single number of B is: " + singleNumber2);
    }

    // 查找singleNumber, 线性时间复杂度，不使用额外空间
    private static int singleNumber(int[] A) {
        if (A.length == 1) {
            return A[0];
        }

        int result = A[0];

        // 使用异或运算的特点
        for (int i = 1; i < A.length; i++) {
            result = result ^ A[i];
        }

        return result;
    }

    // 查找singleNumber, 线性时间复杂度，不使用额外空间
    private static int singleNumber2(int[] A) {
        // 记录只出现过1次的bits
        int ones = 0;

        // 记录只出现过2次的bits
        int twos = 0;

        int threes;

        for (int t : A) {
            // 要在更新ones前面更新twos
            twos |= ones & t;

            ones ^= t;

            // ones和twos中都为1即出现了3次
            threes = ones & twos;

            // 抹去出现了3次的bits
            ones &= ~threes;

            twos &= ~threes;
        }

        return ones;
    }
}
