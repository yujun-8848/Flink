package leetcode.cn.Arrays;

public class SearchMatrix {

    public static boolean searchMatrix(int[][] matrix,int target){
        int row = matrix.length -1;
        int col = 0;
        while (row >0 && col < matrix[0].length){
            if(matrix[row][col] < target){
                col++;
            }else if(matrix[row][col] > target){
                row--;
            }else {
                return true;
            }
        }
        return false;
    }
}
