public class Max {
  public static int max(){
    int[] input_array = {1,2,3,4,5};
    int x = input_array[0];
    for (int element:input_array){
      if (element>x)
      x = element;
    }
      System.out.println(x);
      return x;
  }

  public static void main(String[] args){
    max();
  }
}
