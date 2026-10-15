class Solution {

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSet = new HashSet[9];
        HashSet<Character>[] colSet = new HashSet[9];
        HashSet<Character>[] squareSet = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            squareSet[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {         // rows
            for (int j = 0; j < 9; j++) {     // columns
                char ch = board[i][j];

                if (ch == '.') continue;
                if (!rowSet[i].add(ch)) return false;
                if (!colSet[j].add(ch)) return false;
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (!squareSet[boxIndex].add(ch)) return false;
            }
        }

        return true;
    }
}
