package June_Challenge;

import java.util.*;

public class Leetcode_MaximumPerformanceTeam_05June {

    public static void main(String[] args) {
        int[] speeds = {2,10,3,1,5,8};
        int[] eff = {5,4,3,9,7,2};
        int k = 5;
        int[][] dp = new int[speeds.length + 1][speeds.length + 1];
        int res = maxPerformance_memo(speeds, eff, k, "", 0, Integer.MAX_VALUE, 0, dp, 0);
        System.out.println(res);

        Leetcode_MaximumPerformanceTeam_05June l = new Leetcode_MaximumPerformanceTeam_05June();
        int ress = l.maxPerformance_priorityQueue(speeds, eff, k);
        System.out.println(ress);
    }

    class Engineer{
        private int speed;
        private int efficiency;

        Engineer(int s, int e){
            this.speed = s;
            this.efficiency = e;
        }
    }

    private int maxPerformance_priorityQueue(int[] speeds, int[] eff, int k) {
        List<Engineer> engineers = new ArrayList<>();
        for(int i = 0; i < speeds.length; i++){
            Engineer engineer = new Engineer(speeds[i], eff[i]);
            engineers.add(engineer);
        }

        Collections.sort(engineers, (e1, e2) -> e2.efficiency - e1.efficiency);
        PriorityQueue<Engineer> currentTeam = new PriorityQueue<>((e1, e2) -> e1.speed - e2.speed);

        long currentSpeed = 0;
        long maxPerformance = 0;
        for(Engineer engineer : engineers){

            if(currentTeam.size() == k){
                Engineer oldEngineer = currentTeam.poll();
                currentSpeed -= oldEngineer.speed;
            }

            currentTeam.add(engineer);
            currentSpeed += engineer.speed;

            long currentPerformance = currentSpeed * (long)engineer.efficiency;
            maxPerformance = Math.max(maxPerformance, currentPerformance);
        }

        return (int) (maxPerformance % 10_000_00007);
    }

    public static int maxPerformance_memo(int[] speed, int[] efficiency, int k, String asf, int idx, int min, int sum, int[][] dp, int lastIdx) {
        if(k == 0){
            return dp[idx][lastIdx] = Math.max(dp[idx][lastIdx], min * sum);
        }

        if(dp[idx][lastIdx] != 0 && dp[idx][lastIdx] > min*sum) return dp[idx][lastIdx];

        int res = min * sum;
        for(int i = idx; i < speed.length; i++){
            res = Math.max(res, maxPerformance_memo(speed, efficiency, k - 1, asf + speed[i] + "-", i+1, Math.min(min, efficiency[i]), sum + speed[i], dp, idx));
        }

        return dp[idx][lastIdx] = Math.max(dp[idx][lastIdx], res);
    }
}
