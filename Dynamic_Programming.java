import java.io.File;
import java.util.*;

public class Dynamic_Programming {

    public static void main(String[] args) {


        int[][] maze = null;
        int[] sizes = new int[2];
        int[] goal = new int[2];

        try {
            File myObj = new File(args[0]);
            Scanner myReader = new Scanner(myObj);

            String strSize = myReader.nextLine();
            String[] strSizeArray = strSize.split(" ");
            sizes[0]= Integer.parseInt(strSizeArray[0]);
            sizes[1] = Integer.parseInt(strSizeArray[1]);

            maze = new int[sizes[0]][sizes[1]];
            for(int i = 0 ; i<sizes[0];i++){
                String mazeRow = myReader.nextLine();
                String[] mazeRowArray = mazeRow.split(" ");
                int columnIndex = 0;
                for(String value : mazeRowArray){
                    maze[i][columnIndex] = Integer.parseInt(value);
                    columnIndex +=1;
                }
            }

            String goalLine = myReader.nextLine();
            String[] goalArray = goalLine.split(" ");
            goal[0] = Integer.parseInt(goalArray[0]);
            goal[1] = Integer.parseInt(goalArray[1]);


            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(solve(maze,goal,sizes));

    }

    public static int solve(int[][] maze, int[] goal, int[] sizes) {

        int table[][] = new int[sizes[0]+1][sizes[1]+1];

        table[1][1] = 1;

        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                if(i==1 && j==1) continue;

                if(maze[i-1][j-1] == 0){
                    table[i][j] = table[i-1][j] + table[i][j-1];
                }
            }
        }

        return table[goal[0]+1][goal[1]+1];
    }
}
