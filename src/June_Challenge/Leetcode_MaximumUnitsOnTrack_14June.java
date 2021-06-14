package June_Challenge;

import java.util.PriorityQueue;

public class Leetcode_MaximumUnitsOnTrack_14June {

    public static void main(String[] args) {
        int[][] boxes = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        int truckSize = 10;
        int res = maximumUnits(boxes, truckSize);
        System.out.println(res);
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int res = 0;

        for (int[] box : boxTypes) {
            queue.offer(box);
        }

        while (queue.size() > 0 && truckSize >= queue.peek()[0]) {
            int[] toq = queue.poll();
            truckSize = truckSize - toq[0];
            res += toq[0] * toq[1];
        }

        while (truckSize > 0) {
            if (queue.size() > 0) {
                if (queue.peek()[0] < truckSize) {
                    int[] toq = queue.poll();
                    truckSize = truckSize - toq[0];
                    res += toq[0] * toq[1];
                }else{
                    int[] toq = queue.poll();
                    truckSize = toq[0] - truckSize;
                    res += truckSize * toq[1];
                }
            }
        }
        return res;
    }
}
