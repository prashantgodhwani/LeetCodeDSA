import java.util.Arrays;
import java.util.Stack;

public class Leetcode_Asteroid_Collision_735 {

    public static void main(String[] args) {
        int[] res = asteroidCollision(new int[]{-2,-2, 2,1,-2});
        System.out.println("==> " + Arrays.toString(res));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        first:
        for(int i = 0; i < asteroids.length; i++){
            System.out.println(stack);

            if(stack.size() > 0){
                if(-asteroids[i] == stack.peek() && asteroids[i] < 0){
                    stack.pop();
                }else{
                    if(asteroids[i] < 0){
                        int val = asteroids[i];
                        while(stack.size() > 0 && stack.peek() > 0){
                            int tos = stack.pop();
                            if(tos > -val){
                                stack.push(tos);
                                continue first;
                            }else if(tos == -val) continue first;
                        }
                        stack.push(asteroids[i]);
                    }else{
                        stack.push(asteroids[i]);
                    }
                }
            }else{
                stack.push(asteroids[i]);
            }
        }

        int[] res = new int[stack.size()];
        int k = 0;
        while(stack.size() > 0){
            res[res.length - k - 1] = stack.pop();
            k++;
        }

        return res;
    }
}
