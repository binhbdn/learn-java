/*
https://practiceit.cs.washington.edu/problem/view/bjp5/chapter1/e12-FightSong
BJP5 Exercise 1.12: FightSong

Write a complete Java program in a class named FightSong that generates the following three figures of output. Use static methods to show structure and eliminate redundancy in your solution.

In particular, make sure that main contains no System.out.println statements, that any System.out.println statement(s) repeated are captured in a method that is called just once, and that the same System.out.println statement never appears in two places in the code.
Go, team, go!
You can do it.

Go, team, go!
You can do it.
You're the best,
In the West.
Go, team, go!
You can do it.

Go, team, go!
You can do it.
You're the best,
In the West.
Go, team, go!
You can do it.

Go, team, go!
You can do it.
*/
public class FightSong{
    public static void main(String[] args){
        FightSong_2();
        FightSong_4();
        FightSong_4();
        FightSong_1();
    }
    private static void FightSong_1(){
        System.out.println("Go, team, go!");
        System.out.println("You can do it.");
    }
    private static void FightSong_2(){
        FightSong_1();
        System.out.println();
    }
    private static void FightSong_3(){
        System.out.println("You're the best,");
        System.out.println("In the West.");
    }
    private static void FightSong_4(){
        FightSong_1();
        FightSong_3();
        FightSong_2();
    }
}