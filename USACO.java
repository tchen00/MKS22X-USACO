import java.util.*;
import java.io.*;

public class USACO{
  public static int silver(String input) throws FileNotFoundException{
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

    return 0;
  }

  public static int gold(){
    return 0;
  }
}
