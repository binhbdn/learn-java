/*
https://practiceit.cs.washington.edu/problem/view/bjp5/chapter1/e15-EggStop
BJP5 Exercise 1.15: EggStop

Write a complete Java program in a class named EggStop that generates the following output. Use static methods to show structure and eliminate redundancy in your solution.
  ______
 /      \
/        \
\        /
 \______/

  ______
 /      \
/        \
\        /
 \______/
+--------+

  ______
 /      \
/        \
|  STOP  |
\        /
 \______/
+--------+
*/
public class EggStop{
    public static void main(String[] args){
        EggStop_42();
        System.out.println();
        EggStop_42();
        EggStop_1();
        System.out.println();
        EggStop_4();
        EggStop_3();
        EggStop_2();
        EggStop_1();
    }
    private static void EggStop_1(){
        System.out.println("+--------+");
    }
    private static void EggStop_2(){
        System.out.println("\\        /");
        System.out.println(" \\______/");
    }
    private static void EggStop_3(){
        System.out.println("|  STOP  |");
    }
    private static void EggStop_4(){
        System.out.println("  ______");
        System.out.println(" /      \\");
        System.out.println("/        \\");
    }
    private static void EggStop_42(){
        EggStop_4();
        EggStop_2();
    }
}