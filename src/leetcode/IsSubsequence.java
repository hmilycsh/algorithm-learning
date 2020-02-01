package leetcode;

import java.time.LocalDate;
import java.util.Date;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if(s == null || t.length()< s.length()){
            return false;
        }

        int prev = 0;
        for(int i = 0;i<s.length();i++){
            char tmp = s.charAt(i);
            prev = t.indexOf(tmp,prev);
            if(prev == -1){
                return false;
            }
            prev++;
        }

        return true;

    }


    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Friday", "Saturday","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",};
        int[] daysOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int num = 0;
        for(int i = 1971;i<year;i++){
            if(isLeap(i)) num += 366;
            else num += 365;
        }

        if(isLeap(year)) daysOfMonth[1]=29;
        for(int i = 0;i<month-1;i++){
            num += daysOfMonth[i];
        }

        num += (day-1);
        return week[ num % 7];

    }


    public boolean isLeap(int year){
        return (year % 400 ==0) || (year % 100 != 0 && year % 4 ==0);
    }

    public static void main(String[] args) {
        IsSubsequence obj = new IsSubsequence();
        System.out.println(obj.dayOfTheWeek(31,8,2019));
    }





    public String tictactoe(int[][] moves) {
        String result = "Draw";
        String[][] grid = new String[3][3];

        //setting initial values
        for(int i = 0; i < 3; i++ )
            for(int j = 0; j < 3; j++)
                grid[i][j] = "";


        for(int i = 0; i < moves.length; i++ ){
            int[] move = moves[i];
            grid[move[0]][move[1]] = i % 2 ==0 ? "A" : "B";
        }

        for(int i = 0; i < 3; i++ ){
            if(!grid[i][0].equals("") && grid[i][0].equals(grid[i][1]) && grid[i][0].equals(grid[i][2]))
                return grid[i][0];
            if(!grid[0][i].equals("") && grid[0][i].equals(grid[1][i]) && grid[0][i].equals(grid[2][i]))
                return grid[0][i];
        }

        //checking diagonal winners
        if(!grid[0][0].equals("") && grid[0][0].equals(grid[1][1]) && grid[0][0].equals(grid[2][2]))
            return grid[0][0];
        if(!grid[0][2].equals("") && grid[0][2].equals(grid[1][1]) && grid[0][2].equals(grid[2][0]))
            return grid[0][2];


        if(moves.length < 9) return "Pending";

        return result;
    }
}
