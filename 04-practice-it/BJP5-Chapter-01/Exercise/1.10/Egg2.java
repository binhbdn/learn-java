/*
https://practiceit.cs.washington.edu/problem/view/bjp5/chapter1/e10-Egg2
BJP5 Exercise 1.10: Egg2

Write a complete Java program in a class named Egg2 that generates the following output. Use static methods to show structure and eliminate redundancy in your solution.
  _______
 /       \
/         \
\         /
 \_______/
-"-'-"-'-"-
  _______
 /       \
/         \
\         /
 \_______/
-"-'-"-'-"-
\         /
 \_______/
  _______
 /       \
/         \
-"-'-"-'-"-
\         /
 \_______/
*/
public class Egg2{
    public static void main(String[] args){
        SubEgg2Top();
        SubEgg2Bottom();
        SubEgg2Middle();
        SubEgg2Top();
        SubEgg2Bottom();
        SubEgg2Middle();
        SubEgg2Bottom();
        SubEgg2Top();
        SubEgg2Middle();
        SubEgg2Bottom();
    }
    private static void SubEgg2Top(){
        System.out.println("  _______");
        System.out.println(" /       \\");
        System.out.println("/         \\");
    }
    private static void SubEgg2Middle(){
        System.out.println("-\"-'-\"-'-\"-");
    }
    private static void SubEgg2Bottom(){
        System.out.println("\\         /");
        System.out.println(" \\_______/");
    }
}