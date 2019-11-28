import java.util.HashMap;
import java.util.Map;

class Point {

    int x;

    int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + this.x + ", y = " + this.y;
    }
}

public class MaxPointsOnALine {
    // 计算二维平面上共线的点数的最大值
    public static void main(String[] args) {
        Point[] points = new Point[]{
                new Point(1, 0),
                new Point(1, -2),
                new Point(2, 1),
                new Point(2, -7),
                new Point(4, 3),
                new Point(4, 9),
                new Point(6, 5),
                new Point(7, 9),
                new Point(8, 7),
                new Point(9, 2)
        };

        System.out.println(maxPoints(points));
    }

    private static int maxPoints(Point[] points) {

        if (points == null) return 0;

        if (points.length <= 2) return points.length;

        int result = 0;

        for (int i = 0; i < points.length; i++) {

            Map<Float, Integer> map = new HashMap<>();

            // 重合点数
            int same = 0;

            // 垂直共线点数
            int vertical = 0;

            Point p = points[i];

            for (int j = 0; j < points.length; j++) {

                if (i == j) continue;

                Point q = points[j];

                if (p.x == q.x) {
                    if (p.y == q.y) same++;
                    else vertical++;
                } else {
                    float k = (float) (p.y - q.y) / (p.x - q.x);
                    map.put(k, map.get(k) == null ? 1 : map.get(k) + 1);
                }
            }

            // 初始化最多的点是垂直共线的点数
            int tempMax = vertical;

            // 比较选出最大值
            for (Float k : map.keySet()) {
                tempMax = tempMax > map.get(k) ? tempMax : map.get(k);
            }

            // +1是因为还需要计入点本身
            result = result > tempMax + same + 1 ? result : tempMax + same + 1;
        }

        return result;
    }
}
