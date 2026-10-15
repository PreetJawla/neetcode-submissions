class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    graphTraverse(grid, i, j);
                }
            }
        }
        return count;
    }

    public void graphTraverse(char[][] grid, int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '*' || grid[i][j] == '0')return;
        grid[i][j] = '*';
        graphTraverse(grid, i+1, j);
        graphTraverse(grid, i-1, j);
        graphTraverse(grid, i, j+1);
        graphTraverse(grid, i, j-1);
    }
}
