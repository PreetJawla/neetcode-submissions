class Solution {
    public boolean exist(char[][] board, String word) {
        return backTrack(board, word);
    }
    public boolean backTrack(char[][] board, String word){
        int index = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0 ; j< board[0].length; j++){
                if((board[i][j] == word.charAt(0)) && searchNeighbour(i, j, 0, word, board)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchNeighbour(int i, int j, int index, String word, char[][] board){
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i>= board.length || j >= board[0].length || board[i][j] =='*'  ) return false;
        if(word.charAt(index) != board[i][j]) return false;
        char ch = board[i][j];
        board[i][j] = '*';
        if(searchNeighbour(i-1,j,index+1,word,board)||
        searchNeighbour(i+1,j,index+1,word,board)||
        searchNeighbour(i,j-1,index+1,word,board)||
        searchNeighbour(i,j+1,index+1,word,board)) return true;

        board[i][j] = ch;
        return false;
    }
}
