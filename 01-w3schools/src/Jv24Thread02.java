/*  Two ways to create a thread:
        1 - extend the Thread class and overriding its run() method
        2 - implement the Runnable interface

    Differences between "extending" and "implementing" Threads:
        "extending" :       cannot extend any other class
        "implementing" :    can extend from another class,
                            like: class MyClass extends OtherClass implements Runnable
*/

class Jv24Thread02  implements Runnable {
    public static void main(String[] args) {
        Jv24Thread02 obj = new Jv24Thread02();
        Thread thread = new Thread(obj);
        thread.start();
        System.out.println("This code is outside of the thread");
    }
    
    public void run() {
        System.out.println("This code is running in a thread");
    }
}