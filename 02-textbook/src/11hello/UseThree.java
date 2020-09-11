/*
https://introcs.cs.princeton.edu/java/11hello/UseThree.java.html

~$ javac UseThree.class

~$ java UseThree Binh Minh 'Tuan Anh'
~$ Hi, Tuan Anh, Minh and Binh. How are you?
 */

class UseThree {
  public static void main(String[] args){
    if (args.length >=3) {
      System.out.println("Hi, " + args[2] + ", " + args[1] + " and " + args[0] + ". How are you?");
    } else {
      System.out.println("Please input as least 3 arguments, for example: java UseThree Binh Minh 'Tuan Anh'");
    }
  }
}
