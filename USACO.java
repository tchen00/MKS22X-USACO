import java.util.*;
import java.io.*;

public class USACO{
  public static int bronze(String input) throws FileNotFoundException{
    File f = new File(input);
    Scanner scan = new Scanner(f);

    // get the first line of the input file
    String[] info = scan.nextLine().split(" ");
    // using the info just received make the pasture array
    int[][] pasture = new int[Integer.parseInt(info[0])][Integer.parseInt(info[1])];

    // add elevations info into the pasture array
    for (int i = 0; i < pasture.length; i++){
      String[] elevations = scan.nextLine().split(" ");
      for (int j = 0; j < elevations.length; j++){
        pasture[i][j] = Integer.parseInt(elevations[j]);
      }
    }
    // performing the stomp by cows
    while (scan.hasNextLine()){
      String[] stomp = scan.nextLine().split(" ");
      int row = Integer.parseInt(stomp[0]) - 1;
      int col = Integer.parseInt(stomp[1]) - 1;
      int level = Integer.parseInt(stomp[2]);
      //int num = pasture[row][col];
      ArrayList<Integer> store = new ArrayList<>();
      for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
          store.add(pasture[row + i][col + j]);
        }
      }
      // got help for this; finds the max between the 9 coordinates
      int target = Collections.max(store) - level;
      for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
          // if elevation is greater than the target
          if (pasture[row + i][col + j] > target) pasture[row + i][col + j] = target;
        }
      }
    }
    int level = Integer.parseInt(info[2]);
    int output = 0;
    for (int i = 0; i < pasture.length; i++){
      for (int j = 0; j < pasture[i].length; j++){
        if (pasture[i][j] > level) pasture[i][j] = 0;
        else {
          pasture[i][j] = level - pasture[i][j];
          output += pasture[i][j];
        }
      }
    }
    return output * 72 * 72;
  }

  public static int silver(String file) throws FileNotFoundException{
    File f = new File(file);
    Scanner scan = new Scanner(f);
    String[] info = scan.nextLine().split(" ");
    int row = Integer.parseInt(info[0]);
    int col = Integer.parseInt(info[1]);
    int time = Integer.parseInt(info[2]);

    int[][] pasture = new int[row][col];
    // filling in the pasture with info
    for (int i = 0; i < row; i++){
      String temp = scan.nextLine();
      for (int j = 0; j < col; j++){
        if (temp.charAt(j) == '*') {
          // put trees as -1
          pasture[i][j] = -1;
        }
      }
    }

    // splitting the info in the last line
    String[] info2 = info.nextLine().split(" ");
    int R1 = Integer.parseInt(info2[0]) - 1;
    int C1 = Integer.parseInt(info2[1]) - 1;
    int R2 = Integer.parseInt(info2[2]) - 1;
    int C2 = Integer.parseInt(info2[3]) - 1;

    // set R1 + C1 to 1 and fill in the rest of the board
    pasture[R1][C1] = 1;
    for (int i = 0; i < time; i++){
      pasture = fillIn(pasture);
    }
    return pasture[R2][C2];
  }




  public static boolean outOfBounds(int[][] pasture, int row, int col){
    // to check if out of bounds or if theres a tree
    return row < 0 || col < 0 || row >= pasture.length || col >= pasture[0].length || pasture[row][col] == -1;
  }

  public static void main(String[] args){
    try {
      System.out.println(bronze("makelake.in"));
    }
    catch (Exception e){

    }
  }
}
