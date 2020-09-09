// Static Inner Class : can access inner class without creating an object of the outer class:
// static inner class does not have access to members of the outer class
class OuterClass3 {
    int x = 10;
    // static int x = 10;

    static class InnerClass {
        int y = 5;
        // int y = 5 + x;
    }
}

public class Jv10InnerClass03 {
    public static void main(String[] args) {
        OuterClass3.InnerClass myInner = new OuterClass3.InnerClass();
        System.out.println(myInner.y);
      }
}
