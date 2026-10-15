// class Solution {
//     public int maxAreaOfIsland(int[][] grid) {
        
//     }
// }
class Solution {
    public int count = 0;
    public int tempCount = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    tempCount =0;
                    graphTraverse(grid, i, j);
                    count = Math.max(count, tempCount);
                }
            }
        }
        return count;
    }

    public void graphTraverse(int[][] grid, int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)return;
        grid[i][j] = 0;
        tempCount++;
        graphTraverse(grid, i+1, j);
        graphTraverse(grid, i-1, j);
        graphTraverse(grid, i, j+1);
        graphTraverse(grid, i, j-1);
    }
}
