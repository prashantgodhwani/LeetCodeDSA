package June_Challenge;

import java.util.*;

public class Leetcode_MinumumNumberOfRefuellingStops_12June {

    public static void main(String[] args) {
        //{{25, 25}, {50, 25}, {75, 25}}
        //{{10, 60}, {20, 30}, {30, 30}, {60,40}}
        int[][] stations = {{41,42},{65,122},{141,176},{190,44},{221,36},{231,123},{281,135},{360,219},
                {363,161},{394,59},{477,83},{494,209},{523,41},{534,79},{546,81},{602,151},{623,179},{645,39},
                {647,109},{653,216},{707,165},{788,216},{824,214},{891,132},{987,69}};
        Arrays.sort(stations, (a, b) -> a[0] - b[0]);
        Map<String, Integer> map = new HashMap<>();
        int res = minRefuelStops(1000, 75, stations);
        System.out.println(res);
    }

    public static int minRefuelStops(int target, int currFuel, int[][] stations) {
        //retrieve station with max fuel - max heap bases on fuel
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int noOfStops = 0;
        int currLocation = currFuel;

        for(int[] station : stations){
            int fuelAtStation = station[1];
            int nextStationAt = station[0];

            //exhausted fuel
            while(currLocation < nextStationAt){
                if(pq.size() == 0) return -1;
                int maxFuel = pq.poll();
                currLocation = currLocation + maxFuel;
                noOfStops++;
            }
            pq.offer(fuelAtStation);
        }

        while(currLocation < target){
            if(pq.size() == 0) return -1;
            int maxFuel = pq.poll();
            currLocation = currLocation + maxFuel;
            noOfStops++;
        }

        return noOfStops;

    }

    public static int minRefuelStops_util(int target, int currFuel, int[][] stations, int idx, int lastMilestone, Map<String, Integer> dp, String asf) {

        if (target <= 0 || target <= currFuel) {
            String[] s = asf.split("_");
            System.out.println(asf + ":::" + s.length);
            return 0;
        }

        if(dp.containsKey(target +"_" + currFuel)) return dp.get(target +"_" + currFuel);

        int minStops = Integer.MAX_VALUE;
        for (int i = idx; i < stations.length; i++) {
            int tempMin = Integer.MAX_VALUE;
            if(currFuel  + lastMilestone >= stations[i][0]) {
                int fuelAtThisPoint = currFuel - (stations[i][0] - lastMilestone);
                if (fuelAtThisPoint + stations[i][1] > 0) {
                    int c = minRefuelStops_util(target - (stations[i][0] - lastMilestone), fuelAtThisPoint + stations[i][1], stations, i + 1, stations[i][0], dp,
                            asf + stations[i][0] + "_");
                    tempMin = (c == Integer.MAX_VALUE) ? c : c + 1;
                }
                if (fuelAtThisPoint > 0) {
                    tempMin = Math.min(tempMin, minRefuelStops_util(target, fuelAtThisPoint, stations, i + 1, lastMilestone, dp, asf));
                }
            }

            minStops = Math.min(minStops, tempMin);
        }

        dp.put(target +"_" + currFuel, minStops);
//        System.out.println(minStops);
        return minStops;
    }

}
