public class Threesum {
  public static void main(String[] args){
    int[] input_array = {-1, 1, 0, 3, 6};
    if_three(input_array);
  }
  public static void if_three (int[] input_array) {
    String result = "false";
    outerloop:
    for (int i = 0; i<= (input_array.length-1); i += 1){
      for (int j = i + 1; j<= (input_array.length-1); j += 1){
        for (int k = j + 1; k<= (input_array.length-1); k += 1){
          if (input_array[i] + input_array[j] + input_array[k] == 0)
            {result = "true";
            break outerloop;
            }
        }
      }
    }
  System.out.println(result);
  }
}
