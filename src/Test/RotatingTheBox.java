package Test;

import java.util.Arrays;

public class RotatingTheBox {

    public static void main(String[] args) {
        char[][] box = {
                {'#','#','*','.','*','.'},
                {'#','#','#','*','.','.'},
                {'#','#','#','.','#','.'}
        };

        char[][] res = rotateTheBox(box);
        for(char[] c : res){
            System.out.println(Arrays.toString(c));
        }
    }

    public static char[][] rotateTheBox(char[][] box) {
        char[][] res = new char[box[0].length][box.length];

        for(int i = 0; i < box.length; i++){
            //find stones
            int stones = 0;
            for(int j = 0; j < box[0].length; j++){
                if(box[i][j] == '#'){
                    stones++;
                    box[i][j] = '.';
                }
//                System.out.println("stones = " + stones + ", cond = " + (j == box[0].length - 1));
                if(box[i][j] == '*'){
                    //sort stones
                    int k = j - 1;
                    while(stones > 0){
                        box[i][k] = '#';
                        k--;
                        stones--;
                    }
                }else if(j == box[0].length - 1){
                    int k = j;
                    while(stones > 0){
                        box[i][k] = '#';
                        k--;
                        stones--;
                    }
                }
            }
        }

        for(int i = box.length - 1, k = 0; i >= 0; i--, k++){
           for(int j = 0; j < box[0].length; j++){
               res[j][k] = box[i][j];
           }
        }

        return res;
    }
}
