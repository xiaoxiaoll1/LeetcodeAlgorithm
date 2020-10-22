package leetcode04;

public class WordSearch {
    public boolean exist(char[][] board, String word) {

        boolean[][] used = new boolean[board.length][board[0].length];
        char[] charArray = word.toCharArray();

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                boolean b = existHelper(used, board, 0, charArray, row, column);
                if(b){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existHelper(boolean[][] used,char[][] board,int index, char[] charArray, int row, int column){
        if(index>=charArray.length)return true;
        if(row<0||row>=board.length||column<0||column>=board[0].length)return false;
        if(used[row][column]==true||board[row][column]!=charArray[index])return false;

        used[row][column]=true;
        boolean b = existHelper(used, board, index + 1, charArray, row + 1, column);
        if(b) return true;
        boolean c = existHelper(used, board, index + 1, charArray, row - 1, column);
        if(c) return true;
        boolean d = existHelper(used, board, index + 1, charArray, row, column +1);
        if(d) return true;
        boolean e = existHelper(used, board, index + 1, charArray, row, column-1);
        if(e) return true;
        used[row][column]=false;
        return false;

    }


}
