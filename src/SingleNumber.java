public class SingleNumber {
    public static void main(String[] args) {
        int[] A = new int[] {
                25, 18, 37, 42, 25, 42, 18
        };

        int singleNumber = singleNumber(A);

        System.out.println("single number is:" + singleNumber);
    }

    // 查找singleNumber, 线性时间复杂度，不使用额外空间
    private static int singleNumber(int[] A) {
        if (A.length == 1) {
            return A[0];
        }

        int result = A[0];

        // 使用亦或运算的特点
        for (int i = 1; i < A.length; i++) {
            result = result ^ A[i];
        }

        return result;
    }
}
