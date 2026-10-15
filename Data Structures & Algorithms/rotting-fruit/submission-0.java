
class Solution {
    int totalTime = 0;
    int tROranges = 0;

    public int orangesRotting(int[][] grid) {
        int tFOranges = 0;
        Queue<int[]> rottenOranges = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    tFOranges++;
                } else if (grid[i][j] == 2) {
                    rottenOranges.add(new int[]{i, j});
                }
            }
        }

        if (tFOranges == 0) return 0;

        BFS(rottenOranges, grid, grid.length, grid[0].length);

        return (tROranges == tFOranges) ? totalTime : -1;
    }

    public void BFS(Queue<int[]> rottenOranges, int[][] grid, int n, int m) {
        if (rottenOranges.isEmpty()) return;

        Queue<int[]> temp = new LinkedList<>();

        while (!rottenOranges.isEmpty()) {
            int[] curr = rottenOranges.remove();
            int row = curr[0], col = curr[1];

            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                temp.add(new int[]{row - 1, col});
                grid[row - 1][col] = 2;
                tROranges++;
            }
            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                temp.add(new int[]{row, col - 1});
                grid[row][col - 1] = 2;
                tROranges++;
            }
            if (row + 1 < n && grid[row + 1][col] == 1) {
                temp.add(new int[]{row + 1, col});
                grid[row + 1][col] = 2;
                tROranges++;
            }
            if (col + 1 < m && grid[row][col + 1] == 1) {
                temp.add(new int[]{row, col + 1});
                grid[row][col + 1] = 2;
                tROranges++;
            }
        }

        if (!temp.isEmpty()) {
            totalTime++; 
            BFS(temp, grid, n, m);
        }
    }
}
