public class GasStation {
    public static void main(String[] args) {
        int[] gas = new int[] {10, 20, 10, 5, 4};
        int[] cost = new int[] {15, 12, 10, 4, 6};

        System.out.println("出发位置为: " + canCompleteCircuit(gas, cost));
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;// 加油站数量
        int sum = 0; // 油箱中剩余的油数量
        int total = 0; // 环路耗油量
        int index = 0;// 出发位置

        for (int i = 0; i < n; i++){
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];

            if (sum < 0){
                sum = 0;
                index = i + 1;
            }
        }

        return total >= 0? index: -1;
    }
}
