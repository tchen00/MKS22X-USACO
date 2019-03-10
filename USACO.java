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

    int output = 0;
    for (int i = 1; i < pasture.length; i++){
      for (int j = 1; j < pasture[i].length; j++){
        if (pasture[i][j] > 0){
          output += pasture[i][j];
        }
      }
    }
    return output * 72 * 72;
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
