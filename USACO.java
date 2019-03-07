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
      int row = Integer.parseInt(stomp[0]);
      int col = Integer.parseInt(stomp[1]);
      int num = pasture[row][col];
      for (int i = 1; i + row < pasture.length; i++){
        for (int j = 1; j + col < pasture[i].length; j++){
          if (num < pasture[i][j]){
            pasture[i][j] = num;
          }
        }
      }
    }
    int output = 0;
    for (int i = 1; i < pasture.length; i++){
      for (int j = 1; j < pasture[i].length; j++){
        if (pasture[i][j] > 0){
          output += pasture[i][j];
        }
      }
    }
    return output * 6 * 6;
  }

  public static int silver(){
    return 0;
  }

  public static void main(String[] args){
    try {
      System.out.println(bronze("makelake.in"));
    }
    catch (Exception e){
      
    }
  }
}
