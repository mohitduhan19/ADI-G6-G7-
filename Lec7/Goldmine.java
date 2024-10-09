package Lec7;

public class Goldmine {
    public static int getMaximumGold(int[][] board) {

        max=0;

        boolean[][] tracker = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                helper(board, tracker, i, j, 0);
            }

        }

        return max;
    }

    static int max = 0;

    public static void helper(int[][] board, boolean[][] tracker, int row, int col, int amount) {

        if (amount > max)
            max = amount;

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || tracker[row][col]
                || board[row][col] == 0)
            return;

        tracker[row][col] = true;

        // right
        helper(board, tracker, row, col + 1, amount + board[row][col]);

        // bottom
        helper(board, tracker, row + 1, col, amount + board[row][col]);

        // left
        helper(board, tracker, row, col - 1, amount + board[row][col]);

        // up
        helper(board, tracker, row - 1, col, amount + board[row][col]);

        tracker[row][col] = false;

    }
}
