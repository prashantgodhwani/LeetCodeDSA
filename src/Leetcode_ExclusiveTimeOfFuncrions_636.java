import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Leetcode_ExclusiveTimeOfFuncrions_636 {

    public static void main(String[] args) {
        List<String> logs = List.of("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7");
        int[] res = exclusiveTime(2, logs);
        System.out.println(Arrays.toString(res));
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        int currStart = 0, lastThreadEnd = -1;

        for(String log : logs){
            System.out.println("*******************log = " + log);
            System.out.println(Arrays.toString(res));

            String[] arr = log.split(":");
            int thread = Integer.parseInt(arr[0]);
            String operation = arr[1];
            int time = Integer.parseInt(arr[2]);
            int[] el = new int[]{thread, time};

            if(operation.equals("start")){
                if(stack.size() == 0){
                    stack.push(el);
                    currStart = time;
                }else{
                    int[] tos = stack.peek();
                    res[tos[0]] += (time - currStart);
                    stack.push(el);
                    currStart = time;
                }
            }else{
                int[] tos = stack.pop();
                res[tos[0]] += (time - currStart + 1);
                currStart = time + 1;
            }
        }

        return res;
    }
}
