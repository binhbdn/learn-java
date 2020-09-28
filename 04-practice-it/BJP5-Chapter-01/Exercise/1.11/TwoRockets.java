/*
https://practiceit.cs.washington.edu/problem/view/bjp5/chapter1/e11-TwoRockets
BJP5 Exercise 1.11: TwoRockets

Write a complete Java program in a class named TwoRockets that generates the following output. Use static methods to show structure and eliminate redundancy in your solution.
   /\       /\
  /  \     /  \
 /    \   /    \
+------+ +------+
|      | |      |
|      | |      |
+------+ +------+
|United| |United|
|States| |States|
+------+ +------+
|      | |      |
|      | |      |
+------+ +------+
   /\       /\
  /  \     /  \
 /    \   /    \
*/
public class TwoRockets{
    public static void main(String[] args){
        SubTwoRockets_1();
        SubTwoRockets_2();
        SubTwoRockets_3();
        SubTwoRockets_3();
        SubTwoRockets_2();
        SubTwoRockets_4("United");
        SubTwoRockets_4("States");
        SubTwoRockets_2();
        SubTwoRockets_3();
        SubTwoRockets_3();
        SubTwoRockets_2();
        SubTwoRockets_1();
    }
    private static void SubTwoRockets_1(){
        System.out.println("   /\\       /\\");
        System.out.println("  /  \\     /  \\");
        System.out.println(" /    \\   /    \\");
    }
    private static void SubTwoRockets_2(){
        System.out.println("+------+ +------+");
    }
    private static void SubTwoRockets_3(){
        System.out.println("|      | |      |");
    }
    private static void SubTwoRockets_4(String s){
        System.out.println("|"+s+"| |"+s+"|");
    }
}