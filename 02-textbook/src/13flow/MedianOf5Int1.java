// Write a program that takes five integer command-line arguments and prints the median
//(the third largest one)

class MedianOf5Int1 { 
  public static void main(String[] args) {
    int[] a = {0, 0, 0, 0, 0};
    int temp;

    for (int i = 0; i <= 4; i++) {a[i] = Integer.parseInt(args[i]);};
    
    // sort
    for (int i = 0; i <= 4; i++){
      for (int j = i+1; j <= 4; j++) {
        if (a[i] > a[j]) {
          temp = a[i];
          a[i] = a[j];
          a[j] = temp;
        }
      }
    }
    // result:
    System.out.println(a[2]);
  }
}
