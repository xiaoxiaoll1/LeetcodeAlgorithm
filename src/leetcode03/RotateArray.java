package leetcode03;

public class RotateArray {
    public void rotate(int[][] matrix) {
        int top = 0;
        int left = 0;
        int right = matrix.length-1;
        int bottom = matrix.length-1;
        int n = matrix.length-1;
        while (n>0) {
            for (int i = 0; i < n; i++) {
                int tmp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = tmp;
            }
            top++;
            bottom--;
            left++;
            right--;
            n-=2;
        }
    }
}
