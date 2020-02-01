package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MagicSquare {

    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        int row = grid.length, col = grid[0].length;

        for(int r = 0; r < row - 2; r++){
            for(int c = 0; c < col -2; c++){
                if(isMagicSquare(r,c,grid)){
                    result++;
                }
            }
        }
        return result;
    }


    public boolean isMagicSquare(int i,int j,int[][] grid){
        if(grid[i+1][j+1] != 5){return false;}

        //每个格子数字不一样
        int[] count = new int[10];
        for(int r = i; r <= i + 2; r++){
            for(int c = j; c <= j+2; c++){
                if(grid[r][c] > 9){
                    return false;
                }else{
                    count[grid[r][c]]++;
                }
            }
        }
        for(int k = 1;k<=9;k++){
            if(count[k] < 1){
                return false;
            }
        }

        //横&竖
        int s1 = grid[i][j]+grid[i][j+1]+grid[i][j+2];
        int s2 = grid[i][j]+grid[i+1][j]+grid[i+2][j];

        //对角
        int s3 = grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2];
        int s4 = grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j];


        if(s1 == s2 && s1 == s3 && s3 == s4){
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        MagicSquare ms = new MagicSquare();
        int[][] a= new int[][]{{3,2,9,2,7},{6,1,8,4,2},{7,5,3,2,7},{2,9,4,9,6},{4,3,8,2,5}};
        int result  = ms.numMagicSquaresInside(a);
        System.out.println(result);
    }

}
