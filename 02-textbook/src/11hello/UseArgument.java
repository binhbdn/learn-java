/*
https://introcs.cs.princeton.edu/java/11hello/UseArgument.java.html

~$ javac UseArgument.class

~$ java UseArgument Binh
~$ Hi, Binh. How are you?

~$ java UseArgument Binh Minh
~$ Hi, Binh and Minh. How are you?

~$ java UseArgument 'Binh, Minh' "Tuan Anh"
~$ Hi, Binh, Minh and Tuan Anh. How are you?
 */

class UseArgument {
  public static void main(String[] args) {
    System.out.print("Hi, ");
    System.out.print(args[0]);
    if (args.length > 1) {
      System.out.print(" and " + args[1]);
    };
    System.out.println(". How are you?");
  }
}
