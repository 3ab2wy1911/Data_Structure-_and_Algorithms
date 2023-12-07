package Rotate_Image;
// LeetCode : 48. Rotate Image
class Solution {

    public void rotateDiagonaly(int[][] matrix){
        int n = matrix.length;
        for (int i=0;i<n;i++){
            for (int j=0;j<n-i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1] = temp;
            }
        }
    }

    public void rotateHorizontally(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=0; j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
    }

    public void rotate(int[][] matrix) {
        rotateDiagonaly(matrix);
        rotateHorizontally(matrix);
    }
}
