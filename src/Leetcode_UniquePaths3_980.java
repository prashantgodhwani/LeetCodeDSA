public class Leetcode_UniquePaths3_980 {
    public static void main(String[] args) {
        int[][] maze = {
                {0,1},
                {2,0}
        };
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                if(maze[i][j] == 1) {
                    int res = findPaths(maze, i,j, "", 0);
                    System.out.println(res);
                    return;
                }
            }
        }
    }

        private static int findPaths(int[][] maze, int r, int c, String path, int count){
    //        System.out.println("r = " + r+ ", c = " + c + ", path = " + path);
            if(maze[r][c] == 2){
                path += "("+r+","+c+")";
                if(isFilled(maze)) {
                    System.out.println("******** " + path);
                    count++;
                }
                return count;
            }

            maze[r][c] = -1;
            //go top
            if(r - 1 >= 0 && maze[r-1][c] != -1){
                count = findPaths(maze, r-1, c, path + "("+r+","+c+"), ", count);
            }

            //go left
            if(c - 1 >= 0 && maze[r][c-1] != -1){
                count = findPaths(maze, r, c-1, path + "("+r+","+c+"), ", count);
            }

            //go right
            if(c + 1 < maze[0].length && maze[r][c+1] != -1){
                count = findPaths(maze, r, c+1, path + "("+r+","+c+"), ", count);
            }

            //go down
            if(r + 1 < maze.length && maze[r+1][c] != -1){
                count = findPaths(maze, r+1, c, path + "("+r+","+c+"), ", count);
            }

            maze[r][c] = 0;

            return count;
        }


        private static boolean isFilled(int[][] maze){
            for(int i = 0; i < maze.length; i++){
                for(int j = 0; j < maze[0].length; j++){
                    if(maze[i][j] == 0) return false;
                }
            }
            return true;
        }
}
