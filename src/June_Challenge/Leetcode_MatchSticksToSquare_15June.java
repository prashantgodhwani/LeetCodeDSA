package June_Challenge;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode_MatchSticksToSquare_15June {

    static int possibleSide = 0;
    static int perimeter = 0;
    public static List<Integer> nums;

    public static void main(String[] args) {
        int[] matchSticks = {1,1,2,2,2};
        System.out.println(makesquare(matchSticks));
    }

    public static boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) return false;
        perimeter = Arrays.stream(matchsticks).sum();
        possibleSide = perimeter / 4;
        if (possibleSide * 4 != perimeter) return false;
        nums = Arrays.stream(matchsticks).boxed().collect(Collectors.toList());
        Collections.sort(nums, Collections.reverseOrder());
        System.out.println(nums.size());
        boolean res = makesquare_util(0, 0, 0, 0, 0);
        return res;
    }

    public static boolean makesquare_util(int sideA, int sideB, int sideC, int sideD, int idx) {
        System.out.println(sideA + "-" +sideB + "-" +sideC + " perimter = " + perimeter + " sideD = " + sideD +" idx = " + idx);

        if(idx == nums.size()){
            if(sideA != 0 && sideA == sideB && sideB == sideC && sideC == sideD) {
                System.out.println(sideA + "-" + sideB + "-" + sideC + "-" + sideD);
                return true;
            }
            return false;
        }

        boolean res = false;
        int element = nums.get(idx);

        if(sideA + element <= possibleSide){
            res = makesquare_util(sideA + element, sideB, sideC, sideD, idx + 1);
            if(res) return true;
        }

        if(sideB + element <= possibleSide){
            res = makesquare_util(sideA, sideB + element, sideC,sideD, idx + 1);
            if(res) return true;
        }

        if(sideC + element <= possibleSide){
            res = makesquare_util(sideA, sideB, sideC + element,sideD, idx + 1);
            if(res) return true;
        }

        if(sideD + element <= possibleSide){
            res = makesquare_util(sideA, sideB, sideC, sideD + element,idx + 1);
            if(res) return true;
        }

        return false;

    }
}
