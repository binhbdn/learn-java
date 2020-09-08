public class Jv02Method {
  // void keyword : method should not return a value
  static void myMethod1(String fname, int age) {
    System.out.println(fname + " is " + age);
  }
  // method to return a value: use a primitive data type (such as int, char, etc.) instead of void
  static int myMethod2(int x, int y) {
    return x + y;
  }

  // Method Overloading
  static int plusMethod(int x, int y) {
    return x + y;
  }
  static double plusMethod(double x, double y) {
    return x + y;
  }

  // Recursion
  public static int sum(int start, int end) {
    if (end > start) {
      return end + sum(start, end - 1);
    } else {
      return end;
    }
  }

  public static void main(String[] args) {
    myMethod1("Liam", 5);
    myMethod1("Jenny", 8);
    myMethod1("Anja", 31);

    System.out.println(myMethod2(5, 3));

    int myNum1 = plusMethod(8, 5);
    double myNum2 = plusMethod(4.3, 6.26);
    System.out.println("int: " + myNum1);
    System.out.println("double: " + myNum2);

    System.out.println(sum(5, 10));
  }
}
