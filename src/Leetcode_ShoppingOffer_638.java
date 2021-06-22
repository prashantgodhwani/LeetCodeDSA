import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_ShoppingOffer_638 {

    public static void main(String[] args) {
        List<Integer> prices = List.of(4, 3);
        List<Integer> needs = List.of(4, 5);
        List<List<Integer>> special = List.of(List.of(2, 2, 1), List.of(1, 1, 7), List.of(1, 1, 2), List.of(0, 1, 5));
        Map<String, Integer> dp = new HashMap<>();
        int ress = shoppingOffers_util(prices, special, needs, 0, prices.size(), dp);
        System.out.println(ress);

    }

    public static int shoppingOffers_util(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int idx, int n, Map<String, Integer> dp) {

        String key = needs.toString();
//        if (dp.containsKey(key)) {
//            System.out.println("returning output for key : " + key + " = " + dp.get(key));
//            return dp.get(key);
//        }

        int minCost = Integer.MAX_VALUE - 10000;
        first:
        for (int i = 0; i < special.size(); i++) {
            List<Integer> newNeeds = new ArrayList<>();
            List<Integer> curSpecial = special.get(i);
            for (int j = 0; j < price.size(); j++) {
                int d = needs.get(j) - curSpecial.get(j);
                if (d >= 0)
                    newNeeds.add(d);
                else continue first;
            }

            int r = shoppingOffers_util(price, special, newNeeds, i, n, dp);
            minCost = Math.min(minCost, r + special.get(i).get(n));
        }

        int mSum = 0;
        for (int k = 0; k < needs.size(); k++) {
            mSum += needs.get(k) * price.get(k);
        }

        dp.put(key, Math.min(mSum, minCost));
        System.out.println(key + ", " + Math.min(mSum, minCost) + ", mc = " + minCost + ", ms = " + mSum);
        return Math.min(mSum, minCost);
    }
}
