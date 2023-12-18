package SprialMatrix;

import java.util.ArrayList;
import java.util.List;

// LeetCode : 54. Spiral Matrix
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int c1 =0, c2 = matrix[0].length-1, r1 = 0, r2 = matrix.length-1;
        List<Integer> result = new ArrayList<>();

        while (c1 <= c2 && r1 <= r2){
            for (int i =c1; i<=c2;i++){ // add row 1...
                result.add(matrix[r1][i]);
            }
            ++r1;   // go to the second row...
            for (int i = r1; i<=r2;i++){    // add column 2
                result.add(matrix[i][c2]);
            }
            --c2;    // go to the perv col...
            if (c1 <= c2 && r1 <= r2){
                for (int i =c2; i>=c1;i--){ // add row 1
                    result.add(matrix[r2][i]);
                }
                r2--;   // go to the perv row...
                for (int i =r2; i>=r1;i--){ // add column 1
                    result.add(matrix[i][c1]);
                }
                ++c1;   // go to the next col...
            }
        }
        return result;
    }
}