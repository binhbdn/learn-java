/*  Two ways to create a thread:
        1 - extend the Thread class and overriding its run() method
        2 - implement the Runnable interface

    Differences between "extending" and "implementing" Threads:
        "extending" :       cannot extend any other class
        "implementing" :    can extend from another class,
                            like: class MyClass extends OtherClass implements Runnable
*/

class Jv24Thread01  extends Thread {
    public static int amount = 0;

    public static void main(String[] args) {
        Jv24Thread01 thread = new Jv24Thread01();
        thread.start();

        // Wait for the thread to finish
        while(thread.isAlive()) {
            System.out.println("Waiting...");
        }

        // Update amount and print its value
        System.out.println("Main: " + amount);
        amount++;
        System.out.println("Main: " + amount);
    }

    public void run() {
        System.out.println("This code is running in a thread: 1st time");
        amount++;
        System.out.println("This code is running in a thread: 3rd time");
    }
}